package AlgoStudy.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ9885 {
	static int[] w;
	static int[] grade;
	static LinkedList<Node>[] binaryTree;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int chi, par, wei;
		binaryTree = new LinkedList[n + 1];
		for (int i = 1; i <= n; i++)
			binaryTree[i] = new LinkedList<Node>();
		int root = 1;
		w = new int[n + 1];
		grade = new int[n + 1];
		max = 0;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			chi = Integer.parseInt(st.nextToken());
			par = Integer.parseInt(st.nextToken());
			wei = Integer.parseInt(st.nextToken());
			binaryTree[par].add(new Node(chi, wei));
			if (root == chi)
				root = par;
		}

		dfs(root, 0);
		postOrder(root, 0);
		dfs2(root, 0);

		for (int i = 1; i <= n; i++)
			System.out.print(grade[i] + " ");

		System.out.println();
		System.out.println(max);
	}

	static void dfs(int root, int res) {
		Iterator iter = binaryTree[root].iterator();
		while (iter.hasNext()) {
			Node child = (Node) iter.next();
			w[child.dire] = res + child.weight;
			dfs(child.dire, w[child.dire]);
		}
	}

	static int postOrder(int root, int sub) {
		Iterator iter = binaryTree[root].iterator();
		if (!iter.hasNext()) {
			grade[root] = w[root];
		} else {
			int res = 0;
				Node child = (Node) iter.next();
				res += postOrder(child.dire, 0);
				if(iter.hasNext()) {
					child = (Node) iter.next();
					res += postOrder(child.dire, 0);
					grade[root] = res - w[root];
				}
				else {
					grade[root] = res;
				}
				
		}
		return grade[root];
	}
	
	static void dfs2(int root, int sum) {
		sum += grade[root];
		Iterator iter = binaryTree[root].iterator();
		if (!iter.hasNext()) {
			if(max < sum)
				max = sum;
		} else {
			while (iter.hasNext()) {
				Node child = (Node) iter.next();
				dfs2(child.dire, sum);
			}
		}
	}
}

class Node {
	int dire;
	int weight;

	Node(int dire, int weight) {
		this.dire = dire;
		this.weight = weight;
	}
}