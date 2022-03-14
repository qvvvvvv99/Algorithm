package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ16928 {
	static int cnt[] = new int[101];
	static int ladderAndSnake[] = new int[101];
	static boolean visited[] = new boolean[101];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			ladderAndSnake[start] = end;
		}
		
		bfs();
		br.close();
		
		System.out.println(cnt[100]);
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur == 100)
				return;
			
			for(int i = 1; i < 7; i++) {
				int x = cur + i;
				if(x > 100)
					continue;
				if(visited[x])
					continue;
				visited[x] = true;
				
				if(ladderAndSnake[x] != 0) {
					if(!visited[ladderAndSnake[x]]) {
						queue.add(ladderAndSnake[x]);
						visited[ladderAndSnake[x]] = true;
						cnt[ladderAndSnake[x]] = cnt[cur] + 1;
					}
				}else {
					queue.add(x);
					cnt[x] = cnt[cur] + 1;
				}
			}
		}
	}

}
