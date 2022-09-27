import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        int curr;
        int score = 1;
        
        for(int i = 0; i < N; i++) {
        	curr = sc.nextInt();
        	if(curr == 0)
        		score = 1;
        	else {
        		sum += score;
        		score++;
        	}
        }
        
        System.out.println(sum);
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
