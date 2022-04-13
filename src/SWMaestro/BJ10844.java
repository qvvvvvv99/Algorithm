package SWMaestro;

import java.util.Scanner;

public class BJ10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		long mod = 1000000000;
		long[][] dp = new long[N + 1][10];
		
		// 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 경우의 수가 1개밖에 없음 
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1; 
		}
				
		// 두 번째 자릿수부터 N까지 탐색 
		for(int i = 2; i <= N; i++) {
					
			// i번째 자릿수의 자릿값들을 탐색 (0~9) 
			for(int j = 0; j < 10; j++) {
						
				// j=0, 즉 자릿값이 0이라면 이전 자릿수의 첫번째 자릿수만 가능 
				if(j == 0) {
					dp[i][0] = dp[i - 1][1]%mod;
				}
				// j=9라면 이전 자릿수는 8만 가능
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8]%mod;
				}
				// 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨 
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])%mod;
				}
			}
		}
		
		long sum = 0;
		for(int i = 0; i < 10; i++)
			sum+=dp[N][i];
		
		System.out.println(sum%mod);
	}

}
