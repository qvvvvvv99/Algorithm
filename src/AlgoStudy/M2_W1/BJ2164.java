package AlgoStudy.M2_W1;

import java.util.Scanner;

public class BJ2164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n == 1)
			System.out.println(1);
		else {
			int num = 1;
			int cnt = 0;
			while(n > num + Math.pow(2, cnt)) {
				num += Math.pow(2, cnt);
				cnt++;
			}
			
			System.out.println((n-num)*2);
		}
	}

}
