package SDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ex1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int[] dAry = new int[D];
			double result = 0;
			PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++)
					queue.add(Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < D; i++) {
				dAry[i] = Integer.parseInt(st.nextToken());
				double sum = 0;
				for (int j = 0; j < dAry[i]; j++) {
					sum+=queue.poll()+i;
					queue.add(0-i);
				}
				result += (i+1) * sum;
			}
			int num = t+1;
			sb.append("#"+ num + " " + Math.round(result)+"\n");
		}
		System.out.print(sb);
	}

}
