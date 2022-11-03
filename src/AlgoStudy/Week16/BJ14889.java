package AlgoStudy.Week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14889 {
	static int n;
	static int[][] map;
	static boolean[] team;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		team = new boolean[n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(min);
	}

	static void dfs(int idx, int cnt) {
		if(cnt == n / 2) {
			int t1 = 0;
			int t2 = 0;
			for(int i = 0; i < n-1; i++) {
				for(int j = i + 1; j < n; j++) {
					if(team[i] && team[j]) 
						t1 += map[i][j] + map[j][i];
					else if(!team[i] && !team[j])
						t2 += map[i][j] + map[j][i];
				}
			}
			
			min = Math.min(min, Math.abs(t1-t2));
		}
		
		for(int i = idx; i < n; i++) {
			team[i] = true;
			dfs(i+1, cnt+1);
			team[i] = false;
		}
	}
}
