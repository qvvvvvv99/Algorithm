package FastCampus.Stack;

// 백준 1874번 스택 수열
// 1. 스택에 원소를 삽입할 때는, 단순히 특정 수에 도달할 때까지 삽입
// 2. 스택에서 원소를 연달아 빼낼 때 내림차순을 유지할 수 있는지 확인

import java.util.*;

public class BJ1874 {
	static int stack[] = new int[100000];
	static char opAry[] = new char[200001];
	static int top = -1;
	static int opCnt = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ary[] = new int[n];
		int newAry[] = new int[n];
		for(int i = 0; i < n; i++)
			ary[i] = sc.nextInt();
		
		int cnt = 1, aryNum = 0, naryNum = 0;
		while(cnt <= n) {
			push(cnt++);
			while ((top >= 0) && (stack[top] == ary[aryNum])) {
				newAry[naryNum++] = pop();
				aryNum++;
			}
		}
		while(top >= 0) {
			newAry[naryNum++] = pop();
		}
		
		for(int i = 0; i < n; i++) {
			if(ary[i] != newAry[i]) {
				System.out.println("NO");
				return;
			}
		}
		
		for(int i = 0; i < 2*n; i++) 
			System.out.println(opAry[i]);
	}
	
	public static void push(int num) {
		opAry[opCnt++] = '+';
		stack[++top] = num;
	}
	
	public static int pop() {
		opAry[opCnt++] = '-';
		return stack[top--];
	}

}
