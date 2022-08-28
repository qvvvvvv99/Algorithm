package AlgoStudy.Week6;

import java.util.Scanner;

public class BJ1407 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		long res = 0;
		
		res = f(B) - f(A-1);
		
		System.out.println(res);
	}
	
	static long f(long num) {
		long sum = 0;
		long i = 1;
		
		while(num > 0) {
			if(num % 2 == 1) {
				sum += i;
				num--;
			}
			sum += (num / 2) * i;
			num /= 2;
			i *= 2;
		}
		
		return sum;
	}

}
