package BJAlgo.Level2;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		System.out.println(gcd(n1, n2));
		System.out.println(lcm(n1, n2));
	}
	
	public static int gcd(int n1, int n2) {
		int gcd = 1;
		
		for(int i = 2; i <= Math.min(n1, n2); i++) {
			if((n1 % i == 0) && (n2 % i == 0))
				gcd = i;
		}
		return gcd;
	}
	public static int lcm(int n1, int n2) {
		int lcm = 1;
		int gcd = gcd(n1, n2);
		
		lcm = n1 / gcd * n2;
		
		return lcm;
	}
}