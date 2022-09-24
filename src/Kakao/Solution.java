package Kakao;

import java.io.*;
import java.util.*;

public class Solution {
	static int[] percent = { 40, 30, 20, 10 };
	static int maxNum = 0;
	static double price = 0;
	
	static int[] parent = new int[250];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String today = "2022.05.19";
		String[] terms = { "A 6", "B 12", "C 3" };
		String[] privacies = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };
		// solution1("2022.05.19", terms, privacies);

		// solution2();

		int[][] users = { { 40, 2900 }, { 23, 10000 }, { 11, 5200 }, { 5, 5900 }, { 40, 3100 }, { 27, 9200 },
				{ 32, 6900 } };
		int[] emoticons = { 1300, 1500, 1600, 4900 };
		// solution3(users, emoticons);
		// System.out.println(maxNum + " " + (int)price);
		
		long l = Long.MAX_VALUE;
		long[] numbers = {1023};
		//solution4(numbers);
		
		String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
		solution5(commands);
	}

	public static int[] solution1(String today, String[] terms, String[] privacies) {
		// 구현해서 얘만 복사하기
		String[] str = today.split("[.]");
		int year = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int day = Integer.parseInt(str[2]);

		// System.out.println(year+ " "+month + " " + day);
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < terms.length; i++) {
			str = terms[i].split(" ");
			hm.put(str[0].charAt(0), Integer.parseInt(str[1]));
		}

		int yy, mm, dd;
		int period;
		char ch;
		ArrayList<Integer> res = new ArrayList<>();
		boolean flag;
		for (int i = 0; i < privacies.length; i++) {
			str = privacies[i].split("[.]| ");
			yy = Integer.parseInt(str[0]);
			mm = Integer.parseInt(str[1]);
			dd = Integer.parseInt(str[2]);
			ch = str[3].charAt(0);

			period = hm.get(ch);
			dd--;
			if (dd == 0) {
				dd = 28;
				mm--;
			}
			mm += period;
			yy += (mm - 1) / 12;
			mm %= 12;
			if (mm == 0)
				mm = 12;

			flag = true;
			// System.out.println(yy + "." + mm + "." + dd);
			if (yy < year)
				flag = false;
			if (yy == year && mm < month)
				flag = false;
			if (yy == year && mm == month && dd < day)
				flag = false;

			if (flag == false)
				res.add(i + 1);
		}

		int[] answer = new int[res.size()];
		for (int i = 0; i < res.size(); i++)
			answer[i] = res.get(i);

		return answer;
	}

	public static void solution2() {

	}

	public static int[] solution3(int[][] users, int[] emoticons) {
		int[] discount = new int[emoticons.length];

		for (int i = 0; i < 4; i++) {
			dfs(0, i, discount, users, emoticons);
		}

		int[] answer = new int[2];
		answer[0] = maxNum;
		answer[1] = (int) price;

		return answer;
	}

	public static void dfs(int idx, int n, int[] discount, int[][] users, int[] emoticons) {
		discount[idx] = percent[n];
		if (idx == discount.length - 1) {
			double total = 0;
			int cnt = 0;
			for (int i = 0; i < users.length; i++) {
				double sum = 0;
				for (int j = 0; j < discount.length; j++) {
					if (users[i][0] <= discount[j]) {
						sum += (double) emoticons[j] * (1 - (double) discount[j] / 100);
					}
				}
				if (sum >= users[i][1]) {
					cnt++;
					sum = 0;
				}
				total += sum;
			}

			if (cnt > maxNum) {
				maxNum = cnt;
				price = total;
			} else if (cnt == maxNum) {
				price = Math.max(price, total);
			}
		} else {
			for (int i = 0; i < 4; i++) {
				dfs(idx + 1, i, discount, users, emoticons);
			}
		}
	}

	public static int[] solution4(long[] numbers) {
		int[] answer = new int[numbers.length];
		String num;
		long n;
		boolean flag;
		int level;

		for (int i = 0; i < numbers.length; i++) {
			n = numbers[i];
			num = "";
			while (n > 0) {
				num = (n % 2) + num;
				n /= 2;
			}

			level = Log2(num.length());
			int upper = (int) (Math.pow(2, level+1));
			while(num.length() < upper-1)
				num = "0" + num;

			flag = true;
			//System.out.println(level);
			flag = bfs(level - 1, num, num.length() / 2);
			if (flag)
				answer[i] = 1;
			//System.out.println(answer[i]);
		}

		return answer;
	}

	static int Log2(long x) {
		return (int) (Math.log10(x) / Math.log10(2));
	}

	public static boolean bfs(int level, String num, int idx) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(idx, level));

		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			if (num.charAt(curr.idx) == '0') {
				if (num.charAt((int) (curr.idx - Math.pow(2, curr.level))) == '1'
						|| num.charAt((int) (curr.idx + Math.pow(2, curr.level))) == '1')
					return false;
			}
			if (curr.level >= 1) {
				queue.add(new Node((int) (curr.idx - Math.pow(2, curr.level)), curr.level-1));
				queue.add(new Node((int) (curr.idx + Math.pow(2, curr.level)), curr.level-1));
			}
		}

		return true;
	}

	public static String[] solution5(String[] commands) {
		String[] map = new String[250];
		for(int i = 0; i < 250; i++)
			parent[i] = i;
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 0; i < commands.length; i++) {
			String[] comm = commands[i].split(" ");
			if(comm[0].equals("UPDATE")) {
				if(comm.length == 4) {
					int r = Integer.parseInt(comm[1])-1;
					int c = Integer.parseInt(comm[2])-1;
					map[find(r*50 + c)] = comm[3];
				}else {
					for(int idx = 0; idx < 250; idx++) {
						if(comm[2].equals(map[idx]))
							map[idx] = comm[3];
					}
				}
			}
			else if(comm[0].equals("MERGE")) {
				int r1, r2, c1, c2;
				r1 = Integer.parseInt(comm[1])-1;
				c1 = Integer.parseInt(comm[2])-1;
				r2 = Integer.parseInt(comm[3])-1;
				c2 = Integer.parseInt(comm[4])-1;
				
				union(r1*50+c1, r2*50+c2);
			}
			else if(comm[0].equals("UNMERGE")) {
				int r = Integer.parseInt(comm[1])-1;
				int c = Integer.parseInt(comm[2])-1;
				r = find(r);
				c = find(c);
				for(int j = 0; j < 250; j++) {
				}
			}
			else {
				int r = Integer.parseInt(comm[1])-1;
				int c = Integer.parseInt(comm[2])-1;
				if(map[find(r*50 + c)].equals(""))
					list.add("EMPTY");
				else
					list.add(map[find(r*50 + c)]);
			}
		}
		
		String[] answer = new String[list.size()];
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
			//System.out.println(answer[i]);
		}
        return answer;
	}
	
	static int find(int n) {
		if(n == parent[n])
			return n;
		return parent[n] = find(parent[n]);
	}
	
	static void union(int v, int u) {
		parent[Math.max(v, u)] = Math.min(v, u);
	}
}

class Node{
	int idx;
	int level;
	
	Node(int idx, int level){
		this.idx = idx;
		this.level = level;
	}
}
