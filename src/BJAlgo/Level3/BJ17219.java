package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ17219 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		HashMap<String, String> sites = new HashMap<String, String>();
		
		for(int i = 0; i < N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			String add = st.nextToken();
			String pw = st.nextToken();
			sites.put(add, pw);
		}
		
		for(int i = 0; i < M; i++) {
			input = br.readLine();
			sb.append(sites.get(input)+"\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}

}
