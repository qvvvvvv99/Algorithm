package AlogStudy.Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1967 {
	static LinkedList<Node>[] tree;
	static boolean[] visited;
	static int max = 0;
	static int root;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if (n != 1) {
			tree = new LinkedList[n + 1];
			for (int i = 1; i <= n; i++)
				tree[i] = new LinkedList<>();
			StringTokenizer st;
			visited = new boolean[n + 1];

			int p, c, l;
			for (int i = 1; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				p = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				l = Integer.parseInt(st.nextToken());

				tree[p].add(new Node(c, l));
				tree[c].add(new Node(p, l));
			}
			dfs(1, 0);

			Arrays.fill(visited, false);
			max = 0;
			dfs(root, 0);
		}
		System.out.println(max);
	}

	static void dfs(int v, int len) {
		visited[v] = true;
		if (len > max) {
			max = len;
			root = v;
		}
		Iterator iter = tree[v].iterator();
		while (iter.hasNext()) {
			Node next = (Node) iter.next();
			if (visited[next.desti] == false)
				dfs(next.desti, len + next.len);
		}
	}

}

class Node {
	int desti;
	int len;

	Node(int desti, int len) {
		this.desti = desti;
		this.len = len;
	}
}