import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input;
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			input = sc.nextLine();
			if(input.equals("#"))
				break;
			input = input.toLowerCase();
			int n = 0;
			
			for(int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u')
					n++;
			}
			
			sb.append(n+"\n");
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
