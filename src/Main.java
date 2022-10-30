import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] ary = new int[5];
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {
			ary[i] = sc.nextInt();
			sum += ary[i];
		}
		Arrays.sort(ary);
		System.out.println(sum/5);
		System.out.println(ary[2]);
    }
}

//public static boolean isPrime(int num) {
//	for (int i = 2; i <= (int) Math.sqrt(num); i++) {
//		if (num % i == 0)
//			return false;
//	}
//	return true;
//}
