package AlgoStudy.M2_W3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ2668 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] ary = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++) {
			ary[i] = sc.nextInt();
		}
		
		int res = 0, next, cnt;
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			next = i;
			cnt = 0;
			list.clear();
			while(true) {
				cnt++;
				next = ary[next];
				if(visited[next])
					break;
				visited[next] = true;
				list.add(next);
			}
			if(i == next) {
				res += cnt;
				answer.add(i);
				while(!list.isEmpty())
					answer.add(list.remove(0));
			}else {
				while(!list.isEmpty())
					visited[list.remove(0)] = false;
			}
		}
		
		System.out.println(res);
		Collections.sort(answer);
		for(int i = 0; i < answer.size(); i++)
			System.out.println(answer.get(i));
	}

}
