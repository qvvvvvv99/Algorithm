// 백준 1620번 나는야 포켓몬 마스터 이다솜

package BJAlgo.Level3;

import java.io.*;
import java.util.*;

public class BJ1620 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] pocketmonsNum = new String[N+1];
		Map<String, Integer> pocketmonsStr = new HashMap<String, Integer>();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 1; i <= N; i++) {
			input = br.readLine();
			pocketmonsNum[i] = input;
			pocketmonsStr.put(input, i);
		}
		
		for(int i = 1; i <= M; i++) {
			input = br.readLine();
			if(input.charAt(0) - '0' >= 0 && input.charAt(0) - '0' <= 9) {
				int n = Integer.parseInt(input);
				sb.append(pocketmonsNum[n]+"\n");
			}
			else {
				sb.append(pocketmonsStr.get(input)+"\n");
			}
		}
		
		System.out.print(sb);
		
		br.close();
	}

}
