package BJAlgo.Level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17144 {
	static int R, C, T;
	static int[][] map;
	static int[][] diffusion;
	static boolean[][] dust;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int X;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		dust = new boolean[R][C];
		diffusion = new int[R][C];
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) 
					X = i;
			}
		}
		
		for(int t = 1; t <= T; t++) {
			checkDust();
			FineDust();
			AirRefresh();
		}
		
		int res = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0)
					res += map[i][j];
			}
		}
		
		System.out.println(res);
	}
	
	static void checkDust() {
		for(int i = 0; i < R; i++) {
			Arrays.fill(dust[i], false);
			Arrays.fill(diffusion[i], 0);
			for(int j = 0; j < C; j++) {
				if(map[i][j] > 0)
					dust[i][j] = true;
			}
		}
	}

	static void FineDust() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(dust[i][j]) {
					if(map[i][j] < 5)
						continue;
					int n = 0, nx, ny, move = map[i][j] / 5;
					for(int d = 0 ; d < 4; d++) {
						nx = i + dx[d];
						ny = j + dy[d];
						if(nx < 0 || nx >= R || ny < 0 || ny >= C)
							continue;
						if(map[nx][ny] == -1)
							continue;
						diffusion[nx][ny] += move;
						n++;
					}
					map[i][j] -= move*n;
				}
			}
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] += diffusion[i][j];
			}
		}
	}

	static void AirRefresh() {
		// 위 공기청정기 반시계	
		int x = X-1;
		int y = 0;
		int d = -1;
		
		for(int c = 0; c <= 1; c++) {
			for(int i = 0; i < X-1; i++) {
				map[x][y] = map[x+d][y];
				x += d;
			}
			d*=(-1);
			for(int i = 0; i < C-1; i++) {
				map[x][y] = map[x][y+d];
				y += d;
			}
		}
		map[X-1][0] = -1;
		map[X-1][1] = 0;
		// 아래 공기청정기 시계
		x = X;
		y = 0;
		d = 1;
		for(int c = 0; c <= 1; c++) {
			for(int i = 0; i < R - X-1; i++) {
				map[x][y] = map[x+d][y];
				x += d;
			}
			for(int i = 0; i < C-1; i++) {
				map[x][y] = map[x][y+d];
				y += d;
			}
			d*=(-1);
		}
		map[X][0] = -1;
		map[X][1] = 0;
	}
}
