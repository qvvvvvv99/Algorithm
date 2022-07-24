package AlgoStudy.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2503 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N : 질문 갯수 (1 <= N <= 100)
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] strike = new int[N];
		int[] ball = new int[N];

		// 질문 내용 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num[i] = Integer.parseInt(st.nextToken());
			strike[i] = Integer.parseInt(st.nextToken());
			ball[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		// 9 * 9 * 9 * 100 = 72900 => 완전 탐색
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				// 서로 다른 세자리 숫자
				if(i == j)
					continue;
				for (int k = 1; k <= 9; k++) {
					// 서로 다른 세자리 숫자
					if(k == i || k == j)
						continue;
					
					boolean isPossible = true;
					// 질문 수 만큼 반복
					for(int q = 0; q < N; q++) {
						int s = 0, b = 0;
						int n = num[q];
						
						// 각 자리 추출
						int trd = n % 10;
						n /= 10;
						int scd = n % 10;
						n /= 10;
						int fir = n; 
						
						// 스트라이크, 볼 판단
						if(fir == i) s++;
						if(scd == j) s++;
						if(trd == k) s++;
						if(fir == j || fir == k) b++;
						if(scd == i || scd == k) b++;
						if(trd == i || trd == j) b++;
						
						// 세자리 수가 물음으로 주어진 수에 대해 strike, ball이 다르면 멈춤
						if(strike[q] != s || ball[q] != b) {
							isPossible = false;
							break;
						}
					}
					
					if(isPossible)
						ans++;
				}
			}
		}
		
		System.out.println(ans);
	}

}
