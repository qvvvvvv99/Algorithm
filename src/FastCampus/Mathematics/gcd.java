package FastCampus.Mathematics;

import java.util.Scanner;

public class gcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		// GCD(a, b) = GCD(b, a%b)
		
		System.out.println(gcd_ite(a, b));
		System.out.println(gcd(a, b));
		System.out.println(gcd2(a, b));
	}
	
	// 방법 1 : 단순 반복문
	// 시간 오래 걸림
	public static int gcd_ite(int a, int b) {
		for(int i = Math.min(a, b); i >= 0; i--) {
			if(a%i == 0 && b%i==0)
				return i;
		}
		return 0;
	}
	
	// 방법 2 : 유클리드호제법
	public static int gcd(int a, int b) {
		if(a%b == 0)
			return b;
		return gcd(b, a%b);
	}

	// 방법 3 : 반복문으로 변경
	public static int gcd2(int a, int b) {
		int temp;
		while(a%b != 0) {
			temp = a;
			a = b;
			b = temp%b;
		}
		return b;
	}
}
