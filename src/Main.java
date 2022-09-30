import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int b = N % 10;
        N /= 10;
        if(b == 0){
            b = N % 10;
            b *= 10;
            N /= 10;
        }
        int a = N;
        
        System.out.println(a+b);
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
