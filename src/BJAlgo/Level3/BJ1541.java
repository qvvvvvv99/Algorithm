package BJAlgo.Level3;

import java.util.*;

public class BJ1541 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		ArrayList<Integer> numList= new ArrayList<Integer>();
		ArrayList<Character> opeList= new ArrayList<Character>();
		int i = 0;
		
		while(true) {
			int num = 0;
			while(input.charAt(i) -'0' >= 0 && input.charAt(i) -'0' <= 9) {
				num *= 10;
				num += input.charAt(i) -'0';
				i++;
				if(i == input.length())
					break;
			}
			numList.add(num);
			if(i == input.length())
				break;
			opeList.add(input.charAt(i));
			i++;
		}
		
		int sum = numList.get(0);
		for(int j = 0; j < opeList.size(); j++) {
			if(opeList.get(j) == '+') {
				sum += numList.get(j+1);
			}else {
				int temp = numList.get(j+1);
				while(true) {
					j++;
					if(j == opeList.size())
						break;
					if(opeList.get(j) == '-') {
						j--;
						break;
					}
					temp+=numList.get(j+1);
				}
				sum -= temp;
			}
		}
		
		System.out.println(sum);
	}

}