import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String l1 = sc.next();
        String l2 = sc.next();
        
        if(l1.length() < l2.length())
            System.out.println("no");
        else
            System.out.println("go");
    }
}

//
//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
