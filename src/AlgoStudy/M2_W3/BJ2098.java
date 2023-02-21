package AlgoStudy.M2_W3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2098 {
	static int N;
	static int[][] W;
	static int INF = 100000000;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = new int[N][N];
		int lowerBound = 0, min;
		boolean[] visited = new boolean[N];
		visited[0] = true;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			min = INF;
			for(int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
				if(W[i][j] != 0) {
					min = Math.min(min, W[i][j]);
				}
			}
			lowerBound += min;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(visited, 0, lowerBound, 0, 0));
		min = INF;
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			if(curr.bound < min) {
				int level = curr.level + 1;
				for(int i = 1; i < N; i++) {
					// 연결된 길이 없거나 이미 방문한 곳이라면 통과
					if(W[curr.idx][i] == 0 || curr.visited[i])
						continue;
					boolean[] temp = new boolean[N];
					for(int j = 0; j < N; j++) 
						temp[j] = curr.visited[j];
					temp[i] = true;
					int length = curr.length + W[curr.idx][i];
					if(level == N-1) {
						if(length + W[i][0] < min) 
							min = length + W[i][0];
					}
					else {
						int bound = getBound(temp, curr.idx, i, length);
						if(bound < min) {
							pq.add(new Node(temp, i, bound, level, length));
						}
					}
				}
			}
		}
		
		System.out.println(min);
	}
	
	static int getBound(boolean[] visited, int u, int v, int len) {
		int sum = len;
		int min;
		
		for(int i = 1; i < N; i++) {
			min = INF;
			if(v == i) {
				for(int j = 0; j < N; j++) {
					if(j == u || W[i][j] == 0)
						continue;
					min = Math.min(min, W[i][j]);
				}
			}
			else if(!visited[i]) {
				for(int j = 0; j < N; j++) {
					if(W[i][j] == 0 || (j > 0 && visited[j]))
						continue;
					min = Math.min(min, W[i][j]);
				}
			}
			else
				continue;
			sum += min;
		}
		
		return sum;
	}

}

class Node implements Comparable<Node>{
	boolean[] visited;
	int bound, level, idx, length;
	
	Node(boolean[] visited, int idx, int bound, int level, int length){
		this.visited = visited;
		this.idx = idx;
		this.bound = bound;
		this.level = level;
		this.length = length;
	}

	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return this.bound - node.bound;
	}
}
