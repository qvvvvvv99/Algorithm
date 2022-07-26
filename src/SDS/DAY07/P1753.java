package SDS.DAY07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class P1753 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		int[] len = new int[V+1];
		Arrays.fill(len, Integer.MAX_VALUE);
		
		LinkedList<Path>[] adjList = new LinkedList[V+1];
		for(int i = 1; i <= V; i++)
			adjList[i] = new LinkedList<Path>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			adjList[v].add(new Path(u, l));
		}
		
		dijkstra(K, len, adjList);
		
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= V; i++) {
			if(len[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(len[i]+"\n");
		}
		
		System.out.print(sb);
	}
	
	static void dijkstra(int root, int[] len, LinkedList<Path>[] adjList) {
		PriorityQueue<Path> heap = new PriorityQueue<>();
		len[root] = 0;
		heap.add(new Path(root, 0));
		
		while(!heap.isEmpty()) {
			Path p = heap.poll();
			if(len[p.dest] < p.val)
				continue;
			
			Iterator<Path> iter = adjList[p.dest].iterator();
			while(iter.hasNext()) {
				Path next = iter.next();
				if(len[next.dest] > len[p.dest]+next.val) {
					len[next.dest] = len[p.dest]+next.val;
					heap.add(new Path(next.dest, len[next.dest]));
				}
			}
		}
	}

}

class Path implements Comparable<Path>{
	int dest;
	int val;
	
	Path(int dest, int val){
		this.dest = dest;
		this.val = val;
	}

	@Override
	public int compareTo(Path path) {
		// TODO Auto-generated method stub
		return this.val - path.val;
	}
}
