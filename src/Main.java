import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n1, n2;

		while (true) {
			n1 = s.nextInt();
			n2 = s.nextInt();
			if (n1 == 0 && n2 == 0)
				break;

			if (n1 > n2)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		// https://www.acmicpc.net/problem/2558
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
