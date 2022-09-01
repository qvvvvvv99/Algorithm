package AlgoStudy.Week7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BJ1713 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		LinkedList<Student> stu = new LinkedList<>();
		// PriorityQueue<Student> stu = new PriorityQueue<>();
		int cnt = 0;
		boolean[] load = new boolean[101];
		int[] res = new int[N];
		int idx = 0;

		for (int i = 0; i < R; i++) {
			int rec = sc.nextInt();
			idx++;
			if (load[rec] == true) {
				Iterator<Student> iter = stu.iterator();
				while (iter.hasNext()) {
					Student curr = iter.next();
					if (curr.num == rec) {
						curr.cnt++;
						// stu.add(101, 0);
						// stu.poll();
						break;
					}
				}
				continue;
			}
			if (cnt < N) {
				stu.add(new Student(rec, idx));
				cnt++;
				load[rec] = true;
			} else {
				Collections.sort(stu);
				Student out = stu.poll();
				load[out.num] = false;
				stu.add(new Student(rec, idx));
				load[rec] = true;
			}
		}

		Arrays.fill(res, 101);
		for (int i = 0; i < cnt; i++)
			res[i] = stu.poll().num;

		Arrays.sort(res);

		for (int i = 0; i < cnt; i++)
			System.out.print(res[i] + " ");
	}
}

class Student implements Comparable<Student> {
	int num;
	int cnt;
	int idx;

	Student(int num, int idx) {
		this.num = num;
		this.cnt = 1;
		this.idx = idx;
	}

	@Override
	public int compareTo(Student stu) {
		// TODO Auto-generated method stub
		if (this.cnt == stu.cnt)
			return this.idx - stu.idx;
		return this.cnt - stu.cnt;
	}

}