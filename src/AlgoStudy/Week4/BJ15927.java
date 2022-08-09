package AlgoStudy.Week4;

import java.util.Scanner;

public class BJ15927 {
	static String str;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		str = sc.next();
		int len = -1;
		boolean palindrome = true;
		
		// 회문 판별
		for(int i = 0; i < str.length()/2; i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i)) {
				palindrome = false;
				// 1. 전체 배열이 회문이 아닐경우 전체 길이
				len = str.length();
				break;
			}		
		}
		
		// 2. 회문일 경우
		if(palindrome) {
			//	1) 모두 같은 문자이면 -1
			//  2) 같은 문자가 아니면 (전체 길이 -1)
			for(int i = 1; i < str.length(); i++) {
				if(str.charAt(0) != str.charAt(i)) {
					len = str.length()-1;
					break;
				}
			}
		}
		
		System.out.println(len);
		
	}

}
