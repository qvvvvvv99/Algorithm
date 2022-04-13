package BJAlgo.Level3;

import java.io.*;

public class BJ10026 {
	static int[] dirX = {1,0,-1,0};
	static int[] dirY = {0,1,0,-1};
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String line[] = new String[N];
		boolean visited[][] = new boolean[N][N];
		int cnt1 = 0, cnt2= 0;
		
		for(int i = 0; i < N; i++)
			line[i] = br.readLine();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == false) {
					dfs(i, j, line, visited);
					cnt1++;
				}
			}
		}
		
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++)
			line[i] = line[i].replace('G', 'R');
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == false) {
					dfs(i, j, line, visited);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1+" "+cnt2);
	}

	public static void dfs(int y, int x, String[] map, boolean[][] visited) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextX = x+dirX[i];
			int nextY = y+dirY[i];
			if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N)
				continue;
			if(visited[nextY][nextX] == false && map[y].charAt(x)== map[nextY].charAt(nextX))
				dfs(nextY, nextX, map, visited);
		}
	}
}
