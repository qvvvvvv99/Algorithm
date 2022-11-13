package AlgoStudy.Week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2583 {
	static int M, N, K;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean[M][N];
		visited = new boolean[M][N];
		int group = 0;
		ArrayList<Integer> cnt = new ArrayList<>();
		
		int sx, sy, ex, ey;
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			sy = Integer.parseInt(st.nextToken());
			sx = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			ex = Integer.parseInt(st.nextToken());
			for(int x = sx; x < ex; x++) {
				for(int y = sy; y < ey; y++) {
					if(map[x][y])
						continue;
					map[x][y] = true;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] || visited[i][j])
					continue;
				cnt.add(bfs(i, j));
				group++;
			}
		}
		
		Collections.sort(cnt);
		System.out.println(group);
		for(int i = 0; i < group; i++)
			System.out.print(cnt.get(i)+" ");
	}
	
	static int bfs(int x, int y) {
		int cnt = 1;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int nx, ny;
			for(int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				if(nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if(map[nx][ny] || visited[nx][ny])
					continue;
				queue.add(new Point(nx, ny));
				visited[nx][ny] = true;
				cnt++;
			}
		}
		
		return cnt;
	}
}

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
