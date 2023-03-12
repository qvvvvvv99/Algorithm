package BJAlgo.Level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2623 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] map = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			map[i] = new ArrayList<>();
		int[] cnt = new int[N+1];
		int num, u, v;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			for(int j = 1; j < num; j++) {
				v = Integer.parseInt(st.nextToken());
				cnt[v]++;
				map[u].add(v);
				u = v;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(cnt[i] == 0)
				queue.add(i);
		}
		
		StringBuffer sb = new StringBuffer();
		int curr;
		while(!queue.isEmpty()) {
			curr = queue.poll();
			sb.append(curr).append("\n");
			for(int i = 0; i < map[curr].size(); i++) {
				int next = map[curr].get(i);
				cnt[next]--;
				if(cnt[next] == 0)
					queue.add(next);
			}
		}
		
		boolean flag = true;
		for(int i = 1; i <= N; i++) {
			if(cnt[i] > 0) {
				flag = false;
				break;
			}
		}
		
		if(!flag)
			System.out.println(0);
		else
			System.out.print(sb);
	}

}
