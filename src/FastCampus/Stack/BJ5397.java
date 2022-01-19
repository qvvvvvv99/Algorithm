package FastCampus.Stack;

// BJ 5397번 키로거
// 문자열 크기 1 <= L <= 1,000,000 -> 시간 초과 문제 생각하기!!!
// 두 개의 스택을 두고 커서로 구분한다

import java.util.*;

public class BJ5397 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		mySol();
		
		// Stack을 사용한 올바른 풀이
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i = 0; i < tc; i++) {
			Stack<Character> leftStack = new Stack<>();
			Stack<Character> rightStack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			String str = sc.next();
			
			for(int j = 0; j < str.length(); j++) {
				switch(str.charAt(j)) {
				case '<':
					if(!leftStack.isEmpty())
						rightStack.push(leftStack.pop());
					break;
				case '>':
					if(!rightStack.isEmpty())
						leftStack.push(rightStack.pop());
					break;
				case '-':
					if(!leftStack.isEmpty())
						leftStack.pop();
					break;
				default:
					leftStack.push(str.charAt(j));
				}
			}
			
			while(!rightStack.isEmpty())
				leftStack.push(rightStack.pop());
			
			for(int j = 0; j < leftStack.size(); j++)
				sb.append(leftStack.elementAt(j));
			System.out.println(sb);
		}
	}
	
	// 문자열 크기 제한으로 인한 시간 초과
	public static void mySol() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i = 0; i < tc; i++) {
			int cursor = 0;
			String str = sc.next();
			List<Character> password = new ArrayList<>();
			
			for(int j = 0; j < str.length(); j++) {
				switch(str.charAt(j)) {
				case '<':
					if(cursor > 0)
						cursor--;
					break;
				case '>':
					if(cursor < password.size())
						cursor++;
					break;
				case '-':
					if(cursor > 0) {
						password.remove(cursor-1);
						cursor--;
					}
					break;
				default:
					password.add(cursor, str.charAt(j));
					cursor++;
				}
			}

			for(int j = 0; j < password.size(); j++)
				System.out.print(password.get(j));
			System.out.println();
		}
	}
}
