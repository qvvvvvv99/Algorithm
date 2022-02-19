package FastCampus.AlgoPrac;

import java.io.*;

public class BJ17389 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String OX = br.readLine();
		int sum = 0;
		int bonus = 0;
		
		for(int i = 0; i < N; i++) {
			if(OX.charAt(i) == 'O') {
				sum+=(i+1) + bonus++;
			}else if(OX.charAt(i) == 'X') {
				bonus = 0;
			}
		}
		
		System.out.println(sum);
	}

}
