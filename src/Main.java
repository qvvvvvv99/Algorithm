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
			if(input.equals("# 0 0"))
				break;
			String[] str = input.split(" ");
			
			sb.append(str[0]);
			if(Integer.parseInt(str[1]) > 17 || Integer.parseInt(str[2]) >= 80)
				sb.append(" Senior\n");
			else
				sb.append(" Junior\n");
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
