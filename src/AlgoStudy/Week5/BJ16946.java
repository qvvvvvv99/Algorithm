package AlgoStudy.Week5;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16946 {
	static int[] rotX = {-1, 0, 1, 0};
	static int[] rotY = {0, 1, 0, -1};
	static int N, M;
	static int[][] ary;
	static int[][] map;
	static int[][] group;
	static int[][] res;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ary = new int[N][M];
		res = new int[N][M];
		map = new int[N][M];
		group = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				ary[i][j] = line.charAt(j) - '0';
			}
		}
		
		bfs();

		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				if(ary[i][j] == 1) {
					int num = 1;
					int n = 0;
					int g;
					int[] gNum = new int[4];
					for(int r = 0; r < 4; r++) {
						int nx = i + rotX[r];
						int ny = j + rotY[r];
						if(nx < 0 || nx >= N || ny < 0 || ny >= M)
							continue;
						for(g = 0; g < n; g++) {
							if(group[nx][ny] == gNum[g])
								break;
						}
						if(g == n) {
							gNum[g] = group[nx][ny];
							num += map[nx][ny];
							n++;
						}
					}
					res[i][j] = num % 10;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				sb.append(res[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();	// bfs 탐색으로 0으로 인접한 길의 수를 파악
		Queue<Point> route = new LinkedList<>();	// 0으로 인접한 길을 파악하여 길의 수를 저장하고 같은 그룹으로 나타내기
		int cnt, nx, ny;
		Point p;
		int g = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j] == false && ary[i][j] == 0) {
					g++;
					cnt = 1;
					queue.add(new Point(i, j));
					route.add(new Point(i, j));
					visited[i][j] = true;
					
					while(!queue.isEmpty()) {
						p = queue.poll();
						for(int r = 0; r < 4; r++) {
							nx = p.x + rotX[r];
							ny = p.y + rotY[r];
							if(nx < 0 || nx >= N || ny < 0 || ny >= M)
								continue;
							if(visited[nx][ny] == false && ary[nx][ny] == 0) {
								visited[nx][ny] = true;
								queue.add(new Point(nx, ny));
								route.add(new Point(nx, ny));
								cnt++;
							}
						}
					}
					
					while(!route.isEmpty()) {
						p = route.poll();
						map[p.x][p.y] = cnt;
						group[p.x][p.y] = g; 
					}
				}
				
			}
		}
	}
}
