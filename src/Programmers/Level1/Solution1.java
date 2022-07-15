package Programmers.Level1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		System.out.println(solution(id_list, report, k));
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		int len = id_list.length;
		int[] answer = new int[len];
		
		ArrayList<String> user = new ArrayList<>();
		for(int i = 0; i < len; i++)
			user.add(id_list[i]);
			
		int[] reported = new int[len];
		
		HashSet<String> rep_set = new HashSet<>();
		
		for(int i = 0; i < report.length; i++) {
			rep_set.add(report[i]);
		}
		
		LinkedList<String>[] rep = new LinkedList[len];
		for(int i = 0; i < len; i++)
			rep[i] = new LinkedList<String>();
		
		Iterator<String> str = rep_set.iterator();
		while(str.hasNext()) {
			String[] line = str.next().split(" ");
			reported[user.indexOf(line[1])]++;
			rep[user.indexOf(line[1])].add(line[0]);
		}
		
		for(int i = 0; i < len; i++) {
			if(reported[i] >= k) {
				for(int j = 0; j < rep[i].size(); j++) {
					answer[user.indexOf(rep[i].get(j))]++;
				}
			}
		}
		
		return answer;
	}
}