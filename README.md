package exam;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bbgame {
	static final int max = 3;

	public static void main(String[] args) {

		int[] com = new int[max];
		int[] user = new int[max];
		
		 Matching Mc = new Matching();
		
		com = getCom(com);
		
		while(true) {
			if(Mc.baseballGame(com, user)) {
				System.out.println("you win!");
				System.out.println("게임을 다시 시작합니다.");
				com = getCom(com);
//				break;
			}
		}
	}
	
	public static int[] getCom(int[] com) {
		Random r = new Random();
		
		int inputcom = 0;
		inputcom = r.nextInt(999)+100;
		
		com = cutArray(inputcom);
		
		for(int i=0; i<max; i++) {
			
		while(inputcom<100 || inputcom>999 ||  !duplicateCheck(com)) {
			inputcom = r.nextInt(999)+100;
			com = cutArray(inputcom);
			}
		}
		
//		System.out.println(Arrays.toString(com)); //->확인용
		return com;
	}
	
	/* 면접 때 시키셔서 했던 것.
	 * 	int[] rdcom = new int[max];
		
		HashSet<Integer> set = new HashSet(Arrays.asList(rdcom));
		
			while(set.size() < 3) { 
				set.add(r.nextInt(9)+1);
				System.out.println(set.size());
			}
	 */
	
	//------------------------------------------------

	public static int[] getUser(int[] user) {
		Scanner s= new Scanner(System.in);
		int input = 0;
		
		System.out.println("1~9까지의 숫자를 입력하세요.[중복불가]");
		input = s.nextInt();
		
		user = cutArray(input);
			
		while(input<100 || input>999 || !duplicateCheck(user)) {
			System.out.println("숫자를 잘못 입력하였습니다.");
			System.out.println("다시 입력하세요.");
			input = s.nextInt();
			user = cutArray(input);
		}
		return user;
	}
	
	//----------------------
	public static int[] cutArray(int input) {
		int[] Array = new int[max];
		
		for(int i=1; i<=Array.length; i++) {
			Array[Array.length - i] = input%10;
			input /= 10;
		}
		return Array;
	}
	
	//---------------------------
	public static boolean duplicateCheck(int[] check) {
		
		if(check[0] == check[1] || check[0] == check[2] || check[1] == check[2] 
				|| check[0] == 0 || check[1] == 0 || check[2] == 0) {
			return false;
		}else {
			return true;
		}
	}
	
}//End class

class Matching {

	public boolean baseballGame(int[] com, int[] user) {
		boolean win = false;
		int strike = 0;
		int ball = 0;
		
		user = Bbgame.getUser(user);
		strike = getStrike(com, user);
		ball = getBall(com, user);
		
		System.out.println("Strike : "+strike+" /Ball : "+ball);
		
		if(strike == Bbgame.max) {
			win = true;
		}
		
		return win;
	}
	
	public int getStrike(int[] com, int[] user) {
		int strike = 0;
		
		for(int i=0; i<Bbgame.max; i++) {
			if(com[i] == user[i]) {
				strike++;
			}
		}
		return strike;
	}
	
	public int getBall(int[] user, int[] com) {
		int ball = 0;

		for(int i=0; i<Bbgame.max; i++) {
			if(checkBall(i, user, com)) {
				ball++;
			}
		}
		return ball;
	}
	
	public boolean checkBall(int index,int[] user, int[] com) {
		
		boolean isball = false;
	
		for(int i=0; i<Bbgame.max; i++) {
			if(com[index] == user[i] && i !=index) {
				isball = true;
			}
		}
		return isball;
	}
}
