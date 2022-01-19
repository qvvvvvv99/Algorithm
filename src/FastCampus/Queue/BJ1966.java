package FastCampus.Queue;

import java.util.*;

//BJ 1966번 프린터 큐

public class BJ1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i = 0; i < tc; i++) {
			List<Integer> queue = new ArrayList<Integer>();
			int first = 0, cnt = 0;
			int N, M;
			N = sc.nextInt();
			M = sc.nextInt();
			for(int j = 0; j < N; j++) {
				queue.add(sc.nextInt());
			}
			
			while(true) {
				int max = queue.get(first);
				for(int j = 0; j < N; j++) {
					if(max < queue.get(j))
						max = queue.get(j);
				}
				
				if(queue.get(first) >= max) {
					cnt++;
					if(M == first)
						break;
					queue.set(first, 0);
				}
				first++;
				first %= N;
			}
			
			System.out.println(cnt);
		}
	}

}