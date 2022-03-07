package SWMaestro;

// 백준 1149번 RGB거리

import java.io.*;
import java.util.*;

public class BJ1149 {
	static int red = 0;
	static int green = 1;
	static int blue = 2;
	
	static int cost[][];
	static int dp[][];
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N+1][3];
		dp = new int[N+1][3];
		
		for(int i = 1; i <= N; i++) {
			String price = br.readLine();
			StringTokenizer st = new StringTokenizer(price);
			for(int j = 0; j < 3; j++)
				cost[i][j] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<3; i++)
			dp[1][i] = cost[1][i];
		
		System.out.println(Math.min(paint(N, red), Math.min(paint(N,green), paint(N,blue))));
	}
	
	public static int paint(int n, int color) {
		if(dp[n][color] == 0) {
			
			// color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
			if(color == red) {
				dp[n][red] = Math.min(paint(n - 1, green), paint(n - 1, blue)) + cost[n][red];
			}
			else if(color == green) {
				dp[n][green] = Math.min(paint(n - 1, red), paint(n - 1, blue)) + cost[n][green];
			}
			else {
				dp[n][blue] = Math.min(paint(n - 1, red), paint(n - 1, green)) + cost[n][blue];
			}
			
		}
		
		return dp[n][color];
	}
	
	
}
