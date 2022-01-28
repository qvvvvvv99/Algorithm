package FastCampus.Heap;

// BJ 1927¹ø ÃÖ¼Ò Èü

import java.util.*;

public class BJ1927 {
	static int size = 0;
	static int ary[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ary = new int[N + 1];

		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println(remove());
			} else {
				add(input);
			}
		}
	}

	public static void add(int num) {
		int n;
		ary[++size] = num;
		n = size;

		while (n > 1) {
			if (ary[n] < ary[n / 2])
				swap(n, n / 2);
			else
				break;
			n /= 2;
		}
	}

	public static int remove() {
		if (size == 0)
			return 0;
		int min = ary[1];
		int n = 1;
		ary[1] = ary[size];
		size--;

		while (n < size) {
			int child;
			if (n*2+1 <= size)
				child = (ary[n * 2] < ary[n * 2 + 1]) ? n * 2 : n * 2 + 1;
			else if (n*2 <= size)
				child = n*2;
			else
				break;
			if (ary[n] > ary[child])
				swap(n, child);
			else
				break;
			n = child;
		}

		return min;
	}

	public static void swap(int a, int b) {
		int temp;
		temp = ary[a];
		ary[a] = ary[b];
		ary[b] = temp;
	}
}
