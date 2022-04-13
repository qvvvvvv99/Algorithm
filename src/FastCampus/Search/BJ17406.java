package FastCampus.Search;

import java.io.*;
import java.util.*;

public class BJ17406 {
	static int N, M, K;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] rotate = new int[K][3];
		boolean[] visited = new boolean[K];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			st = new StringTokenizer(line);
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < K; i++) {
			String line = br.readLine();
			st = new StringTokenizer(line);
			for(int j = 0; j < 3; j++)
				rotate[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < K; i++) {
			int[][] newMap = dublicateMap(map);
			visited = new boolean[K];
			rotateMap(i, 1, newMap, rotate, visited);
		}
		
		System.out.println(min);
	}
	
	public static void rotateMap(int n, int cnt, int[][] map, int[][] rotate, boolean[] visited) {
		visited[n] = true;
		map[0][0] = 5;
		
		for(int i = 1; i <= rotate[n][2]; i++) {
			
		}
		
		for(int i = 0; i < K; i++) {
			if(i == n)
				continue;
			
		}
	}
	
	public static int[][] dublicateMap(int[][] map){
		int[][] newMap = new int[N][M];
		
		for(int i = 0; i < N; i++)
			System.arraycopy(map[i], 0, newMap[i], 0, M);
		return newMap;
	}
}
