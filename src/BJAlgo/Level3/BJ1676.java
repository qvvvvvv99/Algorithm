package BJAlgo.Level3;

import java.util.*;

public class BJ1676 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num0 = 0;
		int num = 1;
		
		for(int i = 1; i <= N; i++) {
			num *= i;
			int digit = 1;
			if(i >= 10)
				digit=2;
			if(i >= 100)
				digit=3;
			if(num % 10 != 0)
				num %= Math.pow(10, digit);
			while (num % 10 == 0) {
				num /= 10;
				num0++;
			}
		}
		
		System.out.println(num0);
	}
}
