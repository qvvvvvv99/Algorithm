package AlgoStudy.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1339 {
	
	private static final int List = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 1 <= N <= 10
		int N = Integer.parseInt(br.readLine());
		int[] alphAry = new int[26];
		
		String[] input = new String[N];
		for(int i = 0; i < N; i++) {
			input[i] = br.readLine();
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < input[i].length(); j++) {
				alphAry[input[i].charAt(j)-'A'] += (int)Math.pow(10, input[i].length()-j-1);
			}
		}
		
		Arrays.sort(alphAry);
		int num = 9;
		int idx = 25;
		int res = 0;
		while(alphAry[idx] > 0) {
			res += alphAry[idx] * num;
			num--;
			idx--;
		}
		
		System.out.println(res);
	}

}