package BJAlgo.Level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ11779 {
	static int[] dist, parent;
	static ArrayList[] graph;
	static int INF = 1000000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		dist = new int[n+1];
		graph = new ArrayList[n+1];
		for(int i = 1; i <= n; i++)
			graph[i] = new ArrayList<Node>();
		
		int u, v, c;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dist, INF);
		dist[start] = 0;
		dijkstra(start);

		System.out.println(dist[end]);
		int idx = end;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(end);
		while(idx != start) {
			list.add(parent[idx]);
			idx = parent[idx];
		}
		
		System.out.println(list.size());
		StringBuffer sb = new StringBuffer();
		for(int i = list.size()-1; i >= 0; i--) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
			
	}
	
	static void dijkstra(int s) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(s, 0));
		
		Node curr, next;
		while(!queue.isEmpty()) {
			curr = queue.poll();
			if(dist[curr.v] < curr.c)
				continue;
			for(int i = 0; i < graph[curr.v].size(); i++) {
				next = (Node) graph[curr.v].get(i);
				if(dist[next.v] > dist[curr.v] + next.c) {
					dist[next.v] = dist[curr.v] + next.c;
					queue.add(new Node(next.v, dist[next.v]));
					parent[next.v] = curr.v;
				}
			}
		}
	}

}

class Node implements Comparable<Node>{
	int v, c;
	
	Node(int v, int c){
		this.v = v;
		this.c = c;
	}
	
	public int compareTo(Node node) {
		return this.c - node.c;
	} 
}