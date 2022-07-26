package AlgoStudy.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1107 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];
		
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++)
				broken[Integer.parseInt(st.nextToken())] = true;
		}
		
		// 시간복잡도 : 1,000,000 * log 1,000,000 = 6,000,000 -> 완전 탐색 가능
		
		int min = Math.abs(N - 100);
		// 채널은 무한대 만큼 존재하기에 N의 범위인 500,000까지가 아닌 999,999까지 탐색한다.
		for(int i = 0; i <= 999999; i++) {
			int temp = i;
			int cnt = 0;
			boolean flag = true;
			
			while(true) {
				// 각 자리의 번호가 고장나 누르지 못한다면 다음 번호로 이동
				if(broken[temp%10]) {
					flag = false;
					break;
				}
				temp /= 10;
				cnt++;
				if(temp == 0)
					break;
			}
			// 고장난 번호를 누르는 경우 없는 경우
			if(flag) {
				// cnt : 각 자리수를 누른 횟수
				// Math.abs(N - i) +, - 버튼을 눌러 이동한 횟수
				int num = cnt + Math.abs(N - i);
				min = Math.min(num, min);
			}
		}
		
		System.out.println(min);
	}

}
