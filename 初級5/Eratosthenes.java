import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class Eratosthenes {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("素数リストを出力するプログラムです。");
		outputPrimes(inputNum());
	}
	
	/**
	 * 入力された値を数値に変換
	 * 
	 * @return inputNum 変換された数値
	 * @throws NumberFormatException 数値以外が入力された場合
	 * @throws IOException
	 */
	private static int inputNum() {
		System.out.println("リストの最大値を整数で入力してください。");
		String input;
		int inputNum = 0;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = bf.readLine();
			inputNum = Integer.parseInt(input);
			
		}
		catch(NumberFormatException e) {
			System.out.println("不正な値が入力されました。");
			System.exit(0);
		}
		catch(IOException e) {
			//例外出力
		}
		
		if(inputNum <= 0) {
			System.out.println("自然数を入力してください．");
			System.exit(0);
		}
		
		return inputNum;
	}
	
	
	/**
	 * 入力された値までの素数を表示
	 * @param max　入力値
	 */
	private static void outputPrimes(int max) {
		boolean[] prime = new boolean[max]; // 0 ~　maxまでを表す配列

		//一度配列の要素すべてにtrueを代入
		for (int i = 2; i < max; i++) {
			prime[i] = true;
		}
		
		//0,1番目を除く先頭の要素を素数とし、その素数の倍数番目の要素をfalseにしていく
		for (int i = 2; i < max; i++) {
			if (prime[i]) { 
				System.out.print(i + " ");
				for (int j = i + i; j < max; j += i) {
					prime[j] = false;
			
				}
			}
		}
	}

}
