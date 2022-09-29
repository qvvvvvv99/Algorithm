package AlgoStudy.Week11;

import java.util.Scanner;

public class BJ2011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			String num = sc.next();
			int[] dp = new int[num.length() + 1];
			long answer = 1;

			num = " " + num;
			dp[0] = 1;
			dp[1] = 1;
			for (int i = 2; i < num.length(); i++) {
				if (num.charAt(i) == '0') {
					if (num.charAt(i - 1) - '0' > 2 || num.charAt(i-1) == '0') {
						answer = 0;
						break;
					}
					answer *= dp[i - 2];
					answer %= 1000000;
					dp[i] = 1;
					dp[i - 1] = 1;
				} else {
					if (num.charAt(i - 1) == '1') {
						dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
					} else if (num.charAt(i - 1) == '2') {
						if (num.charAt(i) - '0' <= 6)
							dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
						else
							dp[i] = dp[i - 1];
					} else
						dp[i] = dp[i - 1];
				}
			}
			if (num.charAt(num.length() - 1) != '0')
				answer *= dp[num.length() - 1];
			answer %= 1000000;

			if (num.charAt(1) == '0')
				System.out.println(0);
			else
				System.out.println(answer);
		}
	}

}
