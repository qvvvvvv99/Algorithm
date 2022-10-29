package AlgoStudy.Week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(maxPQ.size() == minPQ.size()) 
				maxPQ.add(num);
			
			else
				minPQ.add(num);
			
			if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
				minPQ.add(maxPQ.poll());
				maxPQ.add(minPQ.poll());
			}
			sb.append(maxPQ.peek() + "\n");
		}

		System.out.println(sb);
	}

}
