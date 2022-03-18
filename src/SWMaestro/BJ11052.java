package SWMaestro;

import java.io.*;
import java.util.StringTokenizer;

public class BJ11052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ary = new int[N+1];
		int[] DP = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) 
			ary[i] = Integer.parseInt(st.nextToken());
		
		DP[1] = ary[1];
		for(int i = 2; i <= N; i++) {
			int max = ary[i];
			int idx = i;
			int p;
			while(idx > i % 2) {
				idx--;
				p = DP[idx] + DP[i-idx];
				if(p > max)
					max = p;
			}
			DP[i] = max;
		}
		System.out.println(DP[N]);
	}

}
