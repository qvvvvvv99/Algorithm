package BJAlgo.Level4;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14502 {
	static int N, M;
	static int[][] map;
	static int max = 0;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sol();
		
		System.out.println(max);
	}

	static void sol() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					makeBlock(i, j, 1);
					map[i][j] = 0;
				}
			}
		}
	}

	static void makeBlock(int x, int y, int cnt) {
		if(cnt == 3) {
			counting();
			return;
		}
		
		for(int j = y+1; j < M; j++) {
			if(map[x][j] == 0) {
				map[x][j] = 1;
				cnt++;
				makeBlock(x, j, cnt);
				cnt--;
				map[x][j] = 0;
			}
		}
		
		for(int i = x + 1; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					cnt++;
					makeBlock(i, j, cnt);
					cnt--;
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void counting() {
		boolean[][] visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 2 && !visited[i][j])
					bfs(i,j, visited);
			}
		}
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] == 0)
					cnt++;
			}
		}
		
		max = Math.max(max, cnt);
		return;
	}
	
	static void bfs(int x, int y, boolean[][] visited) {
		Queue<Point> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.add(new Point(x, y));
		
		while(!queue.isEmpty()) {
			Point curr = queue.poll();
			int nx, ny;
			for(int i = 0; i < 4; i++) {
				nx = curr.x + dx[i];
				ny = curr.y + dy[i];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if(visited[nx][ny] || map[nx][ny] == 1)
					continue;
				visited[nx][ny] = true;
				queue.add(new Point(nx, ny));
			}
		}
	}
}
