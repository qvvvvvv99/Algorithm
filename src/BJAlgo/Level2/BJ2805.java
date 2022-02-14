package BJAlgo.Level2;

//백준 2805번 나무 자르기
//이분탐색(Binary Search)

import java.io.*;
import java.util.*;

public class BJ2805 {
	static int[] tree;
	static int M, N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		int max = 0;
		
		input = br.readLine();
		st = new StringTokenizer(input);
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(max < tree[i])
				max = tree[i];
		}
		
		System.out.println(binarySearch(0, max));
	}
	
	public static int binarySearch(int start, int end) {
		int mid = (start+end)/2;
		
		while(start <= end) {
			long sum = 0;
			for(int i = 0; i < N; i++)
				sum += (tree[i] > mid ? tree[i] - mid : 0);
			if(sum >= M)
				start = mid + 1;
			else
				end = mid - 1;
			mid = (start + end) / 2;
		}
		return mid;
	}
}
