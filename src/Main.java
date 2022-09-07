import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = N;
		boolean[] flag = new boolean[26];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			Arrays.fill(flag, false);
			flag[str.charAt(0) - 'a'] = true;
			for (int j = 1; j < str.length(); j++) {
				if(str.charAt(j) == str.charAt(j-1)) 
					continue;
				if(flag[str.charAt(j)-'a'] == true) {
					cnt--;
					break;
				}
				flag[str.charAt(j) - 'a'] = true;
			}
		}

		System.out.println(cnt);
	}

}
