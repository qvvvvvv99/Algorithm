package BJAlgo.Level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1197 {
	static int V, E;
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V+1];
		for(int i = 1; i <= V; i++)
			parent[i]  = i;
		
		ArrayList<Vertex> vertexs = new ArrayList<>();
		int a, b, c;
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			vertexs.add(new Vertex(a, b, c));
		}
		
		Collections.sort(vertexs);
		
		int v, u, res = 0;
		Vertex curr;
		for(int i = 0; i < E; i++) {
			curr = vertexs.get(i);
			v = find(curr.a);
			u = find(curr.b);
			if(v != u) {
				union(v, u);
				res += curr.c;
			}
		}
		
		System.out.println(res);
	}
	
	static int find(int v) {
		if(v == parent[v])
			return v;
		return parent[v] = find(parent[v]);
	}
	
	static void union(int u, int v) {
		if(u < v)
			parent[v] = u;
		else
			parent[u] = v;
	}
}

class Vertex implements Comparable<Vertex>{
	int a, b, c;
	
	Vertex(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public int compareTo(Vertex v) {
		// TODO Auto-generated method stub
		return this.c - v.c;
	}
	
	
}
