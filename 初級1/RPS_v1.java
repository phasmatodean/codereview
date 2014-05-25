import java.io.*;


public class RPS_v1 {
	static String inputStr;	//インプット文字列
	static int myRPS;	//自分の出し手の数値
	static int rivalRPS;	//相手の出し手の数値

	public static void main(String[] args) { 
		System.out.println("じゃんけんをしましょう！");
		System.out.println("1: グー、2: チョキ、3: パー です。");
		System.out.println("じゃーんけーん・・");
		System.out.print("出す手を入力 => ");

		rivalRPS = rival_RPS();
		try {
			BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
        	inputStr = input.readLine( );

        	myRPS = Integer.parseInt(inputStr);

        	if(myRPS == 1 || myRPS == 2 || myRPS == 3) {
	        	System.out.println("ぽん！");
	        	System.out.println("あなた：" + rpsStr(myRPS) + "、コンピュータ：" + rpsStr(rivalRPS));
	        	judge_RPS(myRPS, rivalRPS);
	        }
	        else {
	        	System.out.println("1～3で入力してください！");
	        }

		}
		catch(IOException e) {
			System.out.println("例外" + e + "が発生しました");
		}
		catch(NumberFormatException e) {
			System.out.println("1～3で入力してください！");
		}


	}


	//相手の出し手をランダムで処理
	static int rival_RPS(){
		int a = (int)(Math.random() * 3) + 1;
		return a;

	}



	//数字をグーチョキパーの文字列に変換
	static String rpsStr(int a) {
		String result = "";
		switch(a) {
			case 1:
				result = "グー";
				break;

			case 2:
				result = "チョキ";
				break;

			case 3:
				result = "パー";
				break;

			default:
				System.out.println("文字変換エラー");
				break;

		}

		return result;
	}

	//じゃんけんの結果を判定
	static void judge_RPS(int mine, int enemy) {
		int result = 0;
		if(mine == enemy) {
			result = 3;
		}
		else if(mine > enemy || (mine == 1 && enemy == 3)) {
			result = 2;
		}

		else if(mine < enemy || (mine == 3 && enemy == 1)){
			result = 1;
		}

		resultOut(result);
	}

	//じゃんけんの結果を出力
	static void resultOut(int b) {
		switch(b) {
			case 1:
				System.out.println("あなたの勝ちです！");
				break;
			case 2:
				System.out.println("あなたの負けです！");
				break;
			case 3:
				System.out.println("あいこでした！");
			default:

				break;
		}
		
	}

}