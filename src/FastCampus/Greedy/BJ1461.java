package FastCampus.Greedy;

import java.io.*;
import java.util.*;

public class BJ1461 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		input = br.readLine();
		st = new StringTokenizer(input);
		int[] location = new int[N+1];
		for(int i = 0; i < N; i++)
			location[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(location);
		
		int idx = 0;
		for(int i = 0; i <= N; i++)
			if(location[i] == 0)
				idx = i;
		
		ArrayList<Integer> len = new ArrayList<Integer>();
		for(int i = 0; i < idx; i += M) 
			len.add(Math.abs(location[i]));
		for(int i = N; i > idx; i -= M)
			len.add(Math.abs(location[i]));
		
		Collections.sort(len);
		
		int sum = len.get(len.size()-1);
		for(int i = 0; i < len.size()-1; i++) 
			sum += len.get(i)*2;
		
		System.out.println(sum);
	}

}
