// 백준 11723번 집합

package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int[] S = new int[21];
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < M; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			String exp = st.nextToken();
			if(exp.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				S[num] = 1;
			}
			else if(exp.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				S[num] = 0;
			}
			else if(exp.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				sb.append(S[num] + "\n");				
			}
			else if(exp.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if(S[num] == 0)
					S[num] = 1;
				else
					S[num] = 0;
			}
			else if(exp.equals("all")) {
				Arrays.fill(S, 1);
			}
			else if(exp.equals("empty")) {
				Arrays.fill(S, 0);
			}
		}
		
		System.out.print(sb);
		br.close();
	}

}
