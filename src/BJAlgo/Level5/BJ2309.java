package BJAlgo.Level5;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2309 {
	static int[] num = new int[9];
	static int[] res = new int[7];
	static boolean flag = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++)
			num[i] = sc.nextInt();
		
		dfs(0, 0, 0);
		
		Arrays.sort(res);
		
		for(int i = 0; i < 7; i++)
			System.out.println(res[i]);
	}

	static void dfs(int idx, int cnt, int sum) {
		if(cnt == 7) {
			if(sum == 100)
				flag = true;
			return;
		}
		
		for(int i = idx; i < 9; i++) {
			res[cnt] = num[i];
			cnt++;
			sum += num[i];
			dfs(i+1, cnt, sum);
			sum -= num[i];
			cnt--;
			if(flag)
				return;
		}
	}
}
