package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int x1, y1, r1, x2, y2, r2;
		for(int i = 0; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			double len = Math.sqrt(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2));
			double rr = (double)(r1+r2);
			if(len < rr) {
				if(r1 < r2) {
					if(len+r1 < r2)
						sb.append(0).append("\n");
					else if(len+r1 == r2)
						sb.append(1).append("\n");
					else
						sb.append(2).append("\n");
				}
				else if(r1 > r2) {
					if(len+r2 < r1)
						sb.append(0).append("\n");
					else if(len+r2 == r1)
						sb.append(1).append("\n");
					else
						sb.append(2).append("\n");
				}
			}
			else if(len > rr)
				sb.append(0).append("\n");
			else {
				if(x1 == x2 && y1 == y2)
					sb.append(-1).append("\n");
				else
					sb.append(1).append("\n");
			}
		}
		System.out.print(sb);
	}

}
