import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, sum = 0;
        
        for(int i = 0; i < 5; i++) {
        	n = sc.nextInt();
        	if(n < 40)
        		n = 40;
        	sum += n;
        }
        
        System.out.println(sum / 5);
    }
}

//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
