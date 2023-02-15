package AlgoStudy.M2_W3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1253 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] ary = new int[N];
		for(int i = 0; i < N; i++)
			ary[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(ary);
		
		int cnt = 0;
		int l, r;
		boolean flag = false;
		for(int i = 0; i < N; i++) {
			if(i > 0 && ary[i] == ary[i-1]) {
				if(flag)
					cnt++;
				continue;
			}
			flag = false;
			l = 0;
			r = N-1;
			while(l < r) {
				if(l == i) {
					l++;
					continue;
				}
				if(r == i) {
					r--;
					continue;
				}
				if(ary[l] + ary[r] == ary[i]) {
					cnt++;
					flag = true;
					break;
				}
				else if(ary[l] + ary[r] < ary[i])
					l++;
				else
					r--;
			}
		}
		
		System.out.println(cnt);
	}

}
