package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1256 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] leftworks = new ArrayList[(int)Math.pow(2,H+1)];
		ArrayList<Integer>[] rightworks = new ArrayList[(int)Math.pow(2,H)];
		for(int i = 0; i < (int)Math.pow(2,H+1); i++)
			leftworks[i] = new ArrayList<>();
		for(int i = 0; i < (int)Math.pow(2,H); i++)
			rightworks[i] = new ArrayList<>();
		
		for(int i = (int)Math.pow(2,H); i < (int)Math.pow(2,H+1); i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < K; j++) 
				leftworks[i].add(Integer.parseInt(st.nextToken()));
		}
		
		int work;
		int res = 0;
		for(int day = 1; day <= R; day++) {
			for(int idx = 1; idx < (int)Math.pow(2,H+1); idx++) {
				if(idx >= (int)Math.pow(2,H) || day % 2 == 1) {
					if(leftworks[idx].isEmpty())
						continue;
					work = leftworks[idx].remove(0);
				}
				else {
					if(rightworks[idx].isEmpty())
						continue;
					work = rightworks[idx].remove(0);
				}
				if(idx % 2 == 0)
					leftworks[idx/2].add(work);
				else
					rightworks[idx/2].add(work);
			}
		}
		while(!leftworks[0].isEmpty())
			res += leftworks[0].remove(0);
		while(!rightworks[0].isEmpty())
			res += rightworks[0].remove(0);
		
		System.out.println(res);
	}

}
