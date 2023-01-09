package SWEA;

import java.util.Scanner;

public class pre1 {
	
	static int res, R, C;
	static String[] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		
		for(int T = 1; T <= tc ; T++) {
			res = 1;
			R = sc.nextInt();
			C = sc.nextInt();
			map = new String[R];
			boolean[][] visited = new boolean[R][C];
			boolean[] alpha = new boolean[26];
			
			for(int i = 0; i < R; i++) 
				map[i] = sc.next();
			
			visited[0][0] = true;
			alpha[map[0].charAt(0)-'A'] = true;
			dfs(0, 0, 1, visited, alpha);
			
			sb.append("#"+T+" "+res+"\n");
		}
		System.out.print(sb);
	}

	static void dfs(int r, int c, int cnt, boolean[][] visited, boolean[] alpha) {
		res = Math.max(cnt, res);

		int nx, ny;
		for(int i = 0; i < 4; i++) {
			nx = r + dx[i];
			ny = c + dy[i];
			if(nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny])
				continue;
			if(!alpha[map[nx].charAt(ny)-'A']) {
				alpha[map[nx].charAt(ny)-'A'] = true;
				visited[nx][ny] = true;
				cnt++;
				dfs(nx, ny, cnt, visited, alpha);
				cnt--;
				visited[nx][ny] = false;
				alpha[map[nx].charAt(ny)-'A'] = false;
			}
		}
	}
}