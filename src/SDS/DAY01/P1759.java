package SDS.DAY01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759 {
	static char[] PW;
	static int L, C;
	static char[] list;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/SDS/DAY01/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		list = new char[C];
		
		input = br.readLine();
		st = new StringTokenizer(input);
		for(int i = 0; i < C; i++)
			list[i] = st.nextToken().charAt(0);
		
		Arrays.sort(list);
		
		PW = new char[L];
		dfs(0, 0);
	}
	
	public static void dfs(int idx, int l) {
		if(idx >= L) {
			for(int i = 0; i < L; i++)
				System.out.print(PW[i]);
			System.out.println();
			return;
		}
		
		for(int i = l; i < C; i++) {
			PW[idx] = list[i];
			if(check(list[i], idx)) 
				dfs(idx+1, i+1);
		}
	}
	
	public static boolean check(char c, int idx) {
		int mo = 0;
		int ja = 0;
		for(int i = 0; i <= idx; i++) {
			switch(PW[i]) {
			case 'a':
			case 'i':
			case 'e':
			case 'o':
			case 'u':
				mo++;
				break;
			default:
				ja++;
				break;
			}
		}
		if(1 > L - ja || 2 > L - mo)
			return false;
		return true;
	}

}