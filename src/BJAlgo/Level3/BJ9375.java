package BJAlgo.Level3;

import java.io.*;

public class BJ9375 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] wear = new String[n];
			int[] cnt = new int[n];
			int size = 0;
			for(int j = 0; j < n; j++) {
				String[] input = br.readLine().split(" ");
				int k = 0;
				for(k = 0; k < size; k++) {
					if(wear[k].equals(input[1])) {
						cnt[k]++;
						break;
					}
				}
				if(k==size) {
					wear[k] = input[1];
					cnt[k] = 1;
					size++;
				}
			}
			
			int res = 1;
			for(int j = 0; j < size; j++) {
				res *= (cnt[j]+1);
			}
			
			sb.append(res-1+"\n");
		}
		br.close();
		System.out.print(sb);
	}
}
