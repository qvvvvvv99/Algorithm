import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
        BigInteger N = new BigInteger(str);
        str = sc.next();
        BigInteger M = new BigInteger(str);
        
        System.out.println(N.divide(M));
        System.out.println(N.remainder(M));
    }
}

//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
