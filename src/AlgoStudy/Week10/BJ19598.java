package AlgoStudy.Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ19598 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] time = new int[N][2];
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			time[i][0] = start;
			time[i][1] = end;
			set.add(start);
			set.add(end);
		}
		
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i = 0; i < list.size(); i++) {
			hm.put(list.get(i), i);
		}
		int[] res = new int[list.size()];
		
		for(int i = 0; i < N; i++) {
			res[hm.get(time[i][0])]++;
			res[hm.get(time[i][1])]--;
		}
		
		int max = 0;
		for(int i = 1; i < res.length; i++) {
			res[i] += res[i-1];
			max = Math.max(max, res[i]);
		}
		System.out.println(max);
	}

}
