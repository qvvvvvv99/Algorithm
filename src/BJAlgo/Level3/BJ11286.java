package BJAlgo.Level3;

import java.util.*;

public class BJ11286 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		PriorityQueue<Integer> absMaxHeap = new PriorityQueue<>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer n1, Integer n2) {
						// TODO Auto-generated method stub
						if(Math.abs(n1) == Math.abs(n2))
							return n1 - n2;
						return Math.abs(n1) - Math.abs(n2);
//						if(Math.abs(n1) > Math.abs(n2))
//							return 1;
//						else if(Math.abs(n1) < Math.abs(n2))
//							return -1;
//						else {
//							if(n1 > n2)
//								return 1;
//							else if(n1 == n2)
//								return 0;
//							else
//								return -1;
//						}
					}
				});
		
		for(int i = 0; i < N; i ++) {
			int x = sc.nextInt();
			if (x != 0)
				absMaxHeap.add(x);
			else {
				if(absMaxHeap.isEmpty())
					sb.append(0+"\n");
				else
					sb.append(absMaxHeap.poll() + "\n");
			}
		}

		System.out.print(sb);
	}

}
