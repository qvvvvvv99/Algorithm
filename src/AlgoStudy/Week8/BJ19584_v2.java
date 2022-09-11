package AlgoStudy.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ19584_v2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 좌표 개수
		int M = Integer.parseInt(st.nextToken()); // 도로 수
		int[] y = new int[N + 1];
		HashSet<Integer> hs = new HashSet<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			y[i] = Integer.parseInt(st.nextToken());
			hs.add(y[i]);
		}

		ArrayList<Integer> list = new ArrayList<>(hs);
		Collections.sort(list);
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i = 0; i < list.size(); i++)
			hm.put(list.get(i), i+1);
		
		long[] pri = new long[list.size()+2];
		int up, under;
		long price;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			under = y[Integer.parseInt(st.nextToken())];
			up = y[Integer.parseInt(st.nextToken())];
			price = Integer.parseInt(st.nextToken());
			if (up < under) {
				int temp = up;
				up = under;
				under = temp;
			}
			under = hm.get(under);
			up = hm.get(up);
			pri[under] += price;
			pri[up+1] -= price;
		}
		
		long max = pri[1];
		for(int i = 2; i < pri.length-1; i++) {
			pri[i] += pri[i-1];
			max = Math.max(max, pri[i]);
		}
		
		System.out.println(max);
	}

}
