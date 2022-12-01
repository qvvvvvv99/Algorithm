package AlgoStudy.Week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2343 {
	static int[] ary;
	static int N, M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ary = new int[N];
		st = new StringTokenizer(br.readLine());
		int min = 0, max = 0;
		
		for(int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
			min = Math.max(min, ary[i]);
			max += ary[i];
		}
		
		System.out.println(sol(min, max));
	}
	
	static int sol(int min, int max) {
		int mid = 0;
		int group, sum;
		
		while(min <= max) {
			mid = (min + max) / 2;
			group = 1;
			sum = 0;
			
			for(int i = 0; i < N; i++) {
				sum += ary[i];
				if(sum > mid) {
					sum = 0;
					i--;
					group++;
				}
			}
			
			if(group > M) 
				min = mid+1;
			else
				max = mid-1;
		}
		
		return min;
	}
}
