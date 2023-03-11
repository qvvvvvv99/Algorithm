package BJAlgo.Level5;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2473 {
	static long min = Integer.MAX_VALUE;
	static int[] res = new int[3];
	static int[] ary;
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		ary = new int[n];
		for(int i = 0; i < n; i++)
			ary[i] = sc.nextInt();
		
		Arrays.sort(ary);
		
		for(int i = 0; i < n-2; i++) {
			sol(i);
		}
		
		Arrays.sort(res);
		System.out.println(res[0] + " " + res[1] + " " + res[2]);
	}
	
	static void sol(int idx) {
		int l = idx + 1;
		int r = n - 1;
		
		while(l < r) {
			long sum = ary[l] + ary[r] + ary[idx];
			if(Math.abs(sum) < min) {
				res[0] = ary[idx];
				res[1] = ary[l];
				res[2] = ary[r];
				min = Math.abs(sum);
			}
			
			if(sum > 0)
				r--;
			else
				l++;
		}
	}

}
