package AlgoStudy.Week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2206 {
	static int N, M;
	static int[][] map;
	static int INF = 1000001;
	static int answer = INF;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][][] visited;
	static int len[][][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) 
				map[i][j+1] = line.charAt(j) - '0';
		}
		len = new int[N+1][M+1][2];
		for(int i = 1; i <= N; i++) 
			for(int j = 1; j <= M; j++)
				for(int k = 0; k < 2; k++)
					Arrays.fill(len[i][j], INF);
		visited = new boolean[N+1][M+1][2];
		len[1][1][0] = 1;
		bfs();
		
		answer = Math.min(len[N][M][0], len[N][M][1]);
		if(answer == 1000001)
			answer = -1;
		System.out.println(answer);
	}
	
	static void bfs() {
		Queue<Info> queue = new LinkedList<>();
		queue.add(new Info(1, 1, false));
		
		int nx, ny;
		while(!queue.isEmpty()) {
			Info curr = queue.poll();
			for(int i = 0; i < 4; i++) {
				nx = curr.x + dx[i];
				ny = curr.y + dy[i];
				if(nx <= 0 || nx > N || ny <= 0 || ny > M)
					continue;
				if(curr.block == false) {
					if(map[nx][ny] == 1) {
						if(visited[nx][ny][1] == false) {
							visited[nx][ny][1] = true;
							len[nx][ny][1] = len[curr.x][curr.y][0]+1;
							queue.add(new Info(nx, ny, true));
						}
					}else {
						if(visited[nx][ny][0] == false) {
							visited[nx][ny][0] = true;
							len[nx][ny][0] = len[curr.x][curr.y][0] + 1;
							queue.add(new Info(nx, ny, false));
						}
					}
				}
				else {
					if(map[nx][ny] == 1)
						continue;
					if(visited[nx][ny][1] == true)
						continue;
					visited[nx][ny][1] = true;
					len[nx][ny][1] = len[curr.x][curr.y][1] + 1;
					queue.add(new Info(nx, ny, true));
				}
			}
		}
	}
}

class Info{
	int x;
	int y;
	boolean block;
	
	Info(int x, int y, boolean block){
		this.x = x;
		this.y = y;
		this.block = block;
	}
}
