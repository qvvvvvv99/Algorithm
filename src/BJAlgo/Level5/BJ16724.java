package BJAlgo.Level5;

import java.util.Scanner;

public class BJ16724 {
	static int N, M;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] group, map;
	static boolean[][] visit;
	static int num = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		group = new int[N][M];
		visit = new boolean[N][M];
		
		String line;
		int dir = 0;
		for(int i = 0; i < N; i++) {
			line = sc.next();
			for(int j = 0; j < M; j++) {
				switch(line.charAt(j)){
				case 'U':
					dir = 0;
					break;
				case 'R':
					dir = 1;
					break;
				case 'D':
					dir = 2;
					break;
				case 'L':
					dir = 3;
					break;
				}
				map[i][j] = dir;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visit[i][j]) {
					num++;
					dfs(i, j);
					if(group[i][j] != num)
						merge(i, j);
				}
			}
		}
		
		System.out.println(num);
	}
	
	static void dfs(int x, int y) {
		visit[x][y] = true;
		group[x][y] = num;
		int dir = map[x][y];
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(visit[nx][ny]) {
			if(num != group[nx][ny])
				num--;
			return;
		}
		dfs(nx, ny);
	}

	static void merge(int x, int y) {
		group[x][y] = num;
		int dir = map[x][y];
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(group[nx][ny] != num)
			merge(nx, ny);
	}
}
