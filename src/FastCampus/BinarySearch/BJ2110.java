package FastCampus.BinarySearch;

import java.io.*;
import java.util.*;

public class BJ2110 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		int[] ary = new int[N];
		int min, max, mid;
		int res = 0, value, cnt = 1;
		
		for(int i = 0; i < N; i++)
			ary[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(ary);
		
		min = 1;
		max = ary[N-1] - ary[0] + 1;
		
		while(min <= max) {
			mid = (min + max) / 2;
			value = ary[0];
			cnt = 1;
			for(int i = 1; i < N; i++) {
				if(ary[i] >= value + mid) {
					value = ary[i];
					cnt++;
				}
			}
			if(cnt >= C) {
				min = mid + 1;
				res = mid;
			}
			else
				max = mid - 1;
		}
		
		System.out.println(res);
	}

}
