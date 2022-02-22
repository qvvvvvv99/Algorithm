package FastCampus.AlgoPrac;

import java.io.*;
import java.util.*;

public class BJ17413 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine(); 
		StringBuffer output = new StringBuffer();
		
		int idx = 0;
		StringBuffer temp = new StringBuffer();
		while(idx < input.length()) {
			switch(input.charAt(idx)) {
			case '<':
				output.append(temp.reverse());
				temp = new StringBuffer();
				while (input.charAt(idx) != '>') {
					output.append(input.charAt(idx));
					idx++;
				}
				break;
			case '>':
				output.append('>');
				idx++;
				break;
			case ' ':
				output.append(temp.reverse()+" ");
				idx++;
				temp = new StringBuffer();
			default:
				temp.append(input.charAt(idx));
				idx++;
			}
		}
		output.append(temp.reverse());
		
		br.close();
		System.out.println(output);
	}

}
