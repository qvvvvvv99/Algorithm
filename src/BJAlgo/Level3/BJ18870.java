package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ18870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		int[] origin = new int[N];	// 원본 배열
		int[] sorted = new int[N];	// 정렬 할 배열
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();	// rank를 매길 HashMap
 
		
		for(int i = 0; i < N; i++) {
			// 정렬할 배열과 원본 배열에 값을 넣어준다.
			sorted[i] = origin[i] = in.nextInt();
		}
		
		// 정렬 할 배열에 대해 정렬을 수행해준다.
		Arrays.sort(sorted);
		
		
		// 정렬 된 배열을 순회하면서 map에 넣어준다.
		int rank = 0;
		for(int v : sorted) {
			if(!rankingMap.containsKey(v)) {
				rankingMap.put(v, rank);
				rank++;		// map에 넣고나면 다음 순위를 가리킬 수 있도록 1을 더해준다.
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int key : origin) {
			int ranking = rankingMap.get(key);	// 원본 배열 원소(key)에 대한 value(순위)를 갖고온다.
			sb.append(ranking).append(' ');
		}
		
		System.out.println(sb);
	}

}
