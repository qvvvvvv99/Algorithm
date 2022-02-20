package BJAlgo.Level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			System.out.println(0);
			System.exit(0);
		} else if(N <= 3) {
			System.out.println(1);
			System.exit(0);
		}
		
		int[] ary = new int[N+1];
		ary[1] = 0; ary[2] = 1; ary[3] = 1;
		
		for(int i = 4; i <= N; i++) {
			int n = Integer.MAX_VALUE;
			if(i % 2 == 0)
				n = ary[2] + ary[i/2];
			if(i % 3 == 0)
				n = (n > ary[3] + ary[i/3] ? 1 + ary[i/3] : n);
			n = (n > ary[i-1] + ary[1] ? ary[i-1] + 1 : n);
			ary[i] = n;
		}
		br.close();
		System.out.println(ary[N]);
	}

}
