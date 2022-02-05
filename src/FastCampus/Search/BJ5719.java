package FastCampus.Search;

// BJ 5719번 거의 최단 경로

import java.io.*;
import java.util.*;

public class BJ5719 {
	static ArrayList<ArrayList<Road>> route;
	static ArrayList<ArrayList<Road>> reverse_route;
	static int INF = 10000001; // 도로의 수 * 각 도로 길이
	static int lenght[];
	static boolean drop[][];
	static int S;
	static int D;
	static boolean[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);	// N : 장소의 수(정점)
			int M = Integer.parseInt(input[1]);	// M : 도로의 수(간선)
			if(N == 0)
				break;
			route = new ArrayList<ArrayList<Road>>();
			reverse_route = new ArrayList<ArrayList<Road>>();
			drop = new boolean[N][N];
			lenght = new int[N];
			check = new boolean[N];
			for(int i = 0; i < N; i++) {
				route.add(new ArrayList<Road>());
				reverse_route.add(new ArrayList<Road>());
			}
			input = br.readLine().split(" ");
			S = Integer.parseInt(input[0]);	// S : 시작점
			D = Integer.parseInt(input[1]); // D : 도착점
			for(int i = 0; i < M; i++) {
				input = br.readLine().split(" ");
				int U = Integer.parseInt(input[0]);	// U에서
				int V = Integer.parseInt(input[1]);	// V로 가는 도로
				int P = Integer.parseInt(input[2]);	// 의 길이 P
				route.get(U).add(new Road(V, P));
				reverse_route.get(V).add(new Road(U, P));
			}
			
			Arrays.fill(lenght, INF);
			dijkstra(S, D);
			bfs();
			Arrays.fill(lenght, INF);
			dijkstra(S, D);
			
			if(lenght[D] != INF)
				System.out.println(lenght[D]);
			else
				System.out.println(-1);
		}
	}
	
	public static void dijkstra(int start, int end) {
		PriorityQueue<Road> queue = new PriorityQueue<Road>();
		lenght[start] = 0;
		queue.add(new Road(start, 0));
		
		while(!queue.isEmpty()) {
			Road curRoad = queue.poll();
			if(lenght[curRoad.dest] < curRoad.len)
				continue;
			
			for(int i = 0; i < route.get(curRoad.dest).size(); i++) {
				Road nextRoad = route.get(curRoad.dest).get(i);
				if((lenght[nextRoad.dest] > nextRoad.len + lenght[curRoad.dest]) && (drop[curRoad.dest][nextRoad.dest] == false)) {
					lenght[nextRoad.dest] = nextRoad.len + lenght[curRoad.dest];
					queue.add(new Road(nextRoad.dest, lenght[nextRoad.dest]));
				}
			}
		}
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(D);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i = 0; i < reverse_route.get(now).size(); i++) {
				Road pre =  reverse_route.get(now).get(i);
				if(lenght[now] == pre.len + lenght[pre.dest]) {
					drop[pre.dest][now] = true;
					if(check[pre.dest] == false)
						queue.add(pre.dest);
					check[pre.dest] = true;
				}
			}
		}
	}
}

class Road implements Comparable<Road>{
	int dest;
	int len;
	
	Road(int dest, int len){
		this.dest = dest;
		this.len = len;
	}

	@Override
	public int compareTo(Road r) {
		// TODO Auto-generated method stub
		return this.len - r.len;
	}
}