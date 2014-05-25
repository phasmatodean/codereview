
public class Histgram {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		makeHistgram(args);
	}
	
	
	/**
	 * 入力された引数をint型の配列に格納
	 * 
	 * @param args　入力された値
	 * @return array int型に変換後の配列
	 * @throws 引数の値が数値以外だった場合
	 */
	private static int[] toIntArray(String[] args){
		//引数が入力されていない場合
		if(args.length == 0) {
			System.out.println("グラフにプロットする値を引数に指定してください。\n例）java Histogram 1 2 3 3 2 1");
			System.exit(0);
		}
		
		int[] array = new int[args.length];
		
		try {
			for(int i = 0; i < args.length; i++) {
				array[i] = Integer.parseInt(args[i]);
				if(array[i] < 0) {
					System.out.println("引数に指定できるのは正の数だけです。");
					System.exit(0);
				}
			}
		}
		catch(NumberFormatException e) {
			System.out.println("引数に指定できるのは数値のみです。");
			System.exit(0);
		}
		
		return array;
	}
	
	
	/**
	 * 配列の要素の最大値を取得
	 * 
	 * @param array int型の配列
	 * @return max 配列の要素の最大値
	 */
	private static int getMaxNum(int[] array) {
		int max = 0;
		for(int i = 0; i < array.length; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}
	

	/**
	 * 入力された値のヒストグラムを作成
	 * 
	 * @param args 入力された値
	 */
	private static void makeHistgram(String[] args) {
		int[] array = toIntArray(args);
		int max = getMaxNum(array);
		for(; max > 0; max--) {
			for(int j = 0; j < array.length; j++) {
				if(array[j] >= max) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
