package AlgoStudy.M1_W2;

import java.util.Scanner;

public class BJ16637 {
	static int N;
	static int max = 0;
	static int[] nums, opsIdx;
	static char[] ops;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		String line = sc.next();
		nums = new int[N/2+1];
		ops = new char[N/2];
		opsIdx = new int[N/2];
		boolean[] check = new boolean[N/2];
		
		for(int i = 0; i < N; i++) {
			if(i % 2 == 0) 
				nums[i/2] = line.charAt(i) - '0';
			else
				ops[i/2] = line.charAt(i);
		}
		
		dfs(0);
		
		System.out.println(max);
	}
	
	static void dfs(int idx){
		if(idx == N / 2) {
			calc();
			return;
		}
		
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < N/2; j++) {
				
			}
		}
	}
	
	static void calc() {
	}
}

//public class Main {
//	static int N;
//	static ArrayList<Integer> num;
//	static ArrayList<Character> op;
//	static int answer = Integer.MIN_VALUE;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//		N = Integer.parseInt(br.readLine());
//		char[] cArr = br.readLine().toCharArray();
//		num = new ArrayList<>();
//		op = new ArrayList<>();
//
//		for (int i = 0; i < N; i++) {
//			if ((i + 1) % 2 == 1) {
//				num.add(Character.getNumericValue(cArr[i]));
//			} else {
//				op.add(cArr[i]);
//			}
//		}
//
//		dfs(0, num.get(0));
//
//		bw.write(answer + "\n");
//
//		br.close();
//		bw.close();
//	}
//
//	public static void dfs(int idx, int sum) {
//		if (idx == op.size()) {
//			answer = Math.max(answer, sum);
//			return;
//		}
//
//		dfs(idx + 1, calculate(sum, num.get(idx + 1), op.get(idx))); // 괄호 치고 넘기기
//
//		if (idx + 2 <= op.size()) {
//			dfs(idx + 2, calculate(sum, calculate(num.get(idx + 1), num.get(idx + 2), op.get(idx + 1)), op.get(idx))); // 괄호 안 치고 넘기기
//		}
//	}
//
//	public static int calculate(int a, int b, char op) {
//		if (op == '+') {
//			return a + b;
//		} else if (op == '-') {
//			return a - b;
//		} else {
//			return a * b;
//		}
//	}
//
//}
