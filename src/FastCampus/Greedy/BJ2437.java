package FastCampus.Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2437 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ary = new int[N];
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line);
		
		for(int i = 0; i< N; i++)
			ary[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(ary);
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			if(ary[i] <= ans+1)
				ans += ary[i];
			else
				break;
		}
		
		System.out.println(ans+1);
	}

}
