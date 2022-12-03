import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			if(str.length() >= 6 && str.length() <= 9)
				sb.append("yes\n");
			else
				sb.append("no\n");
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
