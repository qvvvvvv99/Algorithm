package AlgoStudy.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2098 {
	static int N;
	static int[][] W;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		int min;
		int lowBound = 0;
		ArrayList<Integer> tour = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			min = 1000000000;
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
				if (W[i][j] == 0)
					continue;
				min = Math.min(min, W[i][j]);
			}
			lowBound += min;
		}
		// 외판원 순회

		// 완전 탐색 : N개의 도시가 있을 때, 최악의 경우 시간복잡도 N! -> N의 범위상 시간초과
		// 전에 방문한 정점은 방문하지 않아야 하기에 visited 처리 중요
		// 정점 선택의 경우 가질 수 있는 최소값을 근사로 추정하여 정점 선택을 이어나감
		// 가질 수 있는 최소의 순환값이 클 경우 가지치기
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		tour.add(0);
		pq.add(new Node(tour, lowBound));
		min = 1000000000;

		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			if (curr.bound < min) {
				for (int i = 0; i < N; i++) {
//					System.out.println(curr.path.lastIndexOf(0));
//					System.out.println(curr.path.contains(i));
					if (W[curr.path.get(curr.path.size()-1)][i] == 0 || curr.path.contains(i))
						continue;
					ArrayList<Integer> p = new ArrayList<>();
					p.addAll(curr.path);
					p.add(i);
					Node next = new Node(p, 0);
					if (next.path.size() == N) {
						int tourLen = length(next.path);
						if (tourLen < min)
							min = tourLen;
					} else {
						next.bound = bound(next.path);
						if (next.bound < min)
							pq.add(next);
					}

				}
			}
		}

		System.out.println(min);
	}

	static int length(ArrayList<Integer> path) {
		int sum = 0;
		for (int i = 0; i < N - 1; i++) {
			sum += W[path.get(i)][path.get(i + 1)];
		}
		sum += W[path.get(N - 1)][path.get(0)];

		return sum;
	}

	static int bound(ArrayList<Integer> path) {
		int sum = 0;
		int min;

		int len;
		for (len = 0; len < path.size() - 1; len++)
			sum += W[path.get(len)][path.get(len + 1)];

		for (int i = 1; i < N; i++) {
			min = 1000000000;
			if (!path.contains(i) || (path.contains(i) && i == path.get(len))) {
				for (int j = 0; j < N; j++) {
					if (W[i][j] == 0 || (i == path.get(len) && j == path.get(len - 1)) || (j != 0 && path.contains(j)))
						continue;
					min = Math.min(min, W[i][j]);
				}
				sum += min;
			}
		}

		return sum;
	}

}

class Node implements Comparable<Node> {
	ArrayList<Integer> path;
	int bound;

	Node(ArrayList<Integer> path, int bound) {
		this.path = path;
		this.bound = bound;
	}

	@Override
	public int compareTo(Node node) {
		// TODO Auto-generated method stub
		return this.bound - node.bound;
	}
}