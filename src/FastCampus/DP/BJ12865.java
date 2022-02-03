package FastCampus.DP;

import java.io.*;

public class BJ12865 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int[][] ary = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			int weight = Integer.parseInt(input[0]);
			int value = Integer.parseInt(input[1]);
			for(int j = 1; j <= K; j++) {
				if(j < weight)
					ary[i][j] = ary[i-1][j];
				else {
					ary[i][j] = Math.max(ary[i-1][j], ary[i-1][j-weight]+value);
				}
			}
		}
		System.out.println(ary[N][K]);
	}

}
