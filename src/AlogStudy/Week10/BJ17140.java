package AlogStudy.Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ17140 {
	static int r, c, k;
	static int[][] ary = new int[101][101];
	static int sec = 0;
	static int rIdx = 3, cIdx = 3;
	static int cnt[] = new int[101];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= 3; j++) {
				ary[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if(check())
				break;
			if(sec > 100) {
				sec = -1;
				break;
			}
			
			if(rIdx >= cIdx) {
				rowChange();
			}else {
				colChange();
			}
			sec++;
		}
		
		System.out.println(sec);
	}
	
	static boolean check() {
		if(ary[r][c] == k)
			return true;
		else
			return false;
	}
	
	static void rowChange() {
		HashSet<Integer> set = new HashSet<>();
		LinkedList<Number> list = new LinkedList<>();
		int max = 0;
		int[] len = new int[rIdx+1];
		
		for(int i = 1; i <= rIdx; i++) {
			set.clear();
			Arrays.fill(cnt, 0);
			for(int j = 1; j <= cIdx; j++) {
				if(ary[i][j] == 0)
					continue;
				set.add(ary[i][j]);
				cnt[ary[i][j]]++;
			}
			Iterator iter = set.iterator();
			while(iter.hasNext()) {
				int n = (int)iter.next();
				list.add(new Number(n, cnt[n]));
			}
			
			Collections.sort(list);
			
			int idx = 1;
			while(!list.isEmpty()) {
				Number number = list.poll();
				ary[i][idx] = number.num;
				ary[i][idx+1] = number.cnt;
				idx+=2;
			}
			
			len[i] = idx-1;
			max = Math.max(idx-1, max);
		}
		
		for(int i = 1; i <= rIdx; i++) {
			for(int j = len[i] + 1; j <= max; j++)
				ary[i][j] = 0;
		}
		cIdx = max;
	}
	
	static void colChange() {
		HashSet<Integer> set = new HashSet<>();
		LinkedList<Number> list = new LinkedList<>();
		int max = 0;
		int[] len = new int[cIdx+1];
		
		for(int i = 1; i <= cIdx; i++) {
			set.clear();
			Arrays.fill(cnt, 0);
			for(int j = 1; j <= rIdx; j++) {
				if(ary[j][i] == 0)
					continue;
				set.add(ary[j][i]);
				cnt[ary[j][i]]++;
			}
			Iterator iter = set.iterator();
			while(iter.hasNext()) {
				int n = (int)iter.next();
				list.add(new Number(n, cnt[n]));
			}
			
			Collections.sort(list);
			
			int idx = 1;
			while(!list.isEmpty()) {
				Number number = list.poll();
				ary[idx][i] = number.num;
				ary[idx+1][i] = number.cnt;
				idx+=2;
			}
			
			len[i] = idx-1;
			max = Math.max(idx-1, max);
		}
		
		for(int i = 1; i <= cIdx; i++) {
			for(int j = len[i] + 1; j <= max; j++)
				ary[j][i] = 0;
		}
		rIdx = max;
	}
}

class Number implements Comparable<Number>{
	int num;
	int cnt;
	
	Number (int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Number num) {
		// TODO Auto-generated method stub
		if(this.cnt < num.cnt)
			return this.cnt - num.cnt;
		else if(this.cnt == num.cnt)
			return this.num - num.num;
		return 0;
	}
	
}
