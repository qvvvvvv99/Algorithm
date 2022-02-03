package FastCampus.DP;

import java.io.*;
import java.util.Arrays;

public class BJ11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ary = new int[N];
		Arrays.fill(ary, 1);
		String[] input = br.readLine().split(" ");
		int len = 1;
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(Integer.parseInt(input[i]) > Integer.parseInt(input[j])) {
					ary[i] = Math.max(ary[i], ary[j]+1);
					if(len < ary[i])
						len = ary[i];
				}
			}
		}
		
		System.out.println(len);
	}

}
