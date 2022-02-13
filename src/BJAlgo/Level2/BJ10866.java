package BJAlgo.Level2;

import java.io.*;
import java.util.*;

public class BJ10866 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		Deque<Integer> deque = new LinkedList<Integer>();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			String command = st.nextToken();
			if(command.equals("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				deque.addFirst(num);	
			} else if(command.equals("push_back")) {
				int num = Integer.parseInt(st.nextToken());
				deque.addLast(num);
			}  else if(command.equals("pop_front")) {
				if(deque.isEmpty())
					sb.append("-1\n");
				else 
					sb.append(deque.pollFirst()+"\n");
			} else if(command.equals("pop_back")) {
				if(deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.pollLast()+"\n");
			} else if(command.equals("size")) {
				sb.append(deque.size()+"\n");
			}  else if(command.equals("empty")) {
				if(deque.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if(command.equals("front")) {
				if(deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.peekFirst()+"\n");
			} else if(command.equals("back")) {
				if(deque.isEmpty())
					sb.append("-1\n");
				else
					sb.append(deque.peekLast()+"\n");
			}
		}
		System.out.println(sb);
	}

}
