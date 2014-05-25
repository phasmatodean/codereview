import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RPS_ {

	static final int GOO = 1;
	static final int CHOKI = 2;
	static final int PAR = 3;
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("じゃんけんをしましょう！");
		System.out.println("1: グー、2: チョキ、3: パー です。");
		System.out.println("じゃーんけーん・・");
		
		new RPS_();
	}
	
	private RPS_() {
		do_RPS(my_RPS(), rival_RPS());
	}
	
	
	/**
	 * 自分の出し手を処理
	 * 
	 * @return　myHand 自分の出し手
	 */
	private int my_RPS() {
		int rps = 0;
		
		boolean isNum = false;
		while(!isNum) {
			System.out.print("出す手を入力 => ");
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

			try {
				rps = Integer.parseInt(input.readLine());
				if (1 <= rps && rps <= 3) {
					isNum = true;
				} else {
					System.out.println("１〜３で入力してください！");
				}
			} catch (IOException e) {
				System.out.println("例外" + e + "が発生しました");
			} catch (NumberFormatException e) {
				System.out.println("1~3で入力してください");
			}
		}
		
		return rps;
	}
	
	/**
	 * 相手の出し手をランダムで処理
	 * @return enemyHand 
	 */
	private int rival_RPS() {
		int enemyHand = (int) (Math.random() * 3) + 1;
		return enemyHand;
	}
	
	
	
	/**
	 * じゃんけんを実行する処理
	 * @param my　自分の出し手
	 * @param rival　敵の出し手
	 */
	private void do_RPS(int my, int rival) {
		System.out.println("ぽん！");
		System.out.println("あなた：" + int2Hand(my) + "、コンピュータ：" + int2Hand(rival));
		if (my == rival) {
			System.out.println("あーいこーで・・");
			do_RPS(my_RPS(), rival_RPS());
		} else {
			System.out.println(((my - rival) == -1 || (my - rival) == 2) ? "あなたの勝ちです。" : "あなたの負けです。");
		}
		
	}
	
	/**
	 * 数値を該当するじゃんけんの出し手の名前に変換
	 * @param num　入力値
	 * @return hand 出し手の名前
	 */
	private String int2Hand(int num) {
		String hand = "";
		switch(num) {
			case GOO:
				hand = "グー";
				break;
			case CHOKI:
				hand = "チョキ";
				break;
			case PAR:
				hand = "パー";
				break;
		}
		return hand;
	}

}
