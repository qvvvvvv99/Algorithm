package FastCampus.Sort;

import java.io.*;
import java.util.*;

// BJ 10989번 수 정렬하기 3
// 계수정렬(counting sort)
// : 배열의 인덱스를 특정한 데이터의 값으로 여기는 정렬
// : 데이터가 등장한 횟수를 센다

public class BJ10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] ary = new int[10001];	// 입력되는 값의 범위 0~10000
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) 
			ary[Integer.parseInt(br.readLine())]++;
		br.close();
		
		// 반복문 안에 System.out.println()을 넣어 매번 출력을 하는 것보다
		// StringBuilder를 만들어 전체 String을 만들고 한번에 출력하는 것이 훨씬 효율적!!
		// -> 시간 절약!!!
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < 10001; i++) {
			if(ary[i] != 0) {
				for(int j = ary[i]; j > 0; j--) {
					sb.append(i).append('\n');
				}
			}
		}
		System.out.println(sb);
	}

}
