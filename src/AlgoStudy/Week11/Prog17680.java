package AlgoStudy.Week11;

import java.util.HashSet;

public class Prog17680 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		
		System.out.println(solution(cacheSize, cities));
	}

	public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        int[] order = new int[cacheSize];
        String[] str = new String[cacheSize];
        HashSet<String> set = new HashSet<>();
        
        for(int idx = 0; idx < cities.length; idx++) {
        	if(set.size() < cacheSize) {
        		if(set.contains(cities[idx].toUpperCase())) {
        			for(int i = 0; i < set.size(); i++) {
        				if(str[i].equals(cities[idx].toUpperCase())) 
        					order[i] = idx;
        			}
        			answer += 1;
        		}
        		else {
        			str[set.size()] = cities[idx].toUpperCase();
        			order[set.size()] = idx;
        			set.add(cities[idx].toUpperCase());
        			answer += 5;
        		}
        	}
        	else {
        		boolean flag = false;
        		int i, minIdx = 100000;
        		for(i = 0; i < cacheSize; i++) {
        			minIdx = Math.min(minIdx, order[i]);
        			if(str[i].equals(cities[idx].toUpperCase())) {
        				flag = true;
        				break;
        			}
        		}
        		
        		if(flag) {
        			order[i] = idx;
        			answer += 1;
        		}
        		else {
        			for(i = 0; i < cacheSize; i++) {
        				if(order[i] == minIdx) {
        					str[i] = cities[idx].toUpperCase();
        					order[i] = idx;
        					break;
        				}
        			}
        			answer += 5;
        		}
        	}
        }
        
        return answer;
    }
}
