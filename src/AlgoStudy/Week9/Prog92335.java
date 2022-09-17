package AlgoStudy.Week9;

import java.util.Scanner;

public class Prog92335 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String num = new String();
		int res = 0;

		while (n > 0) {
			num = (n % k) + num;
			n /= k;
		}

		String[] P = num.split("0");
		boolean flag;

		for (int i = 0; i < P.length; i++) {
			if (P[i].equals("") || P[i].equals("1"))
				continue;

			flag = true;
			for (int j = 2; j <= (int) Math.sqrt(Long.parseLong(P[i])); j++) {
				if (Long.parseLong(P[i]) % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag == true)
				res++;
		}

		System.out.println(res);
	}

}
