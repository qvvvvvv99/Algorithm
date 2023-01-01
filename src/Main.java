import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int Ur = sc.nextInt();
        int Tr = sc.nextInt();
        int Uo = sc.nextInt();
        int To = sc.nextInt();
        
        System.out.println(56*Ur+24*Tr+14*Uo+6*To);
    }
}

//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
