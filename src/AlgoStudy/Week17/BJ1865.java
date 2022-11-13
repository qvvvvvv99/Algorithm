package AlgoStudy.Week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1865 {
	static ArrayList<Edge> graph;
	static int INF = 5000001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int N, M, W, S, E, T;
		
		for(int tc = 0; tc < TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			
			for(int i = 0; i < M + W; i++) {
				st = new StringTokenizer(br.readLine());
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				if(i < M) {
					graph.add(new Edge(S, E, T));
					graph.add(new Edge(E, S, T));
				}
				else
					graph.add(new Edge(S, E, -T));
			}
		
			sb.append(BellmaFord(N) ? "YES\n" : "NO\n");
		}
		
		System.out.print(sb);
	}
	
	static boolean BellmaFord(int v) {
		int[] dist = new int[v+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		for(int i = 0; i < v; i++) {
			for(int j = 0; j < graph.size(); j++) {
				Edge edge = graph.get(j);
				if(dist[edge.v] > dist[edge.u] + edge.cost)
					dist[edge.v] = dist[edge.u] + edge.cost;
			}
		}
		
		for(int j = 0; j < graph.size(); j++) {
			Edge edge = graph.get(j);
			if(dist[edge.v] > dist[edge.u] + edge.cost)
				return true;
		}
		
		return false;
	}

}

class Edge{
	int u;
	int v;
	int cost;
	
	Edge(int u, int v, int cost){
		this.u = u;
		this.v = v;
		this.cost = cost;
	}
}