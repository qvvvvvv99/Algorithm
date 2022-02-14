package BJAlgo.Level2;

// 백준 1654번 랜선자르기
// 이분탐색(Binary Search)

import java.io.*;
import java.util.*;

public class BJ1654 {
	static int[] Lan;
	static int K, N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Lan = new int[K];
		long sum = 0;
		
		for(int i = 0; i < K; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			Lan[i] = Integer.parseInt(st.nextToken());
			sum += Lan[i];
		}
		System.out.println(binarySearch(1, sum / N));
	}

	public static long binarySearch(long start, long end) {
		long mid = (start + end) / 2;
		
		while(start <= end) {
			int cnt = 0;
			for(int i = 0; i < K; i++) 
				cnt += (Lan[i] / mid);
			
			if(cnt == N)
				return binarySearch(mid+1, end);
			else if(cnt > N) 
				start = mid+1;
			else
				end = mid - 1;
			mid = (start + end) / 2;
		}
		return mid;
	}

}
