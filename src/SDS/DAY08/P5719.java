package SDS.DAY08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5719 {
	static int N, M;
	static int[] length;
	static LinkedList<Road>[] route;
	static LinkedList<Road>[] reverse_route;
	static boolean[] visited;
	static boolean[][] impossible;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0)
				break;
			
			route = new LinkedList[N];
			reverse_route = new LinkedList[N];
			for(int i = 0; i < N; i++) {
				route[i] = new LinkedList<Road>();
				reverse_route[i] = new LinkedList<Road>();
			}
			
			length = new int[N];
			visited = new boolean[N];
			impossible = new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				route[U].add(new Road(V, P));
				reverse_route[V].add(new Road(U, P));
			}

			Arrays.fill(length, Integer.MAX_VALUE);
			dijkstra(S);
			bfs(D);
			Arrays.fill(length, Integer.MAX_VALUE);
			dijkstra(S);
			
			if(length[D] != Integer.MAX_VALUE)
				sb.append(length[D]+"\n");
			else
				sb.append(-1+"\n");
		}
		
		System.out.print(sb);
	}
	
	static void dijkstra(int start) {
		length[start] = 0;
		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.add(new Road(start, 0));
		
		while(!pq.isEmpty()) {
			Road current = pq.poll();
			
			if(length[current.dest] < current.len)
				continue;
			
			Iterator<Road> iter = route[current.dest].iterator();
			while(iter.hasNext()) {
				Road next = iter.next();
				if(length[next.dest] > length[current.dest] + next.len && impossible[current.dest][next.dest] == false) {
					length[next.dest] = length[current.dest] + next.len;
					pq.add(new Road(next.dest, length[next.dest]));
				}
			}
		}
	}

	static void bfs(int end) {
		Queue<Integer> queue = new LinkedList<>(); 
		queue.add(end);
		visited[end] = true;
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			Iterator<Road> iter = reverse_route[curr].iterator();
			while(iter.hasNext()) {
				Road pre = iter.next();
				if(length[curr] == length[pre.dest] + pre.len) {
					impossible[pre.dest][curr] = true;
					if(visited[pre.dest] == false)
						queue.add(pre.dest);
					visited[pre.dest] = true;
				}
			}
			
		}
	}
}

class Road implements Comparable<Road>{
	int dest;
	int len;
	
	Road(int dest, int len){
		this.dest = dest;
		this.len = len;
	}

	@Override
	public int compareTo(Road road) {
		// TODO Auto-generated method stub
		return this.len - road.len;
	}
	
	
}
