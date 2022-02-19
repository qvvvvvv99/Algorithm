package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ1764 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		
		HashSet<String> listen = new HashSet<>();
		input = new String();
		for(int i = 0; i < N; i++) {
			input = br.readLine();
			listen.add(input);
		}
		
		ArrayList<String> all = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			input = br.readLine();
			if(listen.contains(input)) {
				all.add(input);
			}
		}
		
		Collections.sort(all);
		
		sb.append(all.size()+"\n");
		for(int i = 0; i < all.size(); i++)
			sb.append(all.get(i)+"\n");
		System.out.print(sb);
		
		br.close();
	}
}
