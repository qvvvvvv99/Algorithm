package FastCampus.Heap;

import java.util.*;

public class BJ1715 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++)
			queue.add(sc.nextInt());
		
		int res = 0;
		
		while(queue.size() > 1) {
			int val1 = queue.poll();
			int val2 = queue.poll();
			int sum = val1 + val2;
			res += sum;
			queue.add(sum);
		}
		
		System.out.println(res);
	}

}
