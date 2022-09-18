import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int sum;
	static int min;
	static boolean flag;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i = N; i >= M; i--) {
			if(i % 2 == 0 || i == 1)
				continue;
			if (isPrime(i)) {
				sum += i;
				min = i;
			}
		}
		
		if(M <= 2) {
			sum += 2;
			min = 2;
			flag = true;
		}
		if(N == 1)
			flag = false;
		
		if(flag == false)
			System.out.println(-1);
		else
			System.out.println(sum + "\n" + min);
	}

	public static boolean isPrime(int num) {
		for(int i = 2; i <= (int)Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		flag = true;
		return true;
	}
}
