package FastCampus.DP;

import java.util.Scanner;

public class LC_PaintFence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(PaintFence(n, k));
	}
	
	public static int PaintFence(int n, int k) {
		int[] dp = new int[n];
		dp[0] = k;
		
		if(n > 1)
			dp[1] = k*k;
		
		for(int i = 2; i < n; i++) 
			dp[i] = (k-1)*dp[i-1] + (k-1)*dp[i-2];
		
		
		return dp[n-1];
	}

}
