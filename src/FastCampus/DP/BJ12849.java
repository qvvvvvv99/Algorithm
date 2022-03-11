package FastCampus.DP;

import java.util.Scanner;

public class BJ12849 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] DP = {1,0,0,0,0,0,0,0};
		
		for(int i = 0; i < n; i++)
			next(DP);
		
		System.out.println(DP[0]);
	}
	
	public static void next(long DP[]) {
		long temp[] = new long[8];
		
		temp[0] = DP[1] + DP[2];
		temp[1] = DP[0] + DP[2] + DP[3];
		temp[2] = DP[0] + DP[1] + DP[3] + DP[4];
		temp[3] = DP[1] + DP[2] + DP[4] + DP[5];
		temp[4] = DP[2] + DP[3] + DP[5] + DP[7];
		temp[5] = DP[3] + DP[4] + DP[6];
		temp[6] = DP[5] + DP[7];
		temp[7] = DP[4] + DP[6];
		for(int i = 0; i < 8; i++) {
			temp[i] %= 1000000007;
			DP[i] = temp[i];
		}
	}

}
