package AlgoStudy.Week18;

import java.util.Scanner;
import java.util.Stack;

public class BJ9935 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String bomb = sc.nextLine();
		StringBuffer sb = new StringBuffer();
		Stack<Character> stack = new Stack<>();

		int len = bomb.length();
		int idx = 0;
		int top = -1;
		while (idx < str.length()) {
			stack.push(str.charAt(idx));
			top++;
			idx++;
			if(idx < len)
				continue;
			if (stack.peek() == bomb.charAt(len - 1)) {
				int i;
				for (i = 2; i <= len; i++) {
					if (stack.get(top + 1 - i) != bomb.charAt(len - i))
						break;
				}
				if (i == len + 1) {
					for (int j = 0; j < len; j++) {
						stack.pop();
						top--;
					}
				}
			}
		}
		for (Character c : stack)
			sb.append(c);

		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}
}
