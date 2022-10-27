package AlgoStudy.Week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BJ3425 {
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command;
		StringBuffer sb = new StringBuffer();

		while (true) {
			command = br.readLine();
			if (command.equals("QUIT"))
				break;
			ArrayList<String> commands = new ArrayList<>();
			commands.add(command);
			while (true) {
				if(command.equals("END"))
					break;
				command = br.readLine();
				if (command.equals("END"))
					break;
				commands.add(command);
			}
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				int V = Integer.parseInt(br.readLine());
				int res = check(commands, V);
				if (res == INF)
					sb.append("ERROR\n");
				else
					sb.append(res + "\n");
			}
			sb.append("\n");
			command = br.readLine();
		}

		System.out.print(sb);
	}

	static int check(ArrayList<String> commands, int V) {
		Stack<Integer> stack = new Stack<>();
		stack.push(V);
		String command;
		int top, second;
		long val;
		int flag = 1;

		for (int i = 0; i < commands.size(); i++) {
			command = commands.get(i).substring(0, 3);
			if (command.equals("NUM"))
				stack.push(Integer.parseInt(commands.get(i).substring(4)));
			else if (command.equals("POP")) {
				if (stack.isEmpty())
					return INF;
				stack.pop();
			} else if (command.equals("INV")) {
				if (stack.isEmpty())
					return INF;
				top = stack.pop();
				top *= -1;
				stack.push(top);
			} else if (command.equals("DUP")) {
				if (stack.isEmpty())
					return INF;
				top = stack.peek();
				stack.push(top);
			} else if (command.equals("END"))
				break;
			else {
				if (stack.size() < 2)
					return INF;
				top = stack.pop();
				second = stack.pop();
				if (command.equals("SWP")) {
					stack.push(top);
					stack.push(second);
				} else if (command.equals("ADD")) {
					val = (long) top + second;
					if (Math.abs(val) > 1000000000)
						return INF;
					stack.push((int) val);
				} else if (command.equals("SUB")) {
					val = (long) second - top;
					if (Math.abs(val) > 1000000000)
						return INF;
					stack.push((int) val);
				} else if (command.equals("MUL")) {
					val = (long) top * second;
					if (Math.abs(val) > 1000000000)
						return INF;
					stack.push((int) val);
				} else if (command.equals("DIV")) {
					if (top == 0)
						return INF;
					val = (long) top * second;
					if (val < 0)
						flag = -1;
					val = (long) Math.abs(second) / Math.abs(top);
					val *= flag;
					stack.push((int) val);
					flag = 1;
				} else if (command.equals("MOD")) {
					if (top == 0)
						return INF;
					if (second < 0)
						flag = -1;
					val = (long) Math.abs(second) % Math.abs(top);
					val *= flag;
					stack.push((int) val);
					flag = 1;
				}
			}
		}
		if (stack.size() != 1)
			return INF;

		return stack.pop();
	}
}
