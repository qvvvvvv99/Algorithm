package BJAlgo.Level3;

import java.util.Scanner;

public class BJ11727 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ary = new int[1001];
		ary[1] = 1;
		ary[2] = 3;
		
		for(int i = 3; i <= n; i++)
			ary[i] = (ary[i-1] + 2 * ary[i-2])%10007;
		
		System.out.println(ary[n]%10007);
	}

}
