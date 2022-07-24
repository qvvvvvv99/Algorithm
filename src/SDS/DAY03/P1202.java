package SDS.DAY03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1202 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N, K 입력 받기 (1 <= N, K <= 300,000)
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Jewelry[] jewelry = new Jewelry[N];
		// N개의 보석 정보 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			jewelry[i] = new Jewelry(w, p);
		}
		// N개의 보석을 무게 기준 오름차순 정렬
		Arrays.sort(jewelry);
		
		// K개의 가방 무게 입력받기
		int[] bag = new int[K];
		for(int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		// K개의 가방 오름 차순 정렬(무게가 작은 가방부터 채우기)
		Arrays.sort(bag);
		
		// idx : 보석 정보 위치 가르키는 인덱스 번호
		int idx = 0;
		// 보석 무게 저장할 최대힙
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		long res = 0;
		
		// 종료조건 : 가방에 모두 보석을 담았으면 종료
		for(int i = 0; i < K; i++) {
			// 보석의 정보를 담고 있는 배열에서 가방에 담을 수 있는 보석을 모두 가격 기준 최대힙에 넣는다.
			while( idx < N && bag[i] >= jewelry[idx].weight) {
				maxHeap.add(jewelry[idx].price);
				idx++;
			}
			// 가방의 무게보다 더 큰 보석의 무게를 만나면 현재 가방에 대한 최대힙이 완성
			// 최대힙의 top의 값 삭제 -> top 값 선택
			if(!maxHeap.isEmpty())
				res += maxHeap.poll();
			// 다음 가방 무게에 대하여 다음 보석 순서부터 다시 최대힙에 추가	
		}
		
		System.out.println(res);
	}
}

class Jewelry implements Comparable<Jewelry>{
	int weight;
	int price;
	
	public Jewelry(int weight, int price){
		this.weight = weight;
		this.price = price;
	}
	
	public int compareTo(Jewelry j) {
		return this.weight - j.weight;
	}
}