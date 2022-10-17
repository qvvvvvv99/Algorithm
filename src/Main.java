import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int ax = sc.nextInt();
		int ay = sc.nextInt();
		int az = sc.nextInt();
		int cx = sc.nextInt();
		int cy = sc.nextInt();
		int cz = sc.nextInt();
		int bx, by, bz;
		bx = cx - az;
		by = cy / ay;
		bz = cz - ax;
		
		System.out.println(bx + " " + by + " " + bz);
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
