import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();
		long sum = 0;
		int answer = 1;
		
		while(true) {
			sum += answer;
			if(sum > S)
				break;
			answer++;
		}
        
        System.out.println(answer-1);
    }
}

//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
