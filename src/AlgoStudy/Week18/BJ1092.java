package AlgoStudy.Week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1092 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 크레인 개수
		ArrayList<Integer> crains = new ArrayList<>();
		int min = -1;
		String input = br.readLine();
		StringTokenizer token = new StringTokenizer(input);
		for (int i = 0; i < N; i++)
			crains.add(Integer.parseInt(token.nextToken()));

		int M = Integer.parseInt(br.readLine()); // 박스 개수
		ArrayList<Integer> weight = new ArrayList<>();
		input = br.readLine();
		token = new StringTokenizer(input);
		for (int i = 0; i < M; i++)
			weight.add(Integer.parseInt(token.nextToken()));

		Collections.sort(crains, Collections.reverseOrder());
		Collections.sort(weight, Collections.reverseOrder());
		
		if (crains.get(0) >= weight.get(0)) {
			min = 0;
			while (!weight.isEmpty()) {
				int i = 0, j = 0;
				while(i < N) {
					if(j == weight.size())
						break;
					if(crains.get(i) >= weight.get(j)) {
						i++;
						weight.remove(j);
					}
					else
						j++;
				}
				min++;
			}
		}

		System.out.println(min);
	}

}
