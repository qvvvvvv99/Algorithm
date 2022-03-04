package BJAlgo.Level3;

import java.util.*;

public class BJ11279 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			if(x == 0) {
				if(heap.isEmpty())
					sb.append(0+"\n");
				else
					sb.append(heap.poll()+"\n");
			}
			else
				heap.add(x);
		}
		
		System.out.print(sb);
	}

}
