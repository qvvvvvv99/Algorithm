package AlgoStudy.Week13;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ20058 {
	static int N2, Q;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int max = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		N2 = (int) Math.pow(2, N);
		int[][] A = new int[N2][N2];
		int[] L = new int[Q];
		
		for(int i = 0; i < N2; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N2; j++) 
				A[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Q; i++)
			L[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < Q; i++) {
			A = rotate(i, A, L);
		}

		int sum = 0;
		for(int i = 0; i < N2; i++) {
			for(int j = 0; j < N2; j++) {
				sum += A[i][j];
			}
		}
		
		boolean[][] visited = new boolean[N2][N2];
		
		for(int i = 0; i < N2; i++) {
			for(int j = 0; j < N2; j++) {
				if(A[i][j] > 0 && visited[i][j] == false) 
					bfs(A, visited, i, j);
			}
		}
		
		System.out.println(sum);
		System.out.println(max);
	}

	static int[][] rotate(int n, int[][] A, int[] L){
		int[][] newA = new int[N2][N2];
		int devide = (int) (N2 / Math.pow(2, L[n]));
		int len = N2 / devide;
		
		for(int r = 0; r < devide; r++) {
			for(int c = 0; c < devide; c++) {
				for(int i = 0; i < len; i++) {
					for(int j = 0; j < len; j++) {
						newA[j + len * r][len * c + len - i - 1] = A[i + len * r][j + len * c];
					}
				}
			}
		}
		
//		for(int i = 0; i < N2; i++) {
//			for(int j = 0; j < N2; j++) {
//				System.out.print(newA[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
		ArrayList<Integer> minus = new ArrayList<>();
		for(int i = 0; i < N2; i++) {
			for(int j = 0; j < N2; j++) {
				int cnt = 0;
				for(int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if(nx < 0 || nx >= N2 || ny < 0 || ny >= N2)
						continue;
					if(newA[nx][ny] > 0)
						cnt++;
				}
				if(cnt < 3)
					minus.add(i * N2 + j);
			}
		}
		
		while(!minus.isEmpty()) {
			int idx = minus.remove(0);
			if(newA[idx/N2][idx%N2] > 0)
				newA[idx/N2][idx%N2]--;
		}
		
		return newA;
	}
	
	static void bfs(int[][] A, boolean[][] visited, int x, int y) {
		visited[x][y] = true;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x, y));
		int cnt = 1;
		int nx, ny;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i = 0; i < 4; i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				if(nx < 0 || nx >= N2 || ny < 0 || ny >= N2)
					continue;
				if(visited[nx][ny] == false && A[nx][ny] > 0) {
					cnt++;
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		max = Math.max(max, cnt);
	}
}
