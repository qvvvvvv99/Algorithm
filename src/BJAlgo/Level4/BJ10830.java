package BJAlgo.Level4;

import java.util.Scanner;

public class BJ10830 {
	static int MOD = 1000;
	static int N;
	static int [][] matrix;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long B = sc.nextLong();
		
		matrix = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				matrix[i][j] = sc.nextInt() % MOD;
		}
		
		int[][] res = devide(matrix, B);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(res[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static int[][] devide(int[][] A, long exp){
		if(exp == 1) {
			return A;
		}
		int[][] ret = devide(A, exp/2);
		
		ret = combine(ret, ret);
		
		if(exp % 2 == 1) 
			ret = combine(ret, matrix);
		
		return ret;
	}
	
	static int[][] combine(int[][] m1, int[][] m2){
		int[][] A = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int num = 0;
				for(int k = 0; k < N; k++) {
					num += m1[i][k] * m2[k][j];
					num %= MOD;
				}
				A[i][j] = num;
			}
		}
		
		return A;
	}
}
