package FastCampus.Search;

// BJ 1568¹ø »õ
// 1 <= N <= 1,000,000,000

import java.util.*;

public class BJ1568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sec = 0;
		int K = 1;
		
		while(N > 0) {
			N -= K;
			K++;
			sec++;
			if(N < K)
				K = 1;
		}
		
		System.out.println(sec);
	}

}
