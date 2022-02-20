package BJAlgo.Level3;

import java.io.*;

public class BJ1003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < tc; i++) {
			int num = Integer.parseInt(br.readLine());
			int[][] ary = new int[num+1][2];
			ary[0][0] = 1;
			if(num > 0)
				ary[1][1] = 1;
			for(int j = 2; j <= num; j++) {
				ary[j][0] = ary[j-2][0] + ary[j-1][0];
				ary[j][1] = ary[j-2][1] + ary[j-1][1];
			}
			sb.append(ary[num][0]+" "+ary[num][1]+"\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}

}
