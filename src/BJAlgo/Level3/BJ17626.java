package BJAlgo.Level3;

import java.util.*;

public class BJ17626 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ary = new int[n+1];

		for(int i = 1; i*i <= n; i++) {
			ary[(int)Math.pow(i, 2)]=1;
		}
		
		for (int i = 2; i <= n; i++) {
			int min = n;
			if(ary[i] != 0)
				continue;
			for (int j = 1; j*j < i; j++){
				int num = ary[j*j]+ary[i-j*j];
				if(min > num)
					min = num;
			}
			ary[i] = min;
		}

		System.out.println(ary[n]);
	}

}
