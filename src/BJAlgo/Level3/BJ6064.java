package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ6064 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < tc; i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int minus = M - N;
			int temp = x;
			int cnt = x;
			int lcm = M*N/gcd(M,N);
			while(cnt < lcm) {
				temp += minus;
				if(temp < 0)
					temp+=N;
				if(temp > N)
					temp-=N;
				cnt+=M;
				if(temp == y) 
					break;
			}
			if (cnt > lcm)
				cnt = -1;
			sb.append(cnt+"\n");
		}
		br.close();
		System.out.print(sb);
	}
	static int gcd(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return gcd(n2, n1 % n2);
    }

}
