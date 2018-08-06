package Bb;

import java.util.Random;
import java.util.Scanner;

public class Bbgame {

	 public static Scanner s; 
	   
	   public static void main(String[] args) {
	      s = new Scanner(System.in);
	      int com[] = new int[3]; // ��ǻ�� ��
	      int user[] = new int[3]; // ���� ��
	      
	      com = getRandomNum(com);
	      while(true){
	         if(baseballGame(com, user)) {
	            System.out.println("you win!");
	            break;
	         }
	      }
	   }//End main
	   
	   
	   //com ���� ����.
	   public static int [] getRandomNum(int [] com){
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
	      return com;
	   }//End getRandomNum
	   
	   
	   //user �Է� ��
	   public static int [] getUserNum(int [] user){
	      System.out.println("3�ڸ� ���ڸ� �Է��ϼ���.(�ߺ��Ұ�)");
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
	   public static boolean checkUserDuplication(int [] user){
	      if(user[0] == user[1] || user[0] == user[2] || user[1] == user[2]) {
	         return false;
	      }
	      else{
	         return true;
	      }       
	   }//End checkUserDuplication
	
	   
	   //�Է¹��� user�� 3�ڸ� ���� �ڸ���
	   public static int [] intToArray(int input){
	      int [] array = new int[3];
	      for(int i = 1; i <= array.length; i++){
	         array[array.length - i] = input%10;
	         input/=10;
	      }
	      return array;
	   }//End intToArray
	   
	   
	   //���� ���� �޼���
	   public static boolean baseballGame(int [] com, int [] user){
	      boolean win = false;
	      int strike = 0; // ��Ʈ����ũ ����
	      int ball = 0;
	      user = getUserNum(user);
	      strike = getStrike(strike, com, user);
	      ball = getBall(ball, com, user);
	      
	      System.out.println("strike: "+ strike+" ball: "+ball);
	      if(strike == 3){
	         win = true;
	      }
	      return win;
	   }//End baseballGame
	   
	   
	   //strike üũ
	   public static int getStrike (int strike, int [] com, int [] user){
	      for(int i = 0; i< 3 ; i++){
	         if(com[i] == user[i]){
	            strike++;
	         }
	      } 
	      return strike;
	   }//End getStrike
	   
	   
	   //ball üũ
	   public static int getBall (int ball, int [] com, int [] user){
	      for(int i = 0; i< 3 ; i++){
	         if(checkBall(i, com, user)){
	            ball++;
	         }
	      }
	      
	      return ball;
	   }//End getball
	   
	   //ball ���ǹ�
	   public static boolean checkBall(int index, int [] com, int [] user){
	      boolean isBall = false;
	      for(int i =0; i<3; i++){
	         if(com[index]== user[i] && i!= index){
	            isBall = true;
	         }
	      }
	      return isBall;
	   }//End chekBall
	   
}//End class

