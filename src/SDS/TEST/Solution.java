package SDS.TEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static long max;
	static int[] score;
	static LinkedList<Edge>[] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int start, end, dir;
		StringBuffer sb = new StringBuffer();
		boolean[] visited;

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			score = new int[N + 1];
			max = 0;
			visited = new boolean[N + 1];

			graph = new LinkedList[N + 1];
			for (int i = 1; i <= N; i++)
				graph[i] = new LinkedList<Edge>();

			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				score[i] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				if (dir == 2)
					graph[start].add(new Edge(end, dir));
				graph[end].add(new Edge(start, dir));
			}
			dfs(N, 0, maxHeap, visited);

			sb.append("#" + (tc + 1) + " " + max + "\n");
		}

		System.out.print(sb);
	}

	static void dfs(int v, long res, PriorityQueue<Integer> maxHeap, boolean[] visited) {
		visited[v] = true;
		if (visited[1] == true) {
			Iterator iter = graph[1].iterator();
			while (iter.hasNext()) {
				Edge next = (Edge) iter.next();
				if (!visited[next.dest])
					maxHeap.add(score[next.dest]);
			}
			res += maxHeap.poll();
		}
		int num;

		Iterator iter = graph[v].iterator();
		while (iter.hasNext()) {
			Edge next = (Edge) iter.next();
			if (!visited[next.dest]) {
				if (v != N) {
					if (next.dir == 1) {
						PriorityQueue<Integer> newHeap = new PriorityQueue<>(Collections.reverseOrder());
						num = maxHeap.poll();
						res += num;
						dfs(next.dest, res, newHeap, visited);
						res -= num;
						maxHeap.add(num);
						visited[next.dest] = false;
					} else {
						dfs(next.dest, res, maxHeap, visited);
					}
				}
			}
		}
	}
}

class Edge implements Comparable<Edge> {
	int dest;
	int dir;

	Edge(int dest, int dir) {
		this.dest = dest;
		this.dir = dir;
	}

	@Override
	public int compareTo(Edge e) {
		// TODO Auto-generated method stub
		return e.dir - this.dir;
	}
}
