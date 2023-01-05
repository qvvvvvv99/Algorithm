package AlogStudy.M1_W1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ10021 {
	static int N, C;
	static ArrayList<Node>[] graph;
	static int[][] point;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		point = new int[N][2];

		int x, y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			point[i][0] = x;
			point[i][1] = y;
		}

		visited = new boolean[N];
		int cost;
		graph = new ArrayList[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				cost = getDistance(i, j);
				if (cost < C)
					continue;
				graph[i].add(new Node(j, cost));
				graph[j].add(new Node(i, cost));
			}
		}

		System.out.println(prim());

	}

	static int getDistance(int i, int j) {
		return (int) (Math.pow(point[i][0] - point[j][0], 2) + Math.pow(point[i][1] - point[j][1], 2));
	}

	static int prim() {
		int answer = 0, cnt = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		Node curr, next;

		while (!pq.isEmpty()) {
			curr = pq.poll();
			if (visited[curr.dest])
				continue;
			visited[curr.dest] = true;
			answer += curr.cost;
			cnt++;
			if (cnt == N)
				break;

			for (int i = 0; i < graph[curr.dest].size(); i++) {
				next = graph[curr.dest].get(i);
				if (visited[next.dest])
					continue;
				pq.add(new Node(next.dest, next.cost));
			}
		}

		if(cnt < N)
			answer = -1;
		return answer;
	}

}

class Node implements Comparable<Node> {// 다음 노드의 인덱스와, 그 노드로 가는데 필요한 비용을 담고 있다.
	int dest, cost;

	Node(int dest, int cost) {
		this.dest = dest;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return this.cost - node.cost;
	}
}