package SDS.DAY06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1922 {
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Network[] network = new Network[M];
		int minPrice = 0;
		int cnt = 0;
		parent = new int[N+1];
		for(int i = 1; i <= N; i++)
			parent[i] = i;
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			network[i] = new Network(v1, v2, p);
		}
		
		Arrays.sort(network);
		
		for(int i = 0; i < M; i++) {
			Network nw = network[i];
			int v1 = find(nw.v1);
			int v2 = find(nw.v2);
			if(v1 != v2) {
				union(v1, v2);
				minPrice += nw.price;
				cnt++;
			}
			if(cnt == N-1)
				break;
		}
		
		System.out.println(minPrice);
	}
	
	static int find(int a) {
		if(a == parent[a])
			return a;
		return find(parent[a]);
	}
	
	static void union(int v1, int v2) {
		parent[v2] = v1;
	}
}

class Network implements Comparable<Network>{
	int v1;
	int v2;
	int price;
	
	Network(int v1, int v2, int price){
		this.v1 = v1;
		this.v2 = v2;
		this.price = price;
	}

	@Override
	public int compareTo(Network network) {
		// TODO Auto-generated method stub
		return this.price - network.price;
	}
}
