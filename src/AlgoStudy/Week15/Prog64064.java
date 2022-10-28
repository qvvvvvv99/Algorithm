package AlgoStudy.Week15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Prog64064 {
	static int answer = 0;
	static ArrayList<int[]> list;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };

		solution(user_id, banned_id);
		System.out.println(answer);
	}

	static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();
		list = new ArrayList<>();
		int[] values = new int[banned_id.length];
		dfs(0, user_id, banned_id, stack, values);

		return answer;
	}

	static void dfs(int ban, String[] user_id, String[] banned_id, Stack<Integer> stack, int[] values) {
		if (ban == banned_id.length) {
			int[] clone = values.clone();
			Arrays.sort(clone);
			boolean flag = true;
			for(int i = 0; i < list.size(); i++) {
				int j;
				for(j = 0; j < clone.length; j++) {
					if(clone[j] != list.get(i)[j]) {
						break;
					}
				}
				if(j == clone.length) {
					flag = false;
					break;
				}
			}
			if(flag == true){
				list.add(clone);
				answer++;
			}
			return;
		}

		for (int i = 0; i < user_id.length; i++) {
			if (user_id[i].length() != banned_id[ban].length() || stack.contains(i))
				continue;
			boolean flag = true;
			for (int j = 0; j < banned_id[ban].length(); j++) {
				if (banned_id[ban].charAt(j) == '*')
					continue;
				if (banned_id[ban].charAt(j) != user_id[i].charAt(j)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				stack.push(i);
				values[ban] = i;
				dfs(ban + 1, user_id, banned_id, stack, values);
				values[ban] = 0;
				stack.pop();
			}
		}
	}
}
