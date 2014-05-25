package intermediate;

import java.util.LinkedList;

public class Intermediate2 {
	
	/**
	 * 入力された配列の隣り合う要素の重複を取り除く
	 * @param src 入力された配列
	 * @return list2Array(array)　変換後の配列
	 */
	public static int[] uniq(int[] src) {
		LinkedList<Integer> array = new LinkedList<>(); 
		
//		nullが入力されるとNullPointerExceptionを投げる
		if(src == null) {
			throw new NullPointerException();
		}
//		配列の長さが１以下なら入力された配列のコピーを返す
		else if(src.length <= 1) {
			return src.clone();
		}
		
//		入力された配列の要素をLinkedListに代入
		for(int i = 1; i < src.length; i++) {
			array.add(src[i]);
		}
		
//		リストの隣り合う要素の重複を取り除く
		int index = 1;	//比較する要素のインデックス
		while(index < array.size()) {
			if(array.get(index - 1) == array.get(index)) {
				array.remove(index);
			}
			else {
				index++;
			}
		}
		
		return list2Array(array);
		
	}
	
	
	/**
	 * リストを配列に変換して返す
	 * 
	 * @param array 
	 * @return	returnArray 返還後の配列
	 */
	public static int[] list2Array(LinkedList<Integer> array) {
		int[] returnArray = new int[array.size()];
		for(int j = 0; j < array.size(); j++) {
			returnArray[j] = array.get(j);
		}
		
		return returnArray;
	}
}
