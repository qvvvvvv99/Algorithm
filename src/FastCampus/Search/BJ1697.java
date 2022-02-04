package FastCampus.Search;

// BJ 1697번 숨바꼭질

import java.util.*;

public class BJ1697 {
	static int MAX = 100001;
	static int[] level;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// N : 수빈의 위치
		int K = sc.nextInt();	// K : 동생의 위치
		level = new int[MAX];
		
		bfs(N, K);
	}
	
	public static void bfs(int N, int K) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		int next;
		
		while(queue.size() != 0) {
			N = queue.poll();
			if(N == K) {
				System.out.println(level[N]);
				break;
			}
			next = N - 1;
			if(next >= 0 && level[next] == 0) {
				queue.add(next);
				level[next] = level[N] + 1;
			}
			next = N + 1;
			if(next < MAX && level[next] == 0) {
				queue.add(next);
				level[next] = level[N] + 1;
			}
			next = N * 2;
			if(next < MAX && level[next] == 0) {
				queue.add(next);
				level[next] = level[N] + 1;
			}
		}
	}

}
