package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ11659 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NM = br.readLine();
		StringTokenizer st = new StringTokenizer(NM);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		
		String input = br.readLine();
		st = new StringTokenizer(input);
		int[] ary = new int[N+1];
		for(int i = 1; i <= N; i++)
			ary[i] = Integer.parseInt(st.nextToken()) + ary[i-1];
		for(int i = 0; i < M; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(ary[b] - ary[a-1]+"\n");
		}
		System.out.print(sb);
	}

}
