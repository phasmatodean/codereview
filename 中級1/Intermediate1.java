package intermediate;

public class Intermediate1 {
	/**
	 * 入力された値を2進数に変換
	 * @param i
	 * @return
	 * @throws IllegalArgumentException 入力された値が負の数だった場合
	 */
	public static String toBinaryString(int i) {
		String str = "";
		if(i < 0) {
			throw new IllegalArgumentException();
		}
		if(i == 0) {
			return "0";
		}
		for(;i != 0; i /= 2){
			str = i % 2 + str;
		}
		return str;
	}
}
