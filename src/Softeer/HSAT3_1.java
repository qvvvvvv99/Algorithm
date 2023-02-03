package Softeer;

import java.util.ArrayList;
import java.util.Scanner;

public class HSAT3_1 {
	static ArrayList<Character> table = new ArrayList<>();
	static String message, key;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		message = sc.next();
		key = sc.next();
		
		init();
		
		StringBuffer newMsg = checkDouble();
		
		newMsg = encode(newMsg);
		
		System.out.println(newMsg);
	}
	
	static void init() {
		boolean[] alpha = new boolean[26];
		alpha[9] = true;
		char curr;
		for(int idx = 0; idx < key.length(); idx++) {
			curr = key.charAt(idx);
			if(alpha[curr-'A'])
				continue;
			table.add(curr);
			alpha[curr-'A'] = true;
		}
		
		if(table.size() < 25) {
			for(int idx = 0; idx < 26; idx++) {
				if(alpha[idx]) 
					continue;
				table.add((char)(idx + 'A'));
			}
		}
	}

	static StringBuffer checkDouble() {
		StringBuffer sb = new StringBuffer(message);
		
		for(int idx = 0; idx < sb.length()-1; idx += 2) {
			if(sb.charAt(idx) == sb.charAt(idx+1)) {
				if(sb.charAt(idx) == 'X')
					sb.insert(idx+1, 'Q');
				else
					sb.insert(idx+1, 'X');
			}
		}
		if(sb.length() % 2 == 1)
			sb.append('X');
		
		return sb;
	}
	
	static StringBuffer encode(StringBuffer str) {
		int n;
		
		for(int idx = 0; idx < str.length()-1; idx += 2) {
			int c1 = table.indexOf(str.charAt(idx)) % 5;
			int c2 = table.indexOf(str.charAt(idx+1)) % 5;
			int r1 = table.indexOf(str.charAt(idx)) / 5;
			int r2 = table.indexOf(str.charAt(idx+1)) / 5;
			if(r1 == r2) {
				n = table.indexOf(str.charAt(idx))+1;
				if(n % 5 == 0)
					n -= 5;
				str.insert(idx, table.get(n));
				str.deleteCharAt(idx+1);
				n = table.indexOf(str.charAt(idx+1))+1;
				if(n % 5 == 0)
					n -= 5;
				str.insert(idx+1, table.get(n));
				str.deleteCharAt(idx+2);
			}
			else if(c1 == c2) {
				n = table.indexOf(str.charAt(idx))+5;
				if(n >= 25)
					n %= 5;
				str.insert(idx, table.get(n));
				str.deleteCharAt(idx+1);
				n = table.indexOf(str.charAt(idx+1))+5;
				if(n >= 25)
					n %= 5;
				str.insert(idx+1, table.get(n));
				str.deleteCharAt(idx+2);
			}
			else {
				n = r1 * 5 + c2;
				str.insert(idx, table.get(n));
				str.deleteCharAt(idx+1);
				n = r2 * 5 + c1;
				str.insert(idx+1, table.get(n));
				str.deleteCharAt(idx+2);
			}
		}
		return str;
	}
}
