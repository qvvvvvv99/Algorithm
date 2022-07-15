package BJAlgo.Level4;

import java.util.Scanner;

public class BJ1629 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextInt();
		long B = sc.nextInt();
		long C = sc.nextInt();
		
		System.out.println(power(A, B, C));
	}
	
	public static long power(long a, long b, long c) {
		if(b == 1)
			return a % c;
		else if(b % 2 == 0) {
			long temp = power(a, b/2, c);
			return (temp * temp) % c;
		}
		else {
			long temp = power(a, (b-1)/2, c);
			return ((temp * temp) % c * a) % c;
		}
	}

}
