package BJAlgo.Level3;

import java.util.Scanner;

public class BJ9461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		long[] ary = new long[101];
		StringBuffer sb = new StringBuffer();
		ary[1]=1;ary[2]=1;ary[3]=1;
		ary[4]=2;ary[5]=2;
		
		for(int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			for(int j = 6; j <= n; j++) 
				ary[j] = ary[j-1]+ary[j-5];
			sb.append(ary[n]+"\n");
		}
		System.out.print(sb);
	}

}
