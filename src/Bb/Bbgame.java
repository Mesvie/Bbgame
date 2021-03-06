package Bb;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bbgame {
	public static Scanner s; 
	public static int max_num = 3;
	  
	public static void main(String[] args) {
	s = new Scanner(System.in);
		int com[] = new int[max_num]; // 컴퓨터 값
		int user[] = new int[max_num]; // 유저 값
		 
		com = getRandomNum(com);
		while(true){
			if(baseballGame(com, user)) {
				System.out.println("you win!");
				System.out.println("새 게임을 시작합니다.");
				com = getRandomNum(com);
//				break;
			}
		}
	}//End main
	  
	//게임 진행 메서드
	public static boolean baseballGame(int[] com, int[] user){
		boolean win = false;
		int strike = 0; // 스트라이크 저장
		int ball = 0;
		user = getUserNum(user);
		strike = getStrike(com, user);
		ball = getBall(com, user);
		 
		System.out.println("strike: "+ strike+" ball: "+ball);
			if(strike == max_num){
				win = true;
		}
		return win;
	}//End baseballGame
	  
	  
	//com 숫자 배정.
	public static int[] getRandomNum(int[] com){
		Random r = new Random();
		     
		//com 숫자 랜덤 할당 및 중복제거 // +1 은 0이 나오는걸 방지하기 위해 
		com[0] = (int)r.nextInt(9)+1;
		com[1] = (int)r.nextInt(9)+1;
		com[2] = (int)r.nextInt(9)+1;
		 
		//중복제거
		while(com[0] == com[1]) {
			com[1] = (int)r.nextInt(9);
		}
		     
		while(com[0] == com[2] || com[1] == com[2]) {
			com[2] = (int)r.nextInt(9);
		}
		
		System.out.println(Arrays.toString(com));
		return com;
	}//End getRandomNum-
	  
	  
	  //user 입력 값
	public static int[] getUserNum(int[] user){
		System.out.println("3자리 숫자를 입력하세요.(중복불가)");
		System.out.print("입력:");
		int userInput = 0;
		userInput = s.nextInt();
		 
		user = intToArray(userInput);
		while(userInput<100 || userInput>999 || !checkUserDuplication(user)) {
			System.out.println("형식에 맞지 않습니다.");
			System.out.println("3자리 숫자를 입력해 주세요");
			System.out.print("입력:");
			userInput = s.nextInt();
			user = intToArray(userInput);
		}
		return user;
	}//End getUserNum
	
	  
	//user값 조건식 비교문
	public static boolean checkUserDuplication(int[] user){
		if(user[0] == user[1] || user[0] == user[2] || user[1] == user[2]) {
			return false;
		}
		else{
			return true;
		}       
	}//End checkUserDuplication
	   
	      
	//입력받은 user값 3자리 숫자 자르기
	public static int[] intToArray(int input){
		int[] array = new int[max_num];
		for(int i = 1; i <= array.length; i++){
			array[array.length - i] = input%10;
			input/=10;
		}
		return array;
	}//End intToArray
	                  
	//strike 체크
	public static int getStrike (int[] com, int[] user){
		int strike = 0;
		for(int i = 0; i < max_num ; i++){
			if(com[i] == user[i]){
				strike++;
			}
		} 
		return strike;
	}//End getStrike
	  
	  
	//ball 체크
	public static int getBall (int[] com, int[] user){
		int ball = 0;
		for(int i = 0; i < max_num ; i++){
			if(checkBall(i, com, user)){
				ball++;
			}
		}
		     
		return ball;
	}//End getball
	  
	  //ball 조건문
	public static boolean checkBall(int index, int[] com, int[] user){
		boolean isBall = false;
		for(int i = 0; i < max_num; i++){
			if(com[index]== user[i] && i!= index){
				isBall = true;
			}
		}
		return isBall;
	}//End chekBall
	  
      
}//End class