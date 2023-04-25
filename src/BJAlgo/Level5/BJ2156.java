package BJAlgo.Level5;

import java.util.Scanner;

public class BJ2156 {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
 
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
 
		for (int i = 1; i <= N; i++) {
			arr[i] = in.nextInt();
		}
 
		dp[1] = arr[1];
		if (N > 1) {
			dp[2] = arr[1] + arr[2];
		}
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
 
		}
		System.out.println(dp[N]);
	}
 
}