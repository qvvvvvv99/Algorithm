package BJAlgo.Level4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class BJ15666 {
	static int N, M;
	static int[] ary;
	static int[] res;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		res = new int[M];
		
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < N; i++)
			hs.add(sc.nextInt());
		
		N = hs.size();
		ary = new int[N];
		Iterator iter = hs.iterator();
		int i = 0;
		while(iter.hasNext()) {
			ary[i] = (int) iter.next();
			i++;
		}
		Arrays.sort(ary);
		
		dfs(0, 0);
		
		System.out.print(sb);
	}

	static void dfs(int cnt, int idx) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(res[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = idx; i < N; i++) {
			res[cnt] = ary[i];
			cnt++;
			dfs(cnt, i);
			cnt--;
		}
	}
}
