package BJAlgo.Level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1916 {
	static int[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		LinkedList<Bus>[] list = new LinkedList[N+1];
		for(int i = 1; i <= N; i++)
			list[i] = new LinkedList<>();
		
		int start, end, cost;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			list[start].add(new Bus(end, cost));
		}
		
		d = new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		d[start] = 0;
		
		for(int i = 1; i <= N; i++) 
			Collections.sort(list[i]);
	
		dijkstra(start, list);
		
		System.out.println(d[end]);
	}
	
	static void dijkstra(int s, LinkedList<Bus>[] list){
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			Iterator iter = list[curr].iterator();
			while(iter.hasNext()) {
				Bus bus = (Bus)iter.next();
				if(d[bus.desti] > d[curr] + bus.cost) {
					d[bus.desti] = d[curr] + bus.cost;
					queue.add(bus.desti);
				}
			}
		}
	}

}

class Bus implements Comparable<Bus>{
	int desti;
	int cost;
	
	Bus(int desti, int cost){
		this.desti = desti;
		this.cost = cost;
	}

	@Override
	public int compareTo(Bus bus) {
		// TODO Auto-generated method stub
		return this.cost - bus.cost;
	}
	
	
}
