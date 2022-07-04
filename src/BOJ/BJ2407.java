package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ2407 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		BigInteger[][] ary = new BigInteger[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || i == j)
					ary[i][j] = BigInteger.ONE;
				else
					ary[i][j] = ary[i-1][j].add(ary[i-1][j-1]);
				if(j >= m)
					break;
			}
		}
		
		System.out.println(ary[n][m]);
	}

}
