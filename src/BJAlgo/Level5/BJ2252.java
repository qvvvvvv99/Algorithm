package BJAlgo.Level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2252 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cnt = new int[N+1];
		
		ArrayList<Integer>[] map = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			map[i] = new ArrayList<>();
		
		int u, v;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			map[u].add(v);
			cnt[v]++;
		}
		
		sol(map, cnt);
	}
	
	static void sol(ArrayList<Integer>[] map, int[] cnt) {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i < cnt.length; i++) {
			if(cnt[i] == 0)
				queue.add(i);
		}
		
		StringBuffer sb = new StringBuffer();
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr).append(" ");
			
			for(int node : map[curr]) {
				cnt[node]--;
				if(cnt[node] == 0)
					queue.add(node);
			}
		}
		
		System.out.println(sb);
	}

}
