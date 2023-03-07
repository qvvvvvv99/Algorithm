package BJAlgo.Level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BHJ17404 {
	static int INF = 1000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] cost = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++)
				cost[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int res = INF;
		int[][] map = new int[N][3];
		for(int color = 0; color < 3; color++) {
			for(int i = 0; i < N; i++)
				Arrays.fill(map[i], INF);
			map[0][color] = cost[0][color];
			for(int i = 1; i < N-1; i++) {
				for(int j = 0; j < 3; j++) {
					int min = INF;
					for(int k = 0; k < 3; k++) {
						if(j == k)
							continue;
						min = Math.min(min, map[i-1][k]);
					}
					map[i][j] = min + cost[i][j];
				}
			}
			for(int j = 0; j < 3; j++) {
				if(j == color)
					continue;
				int min = INF;
				for(int k = 0; k < 3; k++) {
					if(j == k)
						continue;
					min = Math.min(min, map[N-2][k]);
				}
				map[N-1][j] = min + cost[N-1][j];
			}
			
			int temp = INF;
			for(int i = 0; i < 3; i++) {
				if(i == color)
					continue;
				temp = Math.min(temp, map[N-1][i]);
			}
			
			res = Math.min(res, temp);
		}
		
		System.out.println(res);
	}

}
