package BJAlgo.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16967 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] B = new int[H+X][W+Y];
		int[][] A = new int[H][W];
		
		for(int i = 0; i < H+X; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W+Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(i < X)
					A[i][j] = B[i][j];
				else {
					if(j < Y)
						A[i][j] = B[i][j];
					else
						A[i][j] = B[i][j] - A[i-X][j-Y];
				}
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}
