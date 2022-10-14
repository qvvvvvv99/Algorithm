import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int hour = sc.nextInt();
		int min = sc.nextInt();
		int sec = sc.nextInt();
		int time = sc.nextInt();
		
		sec += time;
		min += sec / 60;
		sec %= 60;
		hour += min / 60;
		min %= 60;
		hour %= 24;
		
		System.out.println(hour + " " + min + " " + sec);
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
