package FastCampus.Greedy;

import java.io.*;

public class BJ1080 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		String[] A = new String[N];
		String[] B = new String[N];
		int[][] matrix = new int[N][M];
		int cnt = 0;

		for (int i = 0; i < N; i++)
			A[i] = br.readLine();

		for (int i = 0; i < N; i++)
			B[i] = br.readLine();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i].charAt(j) == B[i].charAt(j)) // 같은경우
					matrix[i][j] = 0;
				else
					matrix[i][j] = 1;
			}
		}
		br.close();

		for (int i = 0; i <= N - 3; i++) {
			for (int j = 0; j <= M - 3; j++) {
				if (matrix[i][j] == 1) {
					changeMatrix(i, j, matrix);
					cnt++;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j =0; j < M; j++)
				if(matrix[i][j] == 1)
					cnt = -1;
		}

		System.out.println(cnt);
	}

	public static void changeMatrix(int y, int x, int[][] matrix) {
		for (int i = y; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++) {
				matrix[i][j] ^= 1;
//				if (matrix[i][j] == 1)
//					matrix[i][j] = 0;
//				else
//					matrix[i][j] = 1;
			}
		}
	}

}
