import java.util.Scanner;

public class Main {

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        
        for(int tc = 0; tc < T; tc++){
            int n = sc.nextInt();
            for(int i = 0; i < n; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int plus = a + b;
                int multi = a * b;
                sb.append(plus + " " + multi+"\n");
            }
        }
        
        System.out.print(sb);
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
