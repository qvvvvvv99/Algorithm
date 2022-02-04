package FastCampus.Search;

// BJ 2667번 단지번호붙이기
// DFS
// return 사용 여부에 따라 그래프 끊김 현상??

import java.io.*;
import java.util.*;

public class BJ2667 {
	static int num;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+2][N+2];
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				if(line.charAt(j) == '1')
					map[i+1][j+1] = 1;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] == 1) {
					num = 0;
					dfs(i, j, map);
					list.add(num);
					cnt++;
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(cnt);
		for(int i = 0; i< list.size(); i++)
			System.out.println(list.get(i));
	}
	
	public static void dfs(int a, int b, int[][] map) {
		num++;
		map[a][b] = 0;
		
		int x, y;

		// 상
		x = b;
		y = a - 1;
		if (map[y][x] == 1)
			dfs(y, x, map);
		// 우
		x = b + 1;
		y = a;
		if (map[y][x] == 1)
			dfs(y, x, map);
		// 하
		x = b;
		y = a + 1;
		if (map[y][x] == 1)
			dfs(y, x, map);
		// 좌
		x = b - 1;
		y = a;
		if (map[y][x] == 1)
			dfs(y, x, map);
	}
}
