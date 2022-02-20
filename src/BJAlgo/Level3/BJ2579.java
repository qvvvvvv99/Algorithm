package BJAlgo.Level3;

import java.util.Scanner;

public class BJ2579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ary[] = new int[N + 1];

		for (int i = 1; i <= N; i++)
			ary[i] = sc.nextInt();

		int res[][] = new int[N + 1][2];
		res[1][0] = ary[1];
		for (int i = 2; i <= N; i++) {
			res[i][0] = Math.max(res[i-2][0], res[i-2][1]) + ary[i];
			res[i][1] = res[i-1][0] + ary[i];
		}

		System.out.println(Math.max(res[N][0], res[N][1]));
	}

}
