package AlgoStudy.Week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1504 {
	static long[] d;
	static int p1, p2;
	static long INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		LinkedList<Route>[] list = new LinkedList[N+1];
		for(int i = 1; i <= N; i++)
			list[i] = new LinkedList<>();
		
		int u, v, cost;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			list[u].add(new Route(v, cost));
			list[v].add(new Route(u, cost));
		}
		
		d = new long[N+1];
		st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		long route1 = 0;
		long route2 = 0;
		
		dijkstra(1, list);
		
		route1 += d[p1];
		route2 += d[p2];
		
		dijkstra(p1, list);
		route1 += d[p2];
		route2 += d[N];
		
		dijkstra(p2, list);
		route1 += d[N];
		route2 += d[p1];
		
		long res = Math.min(route1, route2);
		if(res >= INF)
			res = -1;
		System.out.println(res);
	}
	
	static void dijkstra(int s, LinkedList<Route>[] list){
		Arrays.fill(d, INF);
		d[s] = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();

			Iterator iter = list[curr].iterator();
			while(iter.hasNext()) {
				Route r = (Route)iter.next();
				if(d[r.v] > d[curr] + r.cost) {
					d[r.v] = d[curr] + r.cost;
					queue.add(r.v);
				}
			}
		}
	}

}

class Route{
	int v;
	int cost;
	
	Route(int v, int cost){
		this.v = v;
		this.cost = cost;
	}	
}