package SDS.DAY02;

import java.util.Scanner;

public class P2003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N];
		int low = 0, high = 1;
		int res = 0;
		
		for(int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		
		while(high <= N) {
			int sum = 0;
			for(int i = low; i < high; i++)
				sum += A[i];
			
			if(sum == M) {
				res++;
				low++;
			} else if(sum < M) {
				high++;
			} else {
				low++;
			}
		}
		
		System.out.println(res);
	}

}
