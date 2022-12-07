package AlgoStudy.Week21;

import java.util.Scanner;

public class BJ9252 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		int N = str1.length()+1;
		int M = str2.length()+1;
		int[][] res = new int[N][M];
		
		int i, j;
		for(i = 0; i < N; i++) {
			for(j = 0; j < M; j++) {
				if(i == 0 || j == 0)
					continue;
				else if(str1.charAt(i-1) != str2.charAt(j-1))
					res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
				else
					res[i][j] = res[i-1][j-1]+1;
			}
		}
		
		int len = res[N-1][M-1];
		String result = "";
		i = N-1;
		j = M-1;
		System.out.println(len);
		while(i > 0 && j > 0) {
			if(res[i-1][j] == len) 
				i--;
			else if(res[i][j-1] == len) 
				j--;
			else {
				i--;
				j--;
				result = str1.charAt(i) + result;
				len--;
			}
		}
		System.out.println(result);
	}

}
