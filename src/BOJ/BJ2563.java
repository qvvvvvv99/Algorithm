package BOJ;

import java.util.Scanner;

public class BJ2563 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[][] map = new boolean[101][101];
		
		int a, b;
		for(int i = 0; i < n; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			for(int x = 0; x < 10; x++) {
				for(int y = 0; y < 10; y++) {
					map[a+x][b+y] = true;
				}
			}
		}
		
		int res = 0;
		for(int i = 1; i < 101; i++) {
			for(int j = 1; j < 101; j++) {
				if(map[i][j])
					res++;
			}
		}
		
		System.out.println(res);
	}

}
