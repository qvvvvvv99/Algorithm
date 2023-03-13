package BJAlgo.Level5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ4386 {
	static int[] parent;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[][] point = new double[n][2];
		parent = new int[n];
		for (int i = 0; i < n; i++)
			parent[i] = i;

		double x, y;
		for (int i = 0; i < n; i++) {
			x = sc.nextDouble();
			y = sc.nextDouble();
			point[i][0] = x;
			point[i][1] = y;
		}

		ArrayList<Line> map = new ArrayList<>();

		double len;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				len = Math.sqrt(Math.pow(point[i][0] - point[j][0], 2) + Math.pow(point[i][1] - point[j][1], 2));
				map.add(new Line(i, j, len));
			}
		}

		Collections.sort(map);

		int u, v;
		double res = 0.0;
		while (n > 1) {
			Line curr = map.remove(0);
			u = curr.start;
			v = curr.dist;
			u = find(u);
			v = find(v);
			if (u != v) {
				union(u, v);
				res += curr.len;
				n--;
			}
		}

		System.out.println(String.format("%.2f", res));
	}

	static int find(int v) {
		if (v == parent[v])
			return v;
		return parent[v] = find(parent[v]);
	}

	static void union(int u, int v) {
		parent[v] = u;
		return;
	}
}

class Line implements Comparable<Line> {
	int start;
	int dist;
	double len;

	Line(int start, int dist, double len) {
		this.start = start;
		this.dist = dist;
		this.len = len;
	}

	@Override
	public int compareTo(Line Line) {
		// TODO Auto-generated method stub
		double ret = this.len - Line.len;
		return (int)ret;
	}
}
