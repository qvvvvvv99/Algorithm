package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P1102 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] sum = new int[N];
		StringBuffer sb =  new StringBuffer();
		StringTokenizer st;
		int[] grade = new int[N];
		int[] cnt = new int[1001];
		int rank, temp;
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(cnt, 0);
			for(int j = 0; j < N; j++) {
				grade[j] = Integer.parseInt(st.nextToken());
				sum[j] += grade[j];
				cnt[grade[j]]++;
			}
			rank = 1;
			for(int j = 1000; j >= 0; j--) {
				temp = cnt[j];
				cnt[j] = rank;
				rank += temp;
			}
			
			for(int j = 0; j < N; j++)
				sb.append(cnt[grade[j]]).append(" ");
			
			sb.append("\n");
		}
		
		rank = 1;
		cnt = new int[3001];
		for(int i = 0; i < N; i++)
			cnt[sum[i]]++;
		for(int i = 3000; i >= 0; i--) {
			temp = cnt[i];
			cnt[i] = rank;
			rank += temp;
		}
		for(int i = 0; i < N; i++)
			sb.append(cnt[sum[i]]).append(" ");
		
		System.out.println(sb);
	}

}
