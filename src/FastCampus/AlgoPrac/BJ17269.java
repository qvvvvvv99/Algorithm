package FastCampus.AlgoPrac;

import java.io.*;
import java.util.*;

public class BJ17269 {
	static int n = 0;
	static int[] ary;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		input = br.readLine();
		st = new StringTokenizer(input);
		String name1 = st.nextToken();
		String name2 = st.nextToken();
		
		ary = new int[N+M];
		
		int slen = Math.min(N, M);
		for(int i = 0; i < slen; i++) {
			makeArr(name1.charAt(i));
			makeArr(name2.charAt(i));
		}
		
		if(N > M) {
			for(int i = M; i < N; i++)
				makeArr(name1.charAt(i));
		}
		else if(N < M) {
			for(int i = N; i < M; i++)
				makeArr(name2.charAt(i));
		}
		
		
		for(int i = M+N-1; i >=2; i--) {
			for(int j = 0; j < i; j++)
				ary[j] = (ary[j] + ary[j+1])%10;
		}
		
		int res = ary[0]*10 + ary[1];
		
		System.out.println(res+"%");
	}
	
	public static void makeArr(char c) {
		switch(c) {
		case 'C':
		case 'G':
		case 'I':
		case 'J':
		case 'L':
		case 'O':
		case 'S':
		case 'U':
		case 'V':
		case 'W':
		case 'Z':
			ary[n++]=1;
			break;
		case 'B':
		case 'D':
		case 'N':
		case 'P':
		case 'Q':
		case 'R':
		case 'T':
		case 'X':
		case 'Y':
			ary[n++]=2;
			break;
		case 'A':
		case 'F':
		case 'H':
		case 'K':
		case 'M':
			ary[n++]=3;
			break;
		case 'E':
			ary[n++]=4;
			break;
		}
	}

}
