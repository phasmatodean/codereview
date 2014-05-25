import java.util.Calendar;
import static java.util.Calendar.*;

public class Calender_v1 {
	static int year;
	static int month;
	static int dom;
	static int dow;

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		year = cal.get(YEAR);
		month = cal.get(MONTH) + 1;
		dom = cal.getActualMaximum(DAY_OF_MONTH);
		dow = cal.get(DAY_OF_WEEK);

		System.out.println("2014年のカレンダーを出力します");
		System.out.println(year + "年 " + month + "月");
		System.out.println("日 月 火 水 木 金 土");
  
  		makeCal();
	}

	/**
	*カレンダーの生成
	*
	*/
	public static void makeCal() {
		// 空白の個数を求める
        int voidNum;
        if (dow < SUNDAY) {
            voidNum = (dow + 7) - SUNDAY;
        } else {
            voidNum = dow - SUNDAY;
        }
		

		int day = 0;

        for (int i = 0; i < voidNum; i++) {
            System.out.print("   ");
            day++;
        }

        for (int j = 1; j <= dom; j++) {
            if (day < 6) {
                System.out.printf("%2d ", j);
            } else {
                System.out.printf("%2d%n", j);
            }
            day = ++day % 7;
        }
        System.out.println();
	}
}