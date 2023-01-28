package AlgoStudy.M1_W5;

import java.util.Scanner;

public class BJ3109 {
	static int R, C;
	static char[][] map;
	static int[] dx = {-1, 0, 1};
	static int res = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			String line = sc.next();
			map[i] = line.toCharArray();
		}
		
		int res = 0;
		for(int i = 0; i < R; i++) {
			// [i][0]에서 출발
			if(sol(i, 0))
				res++;
		}
		
		System.out.println(res);
	}
	
	static boolean sol(int r, int c) {
		map[r][c] = 'x';
		
		if(c == C-1) {
			return true;
		}
		
		for(int i = 0; i < 3; i++) {
			int nr = r + dx[i];
			int nc = c + 1;
			if(nr < 0 || nr >= R)
				continue;
			if(map[nr][nc] == 'x')
				continue;
			if(sol(nr, nc))
				return true;
		}
		
		return false;
	}
}
