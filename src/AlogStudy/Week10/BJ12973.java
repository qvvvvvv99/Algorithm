package AlogStudy.Week10;

public class BJ12973 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "baabaa";

		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 0;
		int cnt = 0;
		int left = 0;
		int right = 1;
		boolean[] delete = new boolean[s.length()];

		while (right < s.length()) {
			if (cnt == s.length()) {
				answer = 1;
				break;
			}

			if (s.charAt(left) == s.charAt(right)) {
				check(left, right, delete, cnt, s);
			} else {
				// 수정 필요
				left++;
				right++;
			}
		}

		return answer;
	}

	static int check(int left, int right, boolean[] delete, int cnt, String s) {
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
				return check(l, r, delete, cnt, s);
			else {
				if(l > 0) {
					ll = l - 1;
					while(ll >= 0 && delete[ll] == true)
						ll--;
					if(s.charAt(l) == s.charAt(ll))
						return check(ll, l, delete, cnt, s);
				}
				
			}
		}
		
		return cnt;
	}
}
