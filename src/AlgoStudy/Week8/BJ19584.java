package AlgoStudy.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ19584 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());		// 좌표 개수
		int M = Integer.parseInt(st.nextToken());		// 도로 수
		int[] y = new int[N+1];
		HashSet<Integer> numList = new HashSet<>();
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			y[i] = Integer.parseInt(st.nextToken());
			numList.add(y[i]);
		}
		
		List<Integer> list = new ArrayList<>(numList);
		Collections.sort(list, Collections.reverseOrder());
		
		LinkedList<RouteInfo> route = new LinkedList<>();
		int up, under, price;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			up = y[Integer.parseInt(st.nextToken())];
			under = y[Integer.parseInt(st.nextToken())];
			price = Integer.parseInt(st.nextToken());
			if(up < under) {
				int temp = up;
				up = under;
				under = temp;
			}
			route.add(new RouteInfo(up, under, price));
		}
		
		Collections.sort(route);
		
		int res = 0, max = 0;
		int top = 0, bottom = 0;
		int idx = 0;
		float mid;
		while(true) {
			mid = (float)(list.get(idx) + list.get(idx+1)) / 2;
			// upper bound
			while(top < M && mid <= route.get(top).under) {
				res -= route.get(top).price;
				top++;
			}
			// under bound
			while(bottom < M && mid < route.get(bottom).up) {
				res += route.get(bottom).price;
				bottom++;
			}
			max = Math.max(res, max);
			idx++;
			if(top == M || bottom == M)
				break;
			if(idx == list.size()-1)
				break;
		}
		
		System.out.println(max);
	}

}

class RouteInfo implements Comparable<RouteInfo>{
	int up;
	int under;
	int price;
	
	RouteInfo(int up, int under, int price){
		this.up = up;
		this.under = under;
		this.price = price;
	}

	@Override
	public int compareTo(RouteInfo r) {
		// TODO Auto-generated method stub
		if(this.up == r.up)
			return r.under - this.under;
		return r.up - this.up;
	}
	
}
