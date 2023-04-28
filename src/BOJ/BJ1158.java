package BOJ;

import java.util.Scanner;

public class BJ1158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		boolean[] num = new boolean[N+1];
		int cnt = N;
		StringBuffer sb = new StringBuffer();
		sb.append("<");
		sb.append(K);
		num[K] = true;
		cnt--;
		int idx = K;
		
		while(cnt > 0) {
			int n = 0;
			while(n < K) {
				idx++;
				if(idx > N)
					idx = 1;
				if(!num[idx]) {
					n++;
				}
			}
			num[idx] = true;
			cnt--;
			sb.append(", ").append(idx);
		}
		
		sb.append(">");
		System.out.println(sb);
	}

}
