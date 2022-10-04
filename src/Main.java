import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		
		int min = p;
		
		if(n >= 5)
			min = p - 500;
		if(n >= 10)
			min = Math.min(min, p * 9 / 10);
		if(n >= 15)
			min = Math.min(p - 2000, min);
		if(n >= 20)
			min = Math.min(min, p * 75 / 100);
		if(min < 0)
			min = 0;
		
		System.out.println(min);
	}
}

//
//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
