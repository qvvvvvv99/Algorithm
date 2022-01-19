package BJAlgo.Level2;

// BJ 2609번
// 최대공약수와 최소 공배수
import java.util.*;

public class BJ2609 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		System.out.println(gcd(n1, n2));
		System.out.println(lcm(n1, n2));
	}
	
	//최대공약수
	// *** 최대를 구해야하면 반복문을 큰 곳에서 작아지면서 찾는 것이 효율적!!!
//	for(int i = Math.min(n1, n2); i > 1 ; i--)
//		if((n1 % i == 0) && (n2 % i == 0)){
//			gcd = i;
//			return gcd; -> 반복문 종료	
//		}
	public static int gcd(int n1, int n2) {
		int gcd = 1;
		
		for(int i = 2; i <= Math.min(n1, n2); i++) {
			if((n1 % i == 0) && (n2 % i == 0))
				gcd = i;
		}
		return gcd;
	}
	//최소공배수
	public static int lcm(int n1, int n2) {
		int lcm = 1;
		int gcd = gcd(n1, n2);
		
		lcm = n1 / gcd * n2;
		
		return lcm;
	}
}
