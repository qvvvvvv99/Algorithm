package BJAlgo.Level3;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16236 {
	static int n;
	static int size = 2, res = 0, cnt = 0;
	static int[] rotateX = {0, -1, 1, 0};
	static int[] rotateY = {-1, 0, 0, 1};
	static boolean[][] visited;
	static int[][] time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		int x = 0, y = 0;
	
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					x = j;
					y = i;
				}
			}
		}
		
		bfs(y, x, map);
		
		System.out.println(res);
	}
	
	public static void bfs(int rootY, int rootX, int[][] map) {
		visited = new boolean[n][n];
		time = new int[n][n];
		time[rootY][rootX] = 0;
		Queue<Point> queue = new LinkedList<Point>();
		map[rootY][rootX] = 0;
		visited[rootY][rootX] = true;
		queue.add(new Point(rootX, rootY));
		
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			if(map[y][x] > 0 && map[y][x] < size) {
				while(!queue.isEmpty()){
					temp = queue.poll();
					int nx = temp.x;
					int ny = temp.y;
					if(map[ny][nx] != 0 && map[ny][nx] < size) {
						if(time[ny][nx] == time[y][x]) {
							if(ny < y) {
								x = nx;
								y = ny;
							}
							else if(ny == y) {
								if(nx < x) {
									x = nx;
									y = ny;
								}
							}
						}
					}
				}
				res += time[y][x];
				cnt++;
				if(cnt == size) {
					size++;
					cnt = 0;
				}
//				System.out.println(y + " " + x);
				bfs(y,x,map);
			}
			
			for(int i = 0; i < 4; i++) {	
				int nextX = x + rotateX[i];
				int nextY = y + rotateY[i];
				if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
					continue;
				if(map[nextY][nextX] <= size && visited[nextY][nextX] == false) {
					queue.add(new Point(nextX, nextY));
					visited[nextY][nextX] = true;
					time[nextY][nextX] = time[y][x] + 1;
				}
			}
		}
	}
	
}
