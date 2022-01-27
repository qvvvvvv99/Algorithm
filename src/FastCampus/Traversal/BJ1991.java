package FastCampus.Traversal;

import java.io.*;

//BJ 1991번 트리 순회
//전위 순회 : 루트 출력 -> 왼쪽 자식 -> 오른쪽 자식
//중위 순회 : 왼쪽 자식 -> 루트 출력 -> 오른쪽 자식
//후위 순회 : 왼쪽 자식 -> 오른쪽 자식 -> 루트 출력

public class BJ1991 {
	// inner class 선언 시 반드시 전연변수 선언 시 static 필요하므로
	// class에도 static 필요하다!!
	// static은 컴파일 시간에 이미 생성 되므로
	// class를 static 으로 선언하지 않으면
	// class가 만들어지지 않았는데
	// 전역변수는 static으로 선언 되므로 없는 class를 선언하는 것과 같다
	// 따라서 nullpointererror가 뜬다!!
	static class Node {
		public char root;
		public char left;
		public char right;
		
		public Node(char root, char left, char right){
			this.root = root;
			this.left = left;
			this.right = right;
		}
	}
	
	static Node[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			tree[i] = new Node(input[0].charAt(0), input[1].charAt(0), input[2].charAt(0));
		}
		Node root = tree[0];

		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);
		System.out.println();
	}

	public static void preorder(Node node) {
		System.out.print(node.root);
		if (node.left != '.') {
			int i = 0;
			while(true) {
				if(tree[i].root == node.left)
					break;
				i++;
			}
			preorder(tree[i]);
		}
		if (node.right != '.') {
			int i = 0;
			while(true) {
				if(tree[i].root == node.right)
					break;
				i++;
			}
			preorder(tree[i]);
		}
	}

	public static void inorder(Node node) {
		if (node.left != '.') {
			int i = 0;
			while(true) {
				if(tree[i].root == node.left)
					break;
				i++;
			}
			inorder(tree[i]);
		}
		System.out.print(node.root);
		if (node.right != '.') {
			int i = 0;
			while(true) {
				if(tree[i].root == node.right)
					break;
				i++;
			}
			inorder(tree[i]);
		}
	}

	public static void postorder(Node node) {
		if (node.left != '.') {
			int i = 0;
			while(true) {
				if(tree[i].root == node.left)
					break;
				i++;
			}
			postorder(tree[i]);
		}
		if (node.right != '.') {
			int i = 0;
			while(true) {
				if(tree[i].root == node.right)
					break;
				i++;
			}
			postorder(tree[i]);
		}
		System.out.print(node.root);
	}

}