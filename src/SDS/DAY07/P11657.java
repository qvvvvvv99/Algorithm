package SDS.DAY07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P11657 {
	static long[] dist;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		dist = new long[V + 1];
		Arrays.fill(dist, Long.MAX_VALUE);

		Node[] edges = new Node[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Node(v1, v2, c);
		}

		StringBuffer sb = new StringBuffer();
		if (BellmanFord(edges, E, V)) {
			for (int i = 2; i <= V; i++) {
				if (dist[i] == Long.MAX_VALUE)
					dist[i] = -1;
				sb.append(dist[i]+"\n");
			}
		}
		else
			sb.append(-1+"\n");
		
		System.out.print(sb);
	}

	static boolean BellmanFord(Node[] edges, int E, int V) {
		dist[1] = 0;
		boolean flag = true;
		int a, b, c;
		
		for (int i = 1; i <= V; i++) {
			for (int j = 0; j < E; j++) {
				a = edges[j].v1;
				b = edges[j].v2;
				c = edges[j].cost;
				if (dist[a] == Long.MAX_VALUE)
					continue;
				if(dist[b] > dist[a] + c){
					if(i == V) 
						flag = false;
					dist[b] = dist[a] + c;
				}
			}
		}
		
		return flag;
	}

}

class Node {
	int v1;
	int v2;
	int cost;

	Node(int v1, int v2, int cost) {
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
}