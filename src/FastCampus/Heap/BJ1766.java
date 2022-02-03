package FastCampus.Heap;

// BJ 1766번 문제집
// 위상정렬

import java.io.*;
import java.util.*;

public class BJ1766 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);	// 문제의 수 (1<=N<=32000)
		int M = Integer.parseInt(input[1]);	// 먼저 푸는 것이 좋은 문제에 대한 정보 수 (1<=N<=100000)
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		ArrayList<ArrayList <Integer>> ary = new ArrayList<>();
		for(int i = 0; i <= N; i++)
			ary.add(new ArrayList<Integer>());
		StringBuilder sb = new StringBuilder();
		int degree[] = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			ary.get(a).add(b);
			degree[b] += 1;
		}
		
		// 1) 진입 차수가 0인 정점을 큐에 삽입
		for(int i = 1; i <= N; i++) {
			if(degree[i] == 0)
				heap.add(i);
		}
		// 2) 큐에서 원소를 꺼내 해당 원소와 간선을 제거
		// 3) 제거 이후에 진입 차수가 0이 된 정점을 큐에 삽입
		while(!heap.isEmpty()) {
			int n = heap.poll();
			sb.append(n + " ");
			for(int i : ary.get(n)) {
				degree[i] -= 1;
				if(degree[i] == 0)
					heap.add(i);
			}
		}
		// 4) 큐가 빌 때까지 2-3과정 반복
		
		System.out.println(sb);
	}

}