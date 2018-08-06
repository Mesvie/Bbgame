package Bb;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Bbgame {
	public static Scanner s; 
	public static int max_num = 3;
	  
	public static void main(String[] args) {
	s = new Scanner(System.in);
		int com[] = new int[max_num]; // ��ǻ�� ��
		int user[] = new int[max_num]; // ���� ��
		 
		com = getRandomNum(com);
		while(true){
			if(baseballGame(com, user)) {
				System.out.println("you win!");
				System.out.println("�� ������ �����մϴ�.");
				com = getRandomNum(com);
//				break;
			}
		}
	}//End main
	  
	//���� ���� �޼���
	public static boolean baseballGame(int[] com, int[] user){
		boolean win = false;
		int strike = 0; // ��Ʈ����ũ ����
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
	  
	  
	//com ���� ����.
	public static int[] getRandomNum(int[] com){
		Random r = new Random();
		     
		//com ���� ���� �Ҵ� �� �ߺ����� // +1 �� 0�� �����°� �����ϱ� ���� 
		com[0] = (int)r.nextInt(9)+1;
		com[1] = (int)r.nextInt(9)+1;
		com[2] = (int)r.nextInt(9)+1;
		 
		//�ߺ�����
		while(com[0] == com[1]) {
			com[1] = (int)r.nextInt(9);
		}
		     
		while(com[0] == com[2] || com[1] == com[2]) {
			com[2] = (int)r.nextInt(9);
		}
		
		//System.out.println(Arrays.toString(com)) <--com ������ Ȯ�ο�
		return com;
	}//End getRandomNum
	  
	  
	  //user �Է� ��
	public static int[] getUserNum(int[] user){
		System.out.println("3�ڸ� ���ڸ� �Է��ϼ���.(�ߺ��Ұ�)");
		System.out.print("�Է�:");
		int userInput = 0;
		userInput = s.nextInt();
		 
		user = intToArray(userInput);
		while(userInput<100 || userInput>999 || !checkUserDuplication(user)) {
			System.out.println("���Ŀ� ���� �ʽ��ϴ�.");
			System.out.println("3�ڸ� ���ڸ� �Է��� �ּ���");
			System.out.print("�Է�:");
			userInput = s.nextInt();
			user = intToArray(userInput);
		}
		return user;
	}//End getUserNum
	
	  
	//user�� ���ǽ� �񱳹�
	public static boolean checkUserDuplication(int[] user){
		if(user[0] == user[1] || user[0] == user[2] || user[1] == user[2]) {
			return false;
		}
		else{
			return true;
		}       
	}//End checkUserDuplication
	   
	      
	//�Է¹��� user�� 3�ڸ� ���� �ڸ���
	public static int[] intToArray(int input){
		int[] array = new int[max_num];
		for(int i = 1; i <= array.length; i++){
			array[array.length - i] = input%10;
			input/=10;
		}
		return array;
	}//End intToArray
	                  
	//strike üũ
	public static int getStrike (int[] com, int[] user){
		int strike = 0;
		for(int i = 0; i < max_num ; i++){
			if(com[i] == user[i]){
				strike++;
			}
		} 
		return strike;
	}//End getStrike
	  
	  
	//ball üũ
	public static int getBall (int[] com, int[] user){
		int ball = 0;
		for(int i = 0; i < max_num ; i++){
			if(checkBall(i, com, user)){
				ball++;
			}
		}
		     
		return ball;
	}//End getball
	  
	  //ball ���ǹ�
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


