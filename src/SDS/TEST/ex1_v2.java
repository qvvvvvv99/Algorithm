package SDS;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ex1_v2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
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
			int size = N*M;
			Integer[] list = new Integer[size];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++)
					list[i*M+j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(list, Comparator.reverseOrder());
			
			int idx = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < D; i++) {
				dAry[i] = Integer.parseInt(st.nextToken());
				double sum = 0;
				for (int j = 0; j < dAry[i]; j++) {
					sum+=list[idx]+i;
					list[idx] = 0-i;
					idx++;
					idx %= size;
				}
				result += (i+1) * sum;
			}
			int num = t+1;
			sb.append("#"+ num + " " + Math.round(result)+"\n");
		}
		System.out.print(sb);

	}

}
