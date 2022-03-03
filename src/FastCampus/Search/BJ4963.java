package FastCampus.Search;

import java.io.*;
import java.util.*;

public class BJ4963 {
	static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int c, r;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			c = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			if(r == 0 && c == 0) {
				br.close();
				break;
			}
			int[][] map = new int[r][c];
			boolean[][] check = new boolean[r][c];
			for(int i = 0; i < r; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				for(int j = 0; j < c; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(check[i][j] == false && map[i][j] == 1) {
						dfs(i, j, map, check);
						cnt++;
					}
				}
			}
//			System.out.println(cnt);
			sb.append(cnt+"\n");
		}
		
		System.out.print(sb);
	}
	
	public static void dfs(int y, int x, int[][] map, boolean[][] check) {
		check[y][x] = true;
		
		for(int i = 0; i < 8; i++) {
			int nextY=y+dirY[i];
			int nextX=x+dirX[i];
			if(nextY < 0 || nextY == r || nextX < 0 || nextX == c)
				continue;
			if(check[nextY][nextX] == false && map[nextY][nextX] == 1)
				dfs(nextY, nextX, map, check);
		}
	}
}
