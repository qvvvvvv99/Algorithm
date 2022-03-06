package BJAlgo.Level3;

import java.util.Scanner;

public class BJ2178 {
	static int[][] map;
	static int[] rotX = {1, 0, -1, 0};
	static int[] rotY = {0, 1, 0, -1}; 
	static int N, M;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N+1][M+1];
		boolean[][] visited = new boolean[N+1][M+1];
		int[][] dist = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			String line = sc.next();
			for(int j = 0; j < M; j++)
				map[i][j+1] = line.charAt(j)-'0';
		}
		
		dfs(1, 1, visited, dist, 0);
		
		System.out.println(dist[N][M]);
	}
	
	public static void dfs(int y, int x, boolean[][] visited, int[][] dist, int len) {
		dist[y][x] = len+1;
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int nextY = y+rotY[i];
			int nextX = x+rotX[i];
			if(nextY < 1 || nextY > N || nextX < 1 || nextX > M)
				continue;
			if(map[nextY][nextX] == 1 && visited[nextY][nextX] == false)
				dfs(nextY, nextX, visited, dist, dist[y][x]);
			else if(visited[nextY][nextX] == true && dist[nextY][nextX] > dist[y][x]+1)
				dfs(nextY, nextX, visited, dist, dist[y][x]);
		}
	}

}
