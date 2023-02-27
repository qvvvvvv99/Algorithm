package BJAlgo.Level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2467 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] value = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = 0, n2 = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) 
			value[i] = Integer.parseInt(st.nextToken());
			
		for(int idx = 0; idx < N-1; idx++) {
			int left = idx+1;
			int right = N-1;
			int mid;
			while(left <= right) {
				mid = (left + right) / 2;
				if(Math.abs(value[idx]) > value[mid]) {
					left = mid + 1;
				}
				else if(Math.abs(value[idx]) < value[mid]) {
					right = mid - 1;
				}
				else {
					min = 0;
					n1 = value[idx];
					n2 = value[mid];
					break;
				}
				if(Math.abs(value[idx] + value[mid]) < min) {
					n1 = value[idx];
					n2 = value[mid];
					min = Math.abs(value[idx] + value[mid]);
				}
			}
			if(min == 0)
				break;
		}
		
		System.out.println(n1 + " " + n2);
	}
}
