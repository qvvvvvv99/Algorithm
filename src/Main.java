import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int mon = sc.nextInt();
		int day = sc.nextInt();
		String answer = "";
		if(mon < 2)
			answer = "Before";
		else if(mon > 2)
			answer = "After";
		else {
			if(day < 18)
				answer = "Before";
			else if(day > 18)
				answer = "After";
			else
				answer = "Special";
		}
		
        System.out.println(answer);
    }
}

//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
