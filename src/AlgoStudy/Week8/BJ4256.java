package AlgoStudy.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4256 {
	static int N;
	static int[] preOrder;
	static int[] inOrder;
	static StringBuffer sb = new StringBuffer();
	static int num = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			preOrder = new int[N+1];
			inOrder = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++)
				preOrder[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++)
				inOrder[i] = Integer.parseInt(st.nextToken());
			
			num = 1;
			Node root = makeBT(1, N);
			
			postOrder(root);
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

	static Node makeBT(int start, int end){
		Node root = new Node(preOrder[num]);
		num++;
		if(start == end)
			return root;
		int idx;
		
		for(idx = start; idx <= end; idx++) {
			if(preOrder[num-1] == inOrder[idx])
				break;
		}

		if(start < idx)
			root.leftChild = makeBT(start, idx-1);
		if(idx < end)
			root.rightChild = makeBT(idx+1, end);
		
		return root;
	}
	
	static void postOrder(Node node) {
		if(node.leftChild != null)
			postOrder(node.leftChild);
		if(node.rightChild != null)
			postOrder(node.rightChild);
		sb.append(node.num + " ");
	}
}

class Node{
	int num;
	Node leftChild;
	Node rightChild;
	
	Node(int num){
		this.num = num;
		leftChild = null;
		rightChild = null;
	}
}