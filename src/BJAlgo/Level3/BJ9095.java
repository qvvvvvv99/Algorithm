package BJAlgo.Level3;

import java.util.*;

public class BJ9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		int[] ary = new int[12];
		int[] num = new int[tc+1];
		int max = 0;
		
		for(int i = 1; i <= tc; i++) {
			num[i] = sc.nextInt();
			if(max < num[i])
				max=num[i];
		}
		
		ary[1] = 1; ary[2] = 2; ary[3] = 4;
		for(int i = 4; i <= max; i++) 
			ary[i] = ary[i-3] + ary[i-2] + ary[i-1];
		
		for(int i = 1; i <= tc; i++)
			sb.append(ary[num[i]]+"\n");
		
		System.out.print(sb);
	}

}
