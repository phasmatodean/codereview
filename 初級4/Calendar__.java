import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Calendar__ {
	public static void main(String[] argvs) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("カレンダーを出力します");

		try {
			// 年を入力する
			System.out.println("年を入力してください（例：2014）");
			int year = Integer.parseInt(reader.readLine());
			
			// 月を入力する
			System.out.println("月を入力してください（例：4）");
			int month = Integer.parseInt(reader.readLine());

			// カレンダーを表示する
			showCalender(year, month);
		} catch(NumberFormatException e) {
			System.out.println("数値の形式が正しくありません。");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	* 入力された年月からカレンダーを表示するメソッド
	* @param year 表示するカレンダーの年
	* @param month 表示するカレンダーの月
	*/
	public static void showCalender(int year, int month) {
		if(year <= 0) {
			System.out.println("年は自然数で入力してください");
		}
		
		if(month < 1 || month > 12) {
			System.out.println("月は１～１２の間で入力してください。");
			return;
		}

		Calendar cal = Calendar.getInstance();

		// カレンダーの年月日をセット
		cal.set(year, month - 1, 1);

		System.out.printf("%d年 %d月\n", year, month);
		System.out.println("日 月 火 水 木 金 土");

		// 一周目のズレ(offset)を先に解決
		int offset = cal.get(Calendar.DAY_OF_WEEK) - 1;
		for(int i = 0; i < offset; i++) {
			System.out.print("   ");
		}	

		// 日付を表示
		for(int j = 1; j <= cal.getActualMaximum(Calendar.DATE); j++) {
			System.out.printf("%2d ", j);
						
			if((offset + j) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	
	}
}
