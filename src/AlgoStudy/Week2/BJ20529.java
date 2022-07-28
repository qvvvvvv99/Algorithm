package AlgoStudy.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20529 {
	enum MBTI {ISTJ, ISFJ, INFJ, INTJ, ISTP, ISFP, INFP, INTP, ESTP, ESFP, ENFP, ENTP, ESTJ, ESFJ, ENFJ, ENTJ};
	static int[] num;
	static String[] strMBTI = {"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP", "ESTP", "ESFP", "ENFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int min;
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 16 가지 유형에 각각의 인덱스 번호를 메기고
			num = new int[16];
			for(int j = 0; j < N; j++) {
				MBTI mbti = MBTI.valueOf(st.nextToken()); 
				// 입력을 받을 때 유형별 갯수를 파악
				num[mbti.ordinal()]++;
			}
			min = 99999999;
			// 16 가지의 그래프를 16 * 16 * 16으로 돌면서 확인
			for(int a = 0; a < 16; a++) {
				// 배열 복사(16가지 유형 모두 확인 위해)
				if(num[a] == 0)
					continue;
				int[] sample = num.clone();
				sample[a]--;
				// 유형별 1 이상인 유형을 시작으로 해당 유형 -1
				for(int b = 0; b < 16; b++) {
					if(sample[b] == 0) 
						continue;
					// 다음 유형에서 1이상 남은 유형 또 선택(유형 -1)
					sample[b]--;
					for(int c = 0; c < 16; c++) {
						if(sample[c] == 0)
							continue;
						// 3번 반복 후 값 찾고 최솟값 확인
						sample[c]--;
						min = Math.min(min, check(a, b, c));
						sample[c]++;
					}
				}
			}
			sb.append(min+"\n");
		}
		System.out.print(sb);
	}
	
	static int check(int a, int b, int c) {
		int sum = 0;
		
		for(int i = 0; i < 4; i++) {
			if(strMBTI[a].charAt(i) != strMBTI[b].charAt(i))
				sum++;
			if(strMBTI[b].charAt(i) != strMBTI[c].charAt(i))
				sum++;
			if(strMBTI[a].charAt(i) != strMBTI[c].charAt(i))
				sum++;
		}
		
		return sum;
	}

}
