package SWEA;

import java.util.Scanner;

public class pre2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuffer sb = new StringBuffer();

		for (int T = 1; T <= tc; T++) {
			StringBuilder res = new StringBuilder();
			String N = sc.next();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int len = N.length();
			boolean flag = false;
			boolean reduce = false;
			int num;
			String newStr;

			for (int i = 0; i < len; i++) {
				if (flag) {
					newStr = N.substring(i);
					newStr = newStr.replaceAll("[0-9]", Integer.toString(y));
					res = new StringBuilder(res.substring(0, i)).append(newStr);
					break;
				} else {
					num = N.charAt(i) - '0';
					if (y <= num) {
						res.append(y);
						if (y < num)
							flag = true;
					} else if (x <= num) {
						res.append(x);
						if(i == 0 && x == 0) {
							reduce = true;
							res = new StringBuilder();
							break;
						}
						if (x < num)
							flag = true;
					} else {
						reduce = true;
						res = new StringBuilder();
						break;
					}
				}
			}
			if (reduce) {
				if (len > 1) {
					newStr = N.substring(1);
					newStr = newStr.replaceAll("[0-9]", Integer.toString(y));
					res = new StringBuilder(newStr);
				}
			}
			if (res.length() == 0 || res.charAt(0) == '0')
				res = new StringBuilder("-1");

			sb.append("#" + T + " " + res + "\n");
		}
		System.out.print(sb);
	}

}
