package BJAlgo.Level4;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2448 {
	static char[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
//		System.out.println(N);
//		System.out.println(k);
		
		map = new char[N][N*2-1];
		for(int i = 0; i < N; i++)
			Arrays.fill(map[i], ' ');
		
		solve(0, N-1, N);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N * 2 - 1; j++)
				sb.append(map[i][j]);
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	static void solve(int row, int col, int n) {
		if(n == 3) {
			map[row][col] = '*';
			map[row+1][col-1] = map[row+1][col+1] = '*';
			map[row+2][col-2] = map[row+2][col-1] = map[row+2][col] = map[row+2][col+1] = map[row+2][col+2] = '*';
		}
		else {
			int div = n / 2;
			solve(row, col, div);
			solve(row + div, col + div, div);
			solve(row + div, col - div, div);
		}
	}
}
