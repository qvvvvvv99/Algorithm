package SDS.DAY09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11049 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int r, c;
		Matrix[] ary = new Matrix[N+1];
		int[][] D = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			ary[i] = new Matrix(r,c);
		}
		
		int min;
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j <= N - i + 1; j++) {
				min = Integer.MAX_VALUE;
				for(int k = j; k < j + i - 1; k++) {
					min = Math.min(min, D[j][k] + D[k+1][j+i-1] + ary[j].r * ary[k].c * ary[j+i-1].c);
				}
				D[j][j+i-1] = min;
			}
		}
		
		System.out.println(D[1][N]);
	}

}

class Matrix{
	int r;
	int c;
	
	Matrix(int r, int c){
		this.r = r;
		this.c = c;
	}
}