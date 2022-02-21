package FastCampus.AlgoPrac;

import java.io.*;
import java.util.*;

public class BJ9037 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < tc; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] ary = new int[N];
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			for(int j = 0; j < N; j++) 
				ary[j] = Integer.parseInt(st.nextToken());
			even(ary);
				
			int[] ban = new int[N+1];
			int rotate = 0;
			while(true) {
				if(check(ary))
					break;
				for(int j = 0; j < N; j++) {
					ban[j+1] = ary[j]/2;
					ary[j] /= 2;
				}
				ary[0] += ban[N];
				for(int j = 1; j < N; j++)
					ary[j] += ban[j];
				even(ary);
				rotate++;
			}
			
			sb.append(rotate+"\n");
		}
		br.close();
		System.out.print(sb);
	}
	
	public static boolean check(int[] ary) {
		int a = ary[0];
		for(int i = 1; i < ary.length; i++) {
			if(a != ary[i])
				return false;
		}
		return true;
	}
	
	public static void even(int[] ary) {
		for(int i = 0; i < ary.length; i++) {
			if(ary[i] % 2 == 1)
				ary[i]++;
		}
	}
}
