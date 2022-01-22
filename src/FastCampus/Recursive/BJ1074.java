package FastCampus.Recursive;

// BJ 1074번 Z
// 기준점 변경 + 배열 크기 줄이기
// 모든 칸을 다 들를 필요 없다!!

import java.util.*;

public class BJ1074 {
	static int num = 0;
	static int r, c;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		// searchZ((int) Math.pow(2, N), 0, 0);
		solve((int) Math.pow(2, N), 0, 0);
	}

	public static void solve(int n, int y, int x) {
		if (y == r && x == c) {
			System.out.println(num);
			return;
		}

		if (y <= r && r < (y + n) && x <= c && c < (x + n)) {
			int nn = n / 2;
			solve(nn, y, x);
			solve(nn, y, x + nn);
			solve(nn, y + nn, x);
			solve(nn, y + nn, x + nn);
		} else
			num += n * n;
	}

	// 시간 초과
	public static void searchZ(int n, int x, int y) {
		if (n == 2) {
			if (x == r && y == c) {
				System.out.println(num);
				return;
			}
			num++;
			if (x == r && y + 1 == c) {
				System.out.println(num);
				return;
			}
			num++;
			if (x + 1 == r && y == c) {
				System.out.println(num);
				return;
			}
			num++;
			if (x + 1 == r && y + 1 == c) {
				System.out.println(num);
				return;
			}
			num++;
			return;
		}
		searchZ(n / 2, x, y);
		searchZ(n / 2, x, y + n / 2);
		searchZ(n / 2, x + n / 2, y);
		searchZ(n / 2, x + n / 2, y + n / 2);

	}

}
