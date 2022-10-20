package AlgoStudy.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1956 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] map = new int[V + 1][V + 1];
		int INF = 4000001;
		for(int i = 1; i <= V; i++)
			Arrays.fill(map[i], INF);

		int a, b, c;
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map[a][b] = c;
		}
		
		// k : 지나갈 정점
		for(int k = 1; k <= V; k++) {
			// i : 출발점
			for(int i = 1; i <= V; i++) {
				// j : 도착점
				for(int j = 1; j <= V; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		int min = INF;
		for(int i = 1; i <= V; i++)
			min = Math.min(min, map[i][i]);
		if(min == INF)
			min = -1;
		
		System.out.println(min);
	}

}
