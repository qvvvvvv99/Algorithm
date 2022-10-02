package BJAlgo.Level4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BJ13549 {
	static int[] sec = new int[100001];
	static int n, k;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		bfs();
		
		System.out.println(sec[k]);
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		int curr;
		Arrays.fill(sec, 100001);
		sec[n] = 0;
		
		while(!queue.isEmpty()) {
			curr = queue.poll();
			
			if(curr > 0 && sec[curr-1] > sec[curr]+1) {
				queue.add(curr-1);
				sec[curr-1] = sec[curr]+1;
			}
			if(curr < 100000 && sec[curr+1] > sec[curr]+1) {
				queue.add(curr+1);
				sec[curr+1] = sec[curr]+1;
			}
			if(curr <= 50000 && sec[curr*2] > sec[curr]) {
				queue.add(curr*2);
				sec[curr*2] = sec[curr];
			}
		}
	}

}
