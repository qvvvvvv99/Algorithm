package AlgoStudy.Week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ10775 {
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int res = 0;
		parent = new int[G+1];
		for(int i = 0; i <= G; i++)
			parent[i] = i;
		
		int g;
		for(int i = 0; i < P; i++) {
			g = find(Integer.parseInt(br.readLine()));
			
			if(g == 0)
				break;
			res++;
			union(g, g-1);
		}
		
		System.out.println(res);
	}

	static int find(int n) {
		if(n == parent[n])
			return n;
		return parent[n] = find(parent[n]);
	}
	
	static void union(int v1, int v2) {
		v1 = find(v1);
		v2 = find(v2);
		
		if(v1 != v2)
			parent[v1] = v2;
	}
}
