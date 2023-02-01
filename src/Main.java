import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        
        for(int i = 0; i < N; i++) {
        	String str = sc.next();
            sb.append(str.toLowerCase()).append("\n");
        }
        
        System.out.print(sb);
    }
}

//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
