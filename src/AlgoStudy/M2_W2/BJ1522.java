package AlgoStudy.M2_W2;

import java.util.Scanner;

public class BJ1522 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int	A = 0, B = 0;
		int left = 1, right = str.length()-1;
		char c = str.charAt(0);
		while(left <= right) {
			if(c == str.charAt(left))
				left++;
			else break;
		}
		while(right >= 0) {
			if(c == str.charAt(right))
				right--;
			else break;
		}
		
		int l = left+1;
		int r = right;
		while(l <= r) {
			if(str.charAt(l) != str.charAt(left) && str.charAt(l) != str.charAt(r)) {
				A++;
				l++;
				r--;
			}
			else {
				if(str.charAt(left) == str.charAt(l))
					l++;
				if(str.charAt(left) != str.charAt(r))
					r--;
			}
		}
		
		l = left;
		r = right-1;
		while(l <= r) {
			if(str.charAt(r) != str.charAt(right) && str.charAt(l) != str.charAt(r)) {
				B++;
				l++;
				r--;
			}
			else {
				if(str.charAt(right) == str.charAt(r))
					r--;
				if(str.charAt(right) != str.charAt(l))
					l++;
			}
		}
		
		System.out.println(Math.min(A, B));
	}

}
