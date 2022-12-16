import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        
        System.out.println(Math.abs(a-b));
    }
}

//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
