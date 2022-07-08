package BJAlgo.Level4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ16953 {
	static int A, B;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();

		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<AB> queue = new LinkedList<AB>();
		queue.add(new AB(A, 1));
		
		while(!queue.isEmpty()) {
			AB curr = queue.poll();
			long num = curr.num;
			int cnt = curr.cnt;
			
			if(num == B)
				return cnt;
			if(num * 2 == B || num * 10+1 == B)
				return cnt+1;
			if(num * 2 < B)
				queue.add(new AB(num*2, cnt+1));
			if(num * 10 + 1 < B)
				queue.add(new AB(num*10+1, cnt+1));
		}
		
		return -1;
	}

}

class AB{
	long num;
	int cnt;
	
	AB (long num , int cnt){
		this.num = num;
		this.cnt = cnt;
	}
}