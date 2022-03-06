package BJAlgo.Level3;

import java.util.Scanner;

public class BJ1992 {
	static int[][] map;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < N; j++) 
				map[i][j] = line.charAt(j)-'0';
		}
		
		solve(0, 0, N);
		
		System.out.println(sb);
	}
	
	public static void solve(int y, int x, int n) {
		int fir = map[y][x];
		
		for(int i = y; i < y+n; i++) {
			for(int j = x; j < x+n; j++) {
				if (fir != map[i][j]) {
					int nn = n/2;
					sb.append("(");
					solve(y, x, nn);
					solve(y, x+nn, nn);
					solve(y+nn, x, nn);
					solve(y+nn, x+nn, nn);
					sb.append(")");
					return;
				}
			}
		}
		sb.append(fir);
	}

}
