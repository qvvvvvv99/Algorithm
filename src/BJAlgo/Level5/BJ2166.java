package BJAlgo.Level5;

import java.util.Scanner;

public class BJ2166 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] x = new int[n+1];
		int[] y = new int[n+1];
		for(int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		x[n] = x[0];
		y[n] = y[0];
		long sumA = 0, sumB = 0;
		
		for(int i = 0; i < n; i++) {
			sumA += (long)x[i] * y[i+1];
			sumB += (long)x[i+1] * y[i];
		}
		
		String res = String.format("%.1f", Math.abs(sumA-sumB)/2.0);
		
		System.out.println(res);
	}

}
