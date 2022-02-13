package BJAlgo.Level2;

import java.io.*;
import java.util.*;

public class BJ11866 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] ary = new int[N];
		StringBuffer sb = new StringBuffer();
		int cnt = 0;
		int n = K-1;
		
		for(int i = 0; i < N; i++)
			ary[i] = i+1;
		
		sb.append("<"+ary[n]);
		ary[n] = 0;
		cnt++;
		while(cnt < N) {
			for(int i = 1; i <= K; i++) {
				n++;
				if(ary[n%N] == 0)
					i--;
			}
			n %= N;
			sb.append(", "+ary[n]);
			ary[n] = 0;
			cnt++;
		}
		
		sb.append(">");
		System.out.println(sb);
	}

}
