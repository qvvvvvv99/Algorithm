package AlogStudy.Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] sensor = new int[N];
		String input = br.readLine();
		StringTokenizer token = new StringTokenizer(input);
		for(int i = 0; i < N; i++)
			sensor[i] = Integer.parseInt(token.nextToken());
		
		Arrays.sort(sensor);
		
		Integer[] len = new Integer[N-1];
		for(int i = 0; i < len.length; i++)
			len[i] = sensor[i+1] - sensor[i];
		
		Arrays.sort(len, Collections.reverseOrder());
		
		int sum = 0;
		if(N >= K) {
			for(int i = 0; i < K - 1; i++) 
				len[i] = 0;
			
			for(int i = 0; i < len.length; i++)
				sum += len[i];
		}
		
		System.out.println(sum);
	}


}
