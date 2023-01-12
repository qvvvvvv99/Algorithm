package AlgoStudy.M1_W2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ14466 {
	static int N, K, R, cnt;
	static boolean[][] map, visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Road> roads = new ArrayList<>();
	static int res = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new boolean[N+1][N+1];
		visited = new boolean[N+1][N+1];
		int x1, y1, x2, y2;
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			roads.add(new Road(x1, y1, x2, y2));
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			map[x1][y1] = true;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(!visited[i][j]) {
					cnt = 0;
					dfs(i, j);
					res += cnt * (K-cnt);
				}
			}
		}
		
		System.out.println(res/2);
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		if(map[x][y])
			cnt++;
		
		int nx, ny;
		for(int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx < 1 || nx > N || ny < 1 || ny > N || visited[nx][ny])
				continue;
			boolean flag1 = roads.contains(new Road(x, y, nx, ny));
			boolean flag2 = roads.contains(new Road(nx, ny, x, y)); 
			if(flag1 || flag2)
				continue;
			dfs(nx, ny);
		}
	}

}

class Road{
	int x1, y1, x2, y2;
	
	Road(int x1, int y1, int x2, int y2){
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	@Override	
	public boolean equals(Object object) {
		Road road = (Road) object;
		
		if(road.x1 != this.x1)
			return false;
		if(road.y1 != this.y1)
			return false;
		if(road.x2 != this.x2)
			return false;
		if(road.y2 != this.y2)
			return false;
		return true;
	}
}
