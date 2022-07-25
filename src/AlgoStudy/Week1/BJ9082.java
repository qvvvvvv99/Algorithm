package AlgoStudy.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9082 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < T; i++) {
			int cnt = 0;
			int N = Integer.parseInt(br.readLine());
			String lineCnt = br.readLine();
			String inputBomb = br.readLine();
			int[] num = new int[N];
			char[] bomb = new char[N];
			
			for(int j = 0; j < N; j++) {
				num[j] = lineCnt.charAt(j) - '0';
				bomb[j] = inputBomb.charAt(j);
			}
			
			// 폭탄이 반드시 존재하는 것을 아는 경우
			if(num[0] == 2) {
				bomb[0] = '*';
				bomb[1] = '*';
			}
			if(num[N-1] == 2) {
				bomb[N-1] = '*';
				bomb[N-2] = '*';
			}
			
			for(int j = 1; j < N-1; j++) {
				if(num[j] == 3) {
					for(int k = 0; k < 3; k++) {
						bomb[j-1+k] = '*';
					}
				}
			}
			
			// 가능한 모든 지뢰 찾기
			for(int j = 0; j < N; j++) {
				if(bomb[j] == '*') {
					for(int k = 0; k < 3; k++) {
						if(j-1+k >= 0 && j-1+k < N) {
							num[j-1+k]--;
						}
					}
				}
			}
			for(int j = 0; j < N; j++) {
				if(bomb[j] == '#') {
					boolean flag = true;
					for(int k = 0; k < 3; k++) {
						if(j-1+k >= 0 && j-1+k < N) {
							if(num[j-1+k]  <= 0) {
								flag = false;
								break;
							}
						}
					}
					if(flag == true) {
						bomb[j] = '*';
						if(j-1>=0)
							num[j-1]--;
						num[j]--;
						if(j+1<N)
							num[j+1]--;
					}
				}
			}
			
			for(int j = 0; j < N; j++) {
				if(bomb[j] == '*')
					cnt++;
			}
			
			sb.append(cnt+"\n");
		}
		
		System.out.print(sb);
	}
	
}
