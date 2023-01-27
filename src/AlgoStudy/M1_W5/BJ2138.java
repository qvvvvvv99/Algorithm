package AlgoStudy.M1_W5;

import java.util.Scanner;

public class BJ2138 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String curr = sc.next();
		String want = sc.next();
		boolean[] same = new boolean[n];
		int res1, res2;
		
		for(int i = 0; i < n; i++) {
			if(curr.charAt(i) == want.charAt(i))
				same[i] = true;
		}
		
		// 첫번째 스위치 안누른 경우
		res1 = sol(n, same);
		
		same = new boolean[n];
		for(int i = 0; i < n; i++) {
			if(curr.charAt(i) == want.charAt(i))
				same[i] = true;
		}
		// 첫번째 스위치 누른 경우
		same[0] = !same[0];
		same[1] = !same[1];
		res2 = sol(n,same);
		if(res2 != Integer.MAX_VALUE)
			res2++;
		
		if(res1 == Integer.MAX_VALUE && res2 == Integer.MAX_VALUE)
			System.out.println(-1);
		else 
			System.out.println(Math.min(res1, res2));
	}
	
	static int sol(int n, boolean[] same) {
		int num = 0;
		for(int i = 1; i < n-1; i++) {
			if(!same[i-1]) {
				num++;
				for(int j = i-1; j <= i+1; j++)
					same[j] = !same[j];
			}
		}
		if(!same[n-2]) {
			num++;
			same[n-2] = !same[n-2];
			same[n-1] = !same[n-1];
		}
		
		for(int i = 0; i < n; i++) {
			if(!same[i]) {
				num = Integer.MAX_VALUE;
				break;
			}
		}
		
		return num;
	}

}
