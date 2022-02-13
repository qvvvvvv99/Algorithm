package BJAlgo.Level2;

import java.io.*;
import java.util.*;

public class BJ10845 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuffer sb = new StringBuffer();
		int rear = -1;
		
		for(int i = 0; i < N; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			String command = st.nextToken();
			if(command.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				rear = num;
			} else if(command.equals("pop")) {
				if(queue.isEmpty())
					sb.append("-1\n");
				else {
					sb.append(queue.poll()+"\n");
					if(queue.isEmpty())
						rear = -1;
				}
			}  else if(command.equals("size")) {
				sb.append(queue.size()+"\n");
			}  else if(command.equals("empty")) {
				if(queue.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
			} else if(command.equals("front")) {
				if(queue.isEmpty())
					sb.append("-1\n");
				else
					sb.append(queue.peek()+"\n");
			} else if(command.equals("back")) {
				if(queue.isEmpty())
					sb.append("-1\n");
				else
					sb.append(rear+"\n");
			}
		}
		System.out.println(sb);
	}

}
