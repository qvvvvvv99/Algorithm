import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String answer;
		String input;
		for (int i = 0; i < n; i++) {
			answer = "";
			input = sc.next();
			answer += input.charAt(0);
			answer += input.charAt(input.length()-1);
			
			System.out.println(answer);
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
