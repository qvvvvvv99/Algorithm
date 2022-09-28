import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for(int T = 0; T < tc; T++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	
        	int r = 1;
        	
        	for(int i = 0; i < b; i++)
        		r = (r*a) % 10;
        	if(r==0)
        		r = 10;
        	
        	System.out.println(r);
        }
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
