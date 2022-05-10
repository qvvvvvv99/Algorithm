package BJAlgo.Level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BJ5430 {
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < tc; i++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line, ",[]");
			Deque<Integer> deque = new ArrayDeque<>();
			for(int j = 0; j < n; j++) 
				deque.add(Integer.parseInt(st.nextToken()));
			
			AC(deque, p);
		}
		
		System.out.print(sb);
	}

	public static void AC(Deque<Integer> deque, String p) {
		boolean flag = true;
		
		for(char ch : p.toCharArray()) {
			if(ch == 'R') {
				flag = !flag;
				continue;
			}

			if(deque.isEmpty()) {
				sb.append("error\n");
				return;
			}
			if(flag == true) 
				deque.pollFirst();
			else
				deque.pollLast();
		}
		
		sb.append("[");
		if(deque.size() > 0) {
			if(flag == true) {
				sb.append(deque.pollFirst());
				while(!deque.isEmpty())
					sb.append(',').append(deque.pollFirst());
			}
			else {
				sb.append(deque.pollLast());
				while(!deque.isEmpty())
					sb.append(',').append(deque.pollLast());
			}
		}
		sb.append("]\n");
		return;
	}
}
