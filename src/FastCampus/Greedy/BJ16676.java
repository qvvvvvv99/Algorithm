package FastCampus.Greedy;

import java.util.Scanner;

public class BJ16676 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N == 0) {
			System.out.println(1);
			System.exit(0);
		}
		
		int digit = 0;
		int tmp = N;
		
		while(tmp > 0) {
			tmp /= 10;
			digit++;
		}
		
		int mask = 1;
		for(int i = 1; i < digit; i++) {
			mask *= 10;
			mask++;
		}
		
		if(N >= mask)
			System.out.println(digit);
		else
			System.out.println(digit-1);
	}

}
