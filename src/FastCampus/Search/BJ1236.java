package FastCampus.Search;

import java.io.*;
import java.util.*;

public class BJ1236 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		List<Integer> row = new ArrayList<>();
		List<Integer> col = new ArrayList<>();
		int res = 0;
		
		String[] box = new String[N];
		for(int i = 0; i < N; i++) {
			box[i] = br.readLine();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i].charAt(j) == 'X')
					break;
				if(j == M-1)
					row.add(i);
			}
		}
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(box[j].charAt(i) == 'X')
					break;
				if(j == N-1)
					col.add(i);
			}
		}
		
		res = Math.max(row.size(), col.size());
		System.out.println(res);
	}

}
