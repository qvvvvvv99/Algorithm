import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int t = 0; t < n; t++) {
			String str = sc.next();

			int sum1 = 0, sum2 = 0;

			for (int i = 0; i < 3; i++)
				sum1 += (str.charAt(i) - 'A') * Math.pow(26, 2 - i);

			String[] s = str.split("-");
			sum2 = Integer.parseInt(s[1]);

			if(Math.abs(sum1-sum2) <= 100)
				System.out.println("nice");
			else
				System.out.println("not nice");
		}
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
