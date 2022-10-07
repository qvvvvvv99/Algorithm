import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.println(sc.nextInt() + sc.nextInt());  
	}
	// https://www.acmicpc.net/problem/2558
}

//
//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
