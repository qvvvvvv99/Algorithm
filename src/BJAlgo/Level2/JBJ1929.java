package BJAlgo.Level2;

// 백준 1929번 소수 구하기

import java.io.*;
import java.util.*;

public class JBJ1929 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		StringBuffer sb = new StringBuffer();
		boolean[] check = new boolean[N + 1];

		if (M <= 2 && N >= 2)
			sb.append(2 + "\n");

		for (int i = 3; i <= N; i += 2) {
			if (check[i] == true)
				continue;
			for (int j = i * 3; j <= N; j += 2 * i)
				check[j] = true;
		}
		if (M < 3) {
			for (int i = 3; i <= N; i += 2) {
				if (check[i] == false)
					sb.append(i + "\n");
			}
		}
		else {
			if(M % 2== 0)
				M++;
			for (int i = M; i <= N; i += 2) {
				if (check[i] == false)
					sb.append(i + "\n");
			}
		}

		System.out.print(sb);

		br.close();
	}

}
