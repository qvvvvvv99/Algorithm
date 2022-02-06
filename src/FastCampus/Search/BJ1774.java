package FastCampus.Search;

// BJ 1774번 우주신과의 교감
// 최소신장트리(MST)
// 크루스칼 알고리즘

import java.io.*;
import java.util.*;

public class BJ1774 {
	static int parent[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);	
		int M = Integer.parseInt(input[1]);
		ArrayList<Location> locations = new ArrayList<>();
		List<Node> node = new ArrayList<>();
		parent = new int[N+1];
		
		for(int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);	
			int y = Integer.parseInt(input[1]);
			locations.add(new Location(x, y));
		}
		for(int i = 0; i < locations.size(); i++) {
			for(int j = i+1; j < locations.size(); j++) 
				node.add(new Node(i+1, j+1, get_distance(locations.get(i), locations.get(j))));
		}
		
		for(int i = 1; i <= N; i++)
			parent[i] = i;
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int v1 = Integer.parseInt(input[0]);	
			int v2 = Integer.parseInt(input[1]);
			union(v1, v2);
		}
		
		Collections.sort(node);
		
		double res = 0;
		for(int i = 0; i < node.size(); i++) {
			if(find_parent(node.get(i).v1, node.get(i).v2) == false) {
				union(node.get(i).v1, node.get(i).v2);
				res += node.get(i).len;
			}
		}
		
		System.out.printf("%.2f%n", res);
	}
	
	public static double get_distance(Location l1, Location l2) {
		return Math.sqrt(Math.pow((l1.x-l2.x), 2) + Math.pow((l1.y-l2.y), 2));
	}
	
	public static int get_parent(int n) {
		if(parent[n] == n)
			return n;
		return get_parent(parent[n]);
	}
	
	public static boolean find_parent(int a, int b) {
		a = get_parent(a);
		b = get_parent(b);
		if(a == b)
			return true;
		else
			return false;
	}
	
	public static void union(int a, int b) {
		a = get_parent(a);
		b = get_parent(b);
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
}

class Location{
	int x;
	int y;
	
	Location(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Node implements Comparable<Node>{
	int v1;
	int v2;
	double len;
	
	Node(int v1, int v2, double len){
		this.v1 = v1;
		this.v2 = v2;
		this.len = len;
	}

	@Override
	public int compareTo(Node node){
		// TODO Auto-generated method stub
		if(node.len > this.len)
			return -1;
		else if(node.len < this.len)
			return 1;
		else 
			return 0;
	}
}