package AlgoStudy.Week10;

import java.util.Stack;

public class Prog12973 {
	static int cnt = 0;
	static boolean[] delete;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbabb";

		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();
		int idx = 0;
		
		while(idx < s.length()) {
			if(stack.isEmpty() || s.charAt(idx) != stack.peek())
				stack.push(s.charAt(idx));
			else
				stack.pop();
			idx++;
		}
		
		if(stack.isEmpty())
			answer = 1;
		
		return answer;
	}

	public static int solution2(String s) {
		int answer = 0;
		int left = 0;
		int right = 1;
		delete = new boolean[s.length()];

		while (right < s.length()) {
			if (delete[left] == false && delete[right] == false && s.charAt(left) == s.charAt(right)) {
				check(left, right, s);
				int i;
				for(i = 0; i < s.length(); i++) {
					if(delete[i] == false)
						break;
				}
				left = i;
				for(i = left+1; i< s.length(); i++) {
					if(delete[i] == false)
						break;
				}
				right = i;
			} else {
				// ���� �ʿ�
				left++;
				right++;
			}
		}
		
		if (cnt == s.length())
			answer = 1;

		return answer;
	}

	static int check(int left, int right, String s) {
		cnt += 2;
		delete[left] = true;
		delete[right] = true;
		int l = left - 1;
		int r = right + 1;
		int ll, rr;

		while (l >= 0 && delete[l] == true)
			l--;
		while (r < s.length() && delete[r] == true)
			r++;
		if (l >= 0 && r < s.length()) {
			if (s.charAt(l) == s.charAt(r))
				return check(l, r, s);
			else {
				if(l > 0) {
					ll = l - 1;
					while(ll >= 0 && delete[ll] == true)
						ll--;
					if(s.charAt(l) == s.charAt(ll))
						return check(ll, l, s);
				}
				if(r < s.length() - 1) {
					rr = r + 1;
					while(rr < s.length() && delete[rr] == true)
						rr++;
					if(s.charAt(r) == s.charAt(rr))
						return check(r, rr, s);
				}
			}
		}
		
		return cnt;
	}
}
