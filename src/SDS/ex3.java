package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex3 {
	static int result;
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int t = 0; t < tc; t++) {
			int[] cost = new int[17];
			N = Integer.parseInt(br.readLine());
			result = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i < 17; i++)
				cost[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 1; i < 17; i++) {
				int res = 0;
				int num = 0;
			}
			int idx = t+1;
			sb.append("#"+ idx + " " + result +"\n");
		}
		System.out.print(sb);

	}
	
	public static void bfs(int res, int num) {
		num += 1;
		
	}
}
