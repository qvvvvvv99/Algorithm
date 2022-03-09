package FastCampus.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2167 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] ary = new int[N+1][M+1];
		int[][] sum = new int[N+1][M+1];
		StringBuffer sb = new StringBuffer();
		
		for(int i = 1; i <= N; i++) {
			line = br.readLine();
			st = new StringTokenizer(line);
			sum[i][0] = sum[i-1][M];
			for(int j = 1; j <= M; j++) {
				ary[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + ary[i][j];
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int l = 0; l < K; l++) {
			line = br.readLine();
			st = new StringTokenizer(line);
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int res = sum[x][y] - sum[x][j-1] - sum[i-1][y] + sum[i-1][j-1];
			sb.append(res+"\n");
		}
		
		System.out.print(sb);
	}

}
