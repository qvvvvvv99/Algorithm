import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("int a;");
		System.out.println("int *ptr = &a;");

		if(n >= 2) 
			System.out.println("int **ptr2 = &ptr;");
		
		String pointer = "**";
		for(int i = 3; i <= n; i++) {
			pointer += "*";
			System.out.println("int "+ pointer + "ptr"+i +" = &ptr"+(i-1)+";");
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
