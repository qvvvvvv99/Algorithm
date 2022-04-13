package FastCampus.Backtracking;

import java.io.*;
import java.util.*;

public class BJ12100 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int board[][] = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			for(int j = 0; j < N; j++) 
				board[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dfs(N, board, 5));
	}
	
	public static int dfs(int N, int[][] board, int cnt) {
		if(cnt == 0) {
			int max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] > max)
						max = board[i][j];
				}
			}
			return max;
		}
		
		return 0;
	}

}
