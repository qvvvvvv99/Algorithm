package AlgoStudy.Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2096 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[3];
		int[][] dp_max = new int[2][3];
		int[][] dp_min = new int[2][3];

		Arrays.fill(dp_min[1], Integer.MAX_VALUE);
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			for(int j = 0; j < 3; j++) {
				for(int k = j-1; k < j + 2; k++) {
					if(k < 0 || k > 2)
						continue;
					// �� ������ �ƽ� ����ֱ�
					dp_max[1][j] = Math.max(dp_max[1][j], dp_max[0][k] + input[j]);
					dp_min[1][j] = Math.min(dp_min[1][j], dp_min[0][k] + input[j]);
				}
			}
			for(int j = 0; j < 3; j++) {
				dp_max[0][j] = dp_max[1][j];
				dp_max[1][j] = 0;
				dp_min[0][j] = dp_min[1][j];
				dp_min[1][j] = Integer.MAX_VALUE;
			}
		}
		
		int max = Math.max(dp_max[0][0], Math.max(dp_max[0][1], dp_max[0][2]));
		int min = Math.min(dp_min[0][0], Math.min(dp_min[0][1], dp_min[0][2]));
		
		System.out.println(max + " " + min);
	}

}
