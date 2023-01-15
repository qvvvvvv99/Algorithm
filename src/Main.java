import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        
        for(int i = 0; i < 4; i++) {
        	int s = sc.nextInt();
        	sum += s;
        }
    	System.out.println(sum / 60);
    	System.out.println(sum % 60);
    }
}

//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
