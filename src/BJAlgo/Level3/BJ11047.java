package BJAlgo.Level3;

import java.util.Scanner;

public class BJ11047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] ary = new int[N];
		int cnt = 0;
		
		for(int i = 0; i < N; i++)
			ary[i]=sc.nextInt();
		for(int i = N-1; i >= 0; i--) {
			cnt += K / ary[i];
			K %= ary[i];
			if(K == 0)
				break;
		}
		
		System.out.print(cnt);
	}

}
