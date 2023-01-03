package BJAlgo.Level4;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ5639 {
	static int[] tree;
	static int N;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
 
		while(sc.hasNextInt())
			list.add(sc.nextInt());
        sc.close();
        
        N = list.size();
        tree = new int[N];
        for(int i = 0; i < N; i++)
        	tree[i] = list.get(i);
        
        sol(0, N-1);
        
        System.out.print(sb);
	}
	
	static void sol(int left, int right) {
		if(left > right || right == N)
			return;
		
		if(left == right) {
			sb.append(tree[left]).append("\n");
			return;
		}
		
		int i = left+1;
		while(i < N && tree[left] > tree[i])
			i++;
		
		sol(left+1, i-1);
		sol(i, right);
		sb.append(tree[left]).append("\n");
	}

}
