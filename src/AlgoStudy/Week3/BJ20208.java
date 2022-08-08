package AlgoStudy.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20208 {
	static int[][] map;
	static int N, M, H;
	static int max = 0;
	static int homeX = 0, homeY = 0;
	static int[][] mint = new int[10][2];
	static int mintCnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		boolean[] visited = new boolean[10];
		mintCnt = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					homeX = i;
					homeY = j;
				}
				if(map[i][j] == 2) {
					mint[mintCnt][0] = i;
					mint[mintCnt][1] = j;
					mintCnt++;
				}
			}
		}
		
		dfs(homeX, homeY, M, visited, 0, 0);
		
		System.out.println(max);
	}

	static void dfs(int x, int y, int m, boolean[] visited, int cnt, int num) {
		if(Math.abs(homeX - x) + Math.abs(homeY - y) <= m) {
			max = Math.max(max, cnt);
		}
		
		int nextX, nextY, len;
		for(int i = 0; i < mintCnt; i++) {
			nextX = mint[i][0];
			nextY = mint[i][1];
			len = Math.abs(nextX - x) + Math.abs(nextY - y);
			if(len <= m && visited[i] == false) {
				visited[i] = true;
				cnt++;
				dfs(nextX, nextY, m-len+H, visited, cnt, i);
				cnt--;
				visited[i] = false;
			}
		}
		
	}
}
