package BJAlgo.BOJ;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ10826 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger[] ary = new BigInteger[100000];
		ary[0] = BigInteger.ZERO;
		ary[1] = BigInteger.ONE;
		
		for(int i = 2; i <= n; i++)
			ary[i] = ary[i-2].add(ary[i-1]);
		
		System.out.println(ary[n]);
		sc.close();
	}

}
