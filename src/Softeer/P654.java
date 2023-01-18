package Softeer;

import java.io.*;
import java.util.*;

public class P654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] ary = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			ary[i] = Integer.parseInt(st.nextToken());
		boolean flag;
		
		int res = 0;

		for (int i = 0; i < N; i++) {
			flag = false;
			for (int j = i + 1; j < N; j++) {
				if (ary[j] > ary[i]) 
					flag = true;
				if(flag && ary[j] < ary[i])
					res++;
			}
		}

		System.out.println(res);
	}
}
