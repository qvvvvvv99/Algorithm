package BJAlgo.Level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10942 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		boolean[][] dp = new boolean[N][N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
			num[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N-1; i++) {
			dp[i][i] = true;
			if(num[i] == num[i+1])
				dp[i][i+1] = true;
		}
		dp[N-1][N-1] = true;
		
		for(int i = 2; i <= N -1; i++) {
			for(int j = 0; j < N-i; j++) {
				if(dp[j+1][j+i-1] && num[j]==num[j+i])
					dp[j][j+i] = true;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		int M = Integer.parseInt(br.readLine());
		int a, b;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			if(dp[a][b])
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		
		System.out.print(sb);
	}

}
