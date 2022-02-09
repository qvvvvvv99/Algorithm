package FastCampus.Greedy;

import java.io.*;
import java.util.*;

public class BJ1781 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Ramyun> pqueue = new ArrayList<Ramyun>();
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			pqueue.add(new Ramyun(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(pqueue);
		
		PriorityQueue<Integer> maxheap = new PriorityQueue<>();
		
		int sum = 0;
		while (!pqueue.isEmpty()) {
			Ramyun ramyun = pqueue.remove(0);
			maxheap.add(ramyun.num);
			if(ramyun.deadline < maxheap.size())
				maxheap.poll();
		}
		while(!maxheap.isEmpty())
			sum += maxheap.poll();
		
		System.out.println(sum);
	}

}

class Ramyun implements Comparable<Ramyun>{
	int deadline;
	int num;
	
	Ramyun(int deadline, int num){
		this.deadline = deadline;
		this.num = num;
	}

	@Override
	public int compareTo(Ramyun r) {
		// TODO Auto-generated method stub
		if(this.deadline == r.deadline)
			return r.num - this.num;
		else 
			return this.deadline - r.deadline;
	}
}