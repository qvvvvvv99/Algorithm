package FastCampus.Search;

// BJ 1543번 문서 검색
// 문자열은 알파벳 소문자와 '공백'으로 이루어져 있다.
// 따라서 공백과 엔터를 기준으로 분리하는 Scanner를 사용하기 보다는
// 엔터를 기준으로 문자열을 분리하는 BufferedReader를 사용한다.
// 시간복잡도 : O(MN) -> 2500 * 50 = 125000
// 완전탐색가능한 연산 수

import java.io.*;

public class BJ1543 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		String search = br.readLine();
		int cnt = 0, i = 0;

		while(data.length()-i >= search.length()) {
			for (int j = 0; j < search.length(); j++) {
				if (search.charAt(j) != data.charAt(i + j)) {
					i++;
					break;
				}
				if (j == search.length()-1) {
					cnt++;
					i += search.length();
				}
			}
		}
		
		System.out.println(cnt);
	}

}
