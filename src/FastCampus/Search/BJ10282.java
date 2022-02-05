package FastCampus.Search;

//BJ 10282번 해킹
//다익스트라 알고리즘 : 그리디 + DP
//다익스트라 알고리즘 -> 그래프 최소 거리 탐색 알고리즘
//한 정점에서 나머지 정점까지의 최단 거리 찾기

import java.io.*;
import java.util.*;

public class BJ10282 {
	static ArrayList<ArrayList<Computer>> graph;
	static int INF = 10000001;	// 10,000(최대 컴퓨터 수) * 1,000(감염에 걸리는 시간) = 최대 10,000,000초
	static int[] distSec;	// 도착 시간 나타내는 배열
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= tc; i++) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);	// 컴퓨터 개수
			int d = Integer.parseInt(input[1]); // 의존성 개수
			int c = Integer.parseInt(input[2]); // 해킹당한 컴퓨터 번호
			graph = new ArrayList<ArrayList<Computer>>();
			for(int j = 0; j <= n; j++)
				graph.add(new ArrayList<Computer>());
			
			for(int j = 1; j <= d; j++) {
				input = br.readLine().split(" ");
				int a = Integer.parseInt(input[0]);
				int b = Integer.parseInt(input[1]); 
				int s = Integer.parseInt(input[2]);
				graph.get(b).add(new Computer(a, s));
			}
			
			distSec = new int[n+1];
			Arrays.fill(distSec, INF);
			dijkstra(c);
			
			int cnt = 0;
			int max = 0;
			for(int j = 1; j <= n; j++) {
				if(distSec[j] != INF) {
					cnt++;
					if(max < distSec[j])
						max = distSec[j];
				}
			}
			System.out.println(cnt + " " + max);
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Computer> queue = new PriorityQueue<Computer>();
		queue.add(new Computer(start, 0));
		distSec[start] = 0;
		
		while(!queue.isEmpty()) {
			Computer curCom = queue.poll();
			if(distSec[curCom.dependIdx] < curCom.sec)
				continue;
			
			for(int i = 0; i < graph.get(curCom.dependIdx).size(); i++) {
				Computer nextCom = graph.get(curCom.dependIdx).get(i);
				if(distSec[nextCom.dependIdx] > curCom.sec + nextCom.sec) {
					distSec[nextCom.dependIdx] = curCom.sec + nextCom.sec;
					queue.add(new Computer(nextCom.dependIdx, distSec[nextCom.dependIdx]));
				}
			}
		}
	}

}

class Computer implements Comparable<Computer>{
	int dependIdx;
	int sec;
	
	Computer(int dependIdx, int sec){
		this.dependIdx = dependIdx;
		this.sec = sec;
	}

	@Override
	public int compareTo(Computer c) {
		// TODO Auto-generated method stub
		return this.sec - c.sec;
	}
	
}