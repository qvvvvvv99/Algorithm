import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ary = new int[N];
		for(int i = 0; i < N; i++)
			ary[i] = sc.nextInt();
		
		int v = sc.nextInt();

		int answer = 0;
		for(int i = 0; i < N; i++) {
			if(v == ary[i])
				answer++;
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
