package BJAlgo.Level1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class CharCount {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
		int[] count;
		count = new int[26];
		int num, max = -1;
		char c = '?';
		
		for(int i = 0; i < str.length(); i++) {
			num = bytes[i];
			if(num >= 97)
				count[num-97]++;
			else
				count[num-65]++;
		}
		
		for(int i = 0; i < 26; i++) {
			if(max == count[i]) {
				c = '?';
			}
			else if(max < count[i]) {
				c = (char)(i+65);
				max = count[i];
			}
		}
		
		System.out.println(c);
	}
}