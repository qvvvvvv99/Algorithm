package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ9019 {
	static int A, B;
	static String[] res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			res = new String[10000];
			Arrays.fill(res, "");
			boolean visited[] = new boolean[10000];
			bfs(visited);
			
			sb.append(res[B]+"\n");
		}
		
		System.out.print(sb);
	}
	
	public static void bfs(boolean visited[]) {
		Queue<Integer> queue = new LinkedList<Integer>();
    	visited[A] = true;
        queue.add(A);
		
        while(!queue.isEmpty()) {
        	int n = queue.poll();
			int D = (2*n)%10000;
			int S = (n == 0) ? 9999 : n-1;
			int L = (n % 1000) * 10 + n/1000;
			int R = (n % 10) * 1000 + n/10;
    		
			if(!visited[D]) {
				queue.add(D);
				visited[D] = true;
				res[D] = res[n]+"D";
			}
			if(!visited[S]) {
				queue.add(S);
				visited[S] = true;
				res[S] = res[n]+"S";
			}
			if(!visited[L]) {
				queue.add(L);
				visited[L] = true;
				res[L] = res[n]+"L";
			}
			if(!visited[R]) {
				queue.add(R);
				visited[R] = true;
				res[R] = res[n]+"R";
			}
			
			if(visited[B])
				break;
        }
		
	}

}
