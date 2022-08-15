package AlgoStudy.Week4;

import java.util.Scanner;

public class BJ14391 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] paper = new int[N][M];
		int res = 0;

		for (int i = 0; i < N; i++) {
			String num = sc.next();
			for(int j = 0; j < M; j++) 
				paper[i][j] = num.charAt(j) - '0';
		}

		for(int i = 0; i < (1 << (N*M)); i++) {
			int sum = 0;
			// 가로 버전
			for(int x = 0; x < N; x++) {
				int curr = 0;
				for(int y = 0; y < M; y++) {
					int k = x * M + y;
					if((i & (1 << k)) == 0) {
						curr = curr * 10 + paper[x][y];
					}
					else {
						sum += curr;
						curr = 0;
					}
				}
				sum += curr;
			}
			// 세로 버전
			for(int y = 0; y < M; y++) {
				int curr = 0;
				for(int x = 0; x < N; x++) {
					int k = x * M + y;
					if((i&(1<<k))!=0)
						curr = curr*10+paper[x][y];
					else {
						sum+=curr;
						curr = 0;
					}
				}
				sum += curr;
			}
			
			res = Math.max(sum, res);
		}
		
		System.out.println(res);
	}

}
