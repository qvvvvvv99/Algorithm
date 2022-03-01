package SWMaestro;

import java.io.*;
import java.util.*;

public class BJ10815 {
	static int[] ary2;
	static int[] ary1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ary1 = new int[N];
		StringBuffer sb = new StringBuffer();
		
		String ary = br.readLine();
		StringTokenizer st = new StringTokenizer(ary);
		for(int i = 0; i < N; i++)
			ary1[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(ary1);
		
		int M = Integer.parseInt(br.readLine());
		ary2 = new int[M];
		ary = br.readLine();
		st = new StringTokenizer(ary);
		for(int i = 0; i < M; i++) {
			ary2[i] = Integer.parseInt(st.nextToken());
			binarySearch(i, ary2[i], 0, N-1);
			sb.append(ary2[i] + " ");
		}
		
		System.out.println(sb);
	}
	
	public static void binarySearch(int idx, int n, int s, int e) {
		while(s <= e) {
			int mid = (s + e)/2;
			if(ary1[mid] > n)
				e = mid - 1;
			else if(ary1[mid] < n)
				s = mid + 1;
			else {
				ary2[idx] = 1;
				return;
			}
		}
		ary2[idx] = 0;
		return;
	}

}
