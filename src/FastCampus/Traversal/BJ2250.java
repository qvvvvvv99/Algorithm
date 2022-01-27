package FastCampus.Traversal;

// BJ 2250번 트리 높이와 너비

import java.util.*;

public class BJ2250 {
	static Node[] tree;
	static int[][] table;
	static Node root;
	static final int level = 0;	// table에서 노드의 level을 나타내는 칸
	static final int X = 1;	// table에서 노드의 x좌표를 나타내는 칸
	static int cnt = 1;	// 각 노드의 자리 나타내는 정수
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		tree = new Node[N+1];
		table = new int[N+1][2];
		int maxLevel = 1;
		
		for(int i = 1; i <= N; i++)
			tree[i] = new Node(i, -1, -1);
		
		for(int i = 0; i < N; i++) {
			int center = sc.nextInt();
			int lChild = sc.nextInt();
			int rChild = sc.nextInt();
			if(lChild != -1) {
				tree[center].leftChild = lChild;
				tree[lChild].parent = center;
			}
			if(rChild != -1) {
				tree[center].rightChild = rChild;
				tree[rChild].parent = center;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(tree[i].parent == -1) {
				root = tree[i];
				break;
			}
		}
		
		table[root.center][level] = 1;
		
		inorder(root);
		
		for(int i = 1; i <= N; i++) {
			if(maxLevel < table[i][level])
				maxLevel = table[i][level];
		}
		
		int resWidth = 1;
		int resLevel = 1;
		for(int i = maxLevel; i >= 1; i--) {
			int minX = N, maxX = 1;
			for(int j = 1; j <= N; j++) {
				if(table[j][level] == i) {
					if(minX > table[j][X])
						minX = table[j][X];
					if(maxX < table[j][X])
						maxX = table[j][X];
				}
			}
			if(resWidth <= maxX-minX+1) {
				resWidth = maxX-minX+1;
				resLevel = i;
			}
		}
		
		System.out.println(resLevel + " " + resWidth);
	}

	public static void inorder(Node node) {
		if(node.leftChild != -1) {
			table[node.leftChild][level] = table[node.center][level]+1;
			inorder(tree[node.leftChild]);
		}
		table[node.center][X] = cnt;
		cnt++;
		if(node.rightChild != -1) {
			table[node.rightChild][level] = table[node.center][level]+1;
			inorder(tree[node.rightChild]);
		}
	}
}

class Node{
	int center;
	int leftChild;
	int rightChild;
	int parent;
	
	public Node(int center, int leftChild, int rightChild) {
		this.center = center;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.parent = -1;
	}
}