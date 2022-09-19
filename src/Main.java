import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int i;
			for (i = N / 2; i >= 2; i--) {
				if (isPrime(i) == true && isPrime(N-i) == true) {
					break;
				}
			}
			sb.append(i + " " + (N-i) + "\n");
		}

		System.out.println(sb);
	}

	public static boolean isPrime(int num) {
		for (int i = 2; i <= (int) Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
