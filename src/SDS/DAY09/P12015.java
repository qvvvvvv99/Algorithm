package SDS.DAY09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12015 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N+1];
		int len = 0;
		int min, max, mid = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i;
		for(i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			min = 0;
			max = len;
			while(min <= max) {
				mid = (min + max)/2;
				
				if(A[mid] < num) {
					min = mid + 1;
				}else {
					max = mid-1;
				}
			}
			A[min] = num;
			if(min-1 == len)
				len++;
			
		}
		
		System.out.println(len);
		
	}

}
