package FastCampus.Backtracking;

import java.io.*;
import java.util.*;

public class BJ1987 {
	static int R, C;
	static int max = 0;
	static char[][] map;
	static ArrayList<Character> alpha = new ArrayList<Character>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int i = 0; i < R; i++) {
			input = br.readLine();
			for(int j = 0; j < C; j++)
				map[i][j] = input.charAt(j);
		}
		
		dfs(0, 0);
		
		System.out.println(max);
	}
	
	public static void dfs(int row, int col) {
		alpha.add(map[row][col]);
		
		if(check(row, col)) {
			if(row < R-1)
				dfs(row+1, col);
			if(col < C-1)
				dfs(row, col+1);
			if(row > 0)
				dfs(row-1, col);
			if(col > 0)
				dfs(row, col-1);
		}
		int idx = alpha.size();
		alpha.remove(idx-1);
		
		if(alpha.size() > max)
			max = alpha.size();
	}
	
	public static boolean check(int row, int col) {
		for(int i = 0; i < alpha.size()-1; i++) {
			if(map[row][col] == alpha.get(i))
				return false;
		}
		return true;
	}
}
