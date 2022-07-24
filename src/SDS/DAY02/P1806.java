package SDS.DAY02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] ary = new int[N+1];
		int low = 0;
		int high = 0;
		int min = N+1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			ary[i] = Integer.parseInt(st.nextToken());
		
		int sum = 0;
		while (low <= N && high <= N) {
			if (sum < S) {
				sum += ary[high++];
			} else {
				min = Math.min(min, high - low);
				sum -= ary[low++];
			}
		}

		if (min == N+1)
			min = 0;
		System.out.println(min);
	}

}
