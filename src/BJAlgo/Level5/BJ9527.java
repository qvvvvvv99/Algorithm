package BJAlgo.Level5;

import java.util.Scanner;

public class BJ9527 {
	static int[] num1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		
		int min = log2(A);
		int max = log2(B);
		
		num1 = new int[max+1];
		num1[0] = 1;
		
		for(int i = 1; i <= max; i++)
			num1[i] = (int) (num1[i-1] * 2 + Math.pow(2, i-1));
		
		long res = 0;
		for(int i = min; i < max; i++)
			res += num1[i];
		
		long A2 = (long) (A - Math.pow(2, min));
		long B2 = (long) (B - Math.pow(2, max));
		
		if(A2 > 0)
			A2 = remain(A2, 0);
		B2 = remain(B2+1, 0);
		
		res -= A2;
		res += B2;
		
		System.out.println(res);
	}

	static int log2(long x) {
		return (int)(Math.log10(x)/Math.log10(2));
	}
	
	static long remain(long x, int s){
		long ret = 0;
		
		int n = log2(x);
		ret = (long) (num1[n] + (s * Math.pow(2, n)));
		x -= Math.pow(2, n);
		if(x > 0)
			ret += remain(x, s+1);
		
		
		return ret;
	}
}
