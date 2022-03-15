package FastCampus.DP;

import java.util.Scanner;

public class BJ11057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] ary = new int[N+1][10];
		for(int i = 0; i < 10; i++)
			ary[1][i] = 1;
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 9; k >= j; k--) {
					ary[i][j] += ary[i-1][k];
					ary[i][j]%=10007;
				}
			}
		}
		
		int sum = 0; 
		for(int i = 0; i < 10; i++)
			sum += ary[N][i];
		System.out.println(sum%10007);
	}

}
