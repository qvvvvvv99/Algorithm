package BJAlgo.Level3;

import java.util.Scanner;

public class BJ11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ary[] = new int[n+1];
		
		ary[0] = 1;
		ary[1] = 1;
		for(int i = 2; i <= n; i++)
			ary[i] = (ary[i-1]+ ary[i-2])%10007;
		
		System.out.println(ary[n]);
	}

}
