package FastCampus.DP;

import java.io.*;
import java.util.StringTokenizer;

public class BJ11066 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < tc; i++) {
			int K = Integer.parseInt(br.readLine());
			int[] ary = new int[K+1];
			int[] sum = new int[K+1];
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for(int j = 1; j <= K; j++) {
				ary[j] = Integer.parseInt(st.nextToken());
				sum[j] = sum[j-1] + ary[j];
			}
			
			int[][] DP = new int[K+1][K+1];
			
			
			for(int j = 1; j < K; j++)
				DP[j][j+1] = ary[j]+ary[j+1];
			
			for(int j = 2; j <= K; j++) {
				for(int l = 1; l <= K-j; l++) {
					int min = Integer.MAX_VALUE;
					for(int m = l; m < l+j; m++) {
						if(DP[l][m] + DP[m+1][l+j] < min)
							min = DP[l][m] + DP[m+1][l+j];
					}
					DP[l][l+j] = sum[j+l] - sum[l-1] + min;
				}
			}
			
			sb.append(DP[1][K]+"\n");
		}
		
		br.close();
		System.out.print(sb);
	}

}
