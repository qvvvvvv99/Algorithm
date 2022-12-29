package BJAlgo.Level4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ12852 {
	static int[] parent, num;
	static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		parent = new int[N+1];
		num = new int[N+1];
		visited = new boolean[N+1];
		
		bfs(N);
		
		StringBuffer sb = new StringBuffer();
		sb.append(num[1]+"\n");
		int[] res = new int[num[1]+1];
		int n = 1;
		int i = num[1];
		while(i >= 0) {
			res[i] = n;
			if(n == N)
				break;
			n = parent[n];
			i--;
		}
		
		for(i = 0; i <= num[1]; i++)
			sb.append(res[i] + " ");
		System.out.println(sb);
	}

	static void bfs(int N) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visited[N] = true;
		
		int X, next;
		while(!queue.isEmpty()) {
			X = queue.poll();
			if(X == 1)
				break;
			if(X < 1)
				continue;
			if(X % 3 == 0) {
				next = X / 3;
				if(!visited[next]) {
					num[next] = num[X]+1;
					parent[next] = X;
					visited[next] = true;
					queue.add(next);
				}
			}
			if(X % 2 == 0) {
				next = X / 2;
				if(!visited[next]) {
					num[next] = num[X]+1;
					parent[next] = X;
					visited[next] = true;
					queue.add(next);
				}
			}
			next = X - 1;
			if(!visited[next]) {
				num[next] = num[X]+1;
				parent[next] = X;
				visited[next] = true;
				queue.add(next);
			}
		}
	}
}
