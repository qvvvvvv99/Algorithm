package BJAlgo.Level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14938 {
	final static int L = 10000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int[][] len = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			Arrays.fill(len[i], L);
			len[i][i] = 0;
		}
		int[] item = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		int u, v, l;
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			len[u][v] = l;
			len[v][u] = l;
		}
		
		// 플로이드 와샬
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				if(i == k)
					continue;
				for(int j = 1; j <= N; j++) {
					if(j == i || j == k)
						continue;
					if(len[i][j] > len[i][k]+len[k][j])
						len[i][j] = len[i][k]+len[k][j];
				}
			}
		}
		
		int max = 0;
		for(int i = 1; i <= N; i++) {
			int items = 0;
			for(int j = 1; j <= N; j++) {
				if(len[i][j] <= M)
					items += item[j];
			}
			max = Math.max(max, items);
		}
		
		System.out.println(max);
	}

}
