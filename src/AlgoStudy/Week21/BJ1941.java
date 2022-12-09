package AlgoStudy.Week21;

import java.util.Scanner;

public class BJ1941 {
	static String[] map;
	static int res = 0;
	static boolean[][] visited;
	static boolean[][] selected;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int S, Y;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		map = new String[5];
		for(int i = 0; i < 5; i++)
			map[i] = sc.nextLine();
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				selected = new boolean[5][5];
				selected[i][j] = true;
				combi(i, j, 1);
			}
		}
		
		System.out.println(res);
	}
	
	static void combi(int x, int y, int n) {
		if(n == 7) {
			visited = new boolean[5][5];
			S = 0;
			Y = 0;
			dfs(x, y);
			return;
		}
		for(int j = y+1; j < 5; j++) {
			selected[x][j] = true;
			combi(x, j, n+1);
			selected[x][j] = false;
		}
		for(int i = x+1; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				selected[i][j] = true;
				combi(i, j, n+1);
				selected[i][j] = false;
			}
		}
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;
		if(map[x].charAt(y) == 'S')
			S++;
		else
			Y++;
		
		if(S+Y == 7) {
			res++;
			return;
		}
		
		int nx, ny;
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
				continue;
			if(visited[nx][ny] == true || selected[nx][ny] == false)
				continue;
			// Y 가 4가 되면 continue;
			if(Y == 3 && map[nx].charAt(ny) == 'Y') 
				continue;
			
			dfs(nx, ny);
		}
	}
}
