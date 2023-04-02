import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
        String s;
        while ((s = sc.nextLine()) != null) {
            System.out.println(s);
        }
	}
}

//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
