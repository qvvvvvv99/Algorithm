package AlgoStudy.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1717 {
	static int[] parent;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 합집합 연산을 union-find 알고리즘을 이용해서 한다.
		// 두 원소가 같은 집합에 포함되어 있는가는 원소를 그래프에서 각각의 노드로 생각했을 때
		// 이어져있으면 같은 집합이고 이어지지 않았으면 다른 집합
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		rank = new int[N+1];
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i <= N; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		// M * N = 100,000,000,000 => 시간초과
		// find 알고리즘 최적화 필요
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int comm = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(comm == 0) {
				union(A, B);
			}else {
				A = find(A);
				B = find(B);
				if(A == B)
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}
		
		System.out.print(sb);
	}
	
	// 시간 복잡도 : O(n-1)
	// 최적화 필요! => 최적화 시 O(logN)
	static int find(int n) {
		if(n == parent[n])
			return n;
		return parent[n] = find(parent[n]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if(a == b)
			return;
		
		if(rank[a] > rank[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		parent[a] = b;
		
		// 두 트리의 높이가 같은 경우 결과 트리의 rank를 1 증가한다.
		if(rank[a] == rank[b])
			rank[b]++;
	}

}
