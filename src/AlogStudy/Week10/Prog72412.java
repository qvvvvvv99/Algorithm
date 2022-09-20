package AlogStudy.Week10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Prog72412 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		int[] answer = new int[query.length];
		answer = solution(info, query);

		for (int i = 0; i < query.length; i++)
			System.out.print(answer[i] + " ");
	}

	public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        ArrayList<Integer>[] list = new ArrayList[24];
        for(int i = 0; i < 24; i++)
        	list[i] = new ArrayList<>();
        
        for(int i = 0; i < info.length; i++) {
        	String[] line = info[i].split(" ");
        	int idx;
        	if(line[0].equals("cpp"))
        		idx = 4;
        	else if(line[0].equals("java"))
        		idx = 12;
        	else
        		idx = 20;
        	
        	if(line[1].equals("backend"))
        		idx -= 2;
        	else
        		idx += 2;
        	
        	if(line[2].equals("junior"))
        		idx--;
        	else
        		idx++;
        	
        	if(line[3].equals("chicken"))
        		idx--;
        	
        	list[idx].add(Integer.parseInt(line[4]));
        }
        
        // 내림차순 정렬
        for(int i = 0; i < 24; i++) {
        	Iterator iter = list[i].iterator();
        	if(!iter.hasNext())
        		continue;
        	Collections.sort(list[i]);
//        	iter = list[i].iterator();
//        	System.out.print(i + " : ");
//        	while(iter.hasNext()) 
//        		System.out.print(iter.next() + " ");
//        	System.out.println();
        }
        
        for(int i = 0; i < query.length; i++) {
        	String[] que = query[i].split(" and ");
        	int start = 0;
        	int end = 4;
        	int flag = 2;
        	int junior = 1;
        	int repeat = 1;
        	if(que[0].equals("java"))
        		start = 8;
        	else if(que[0].equals("python"))
        		start = 16;
        	else if(que[0].equals("-"))
        		repeat = 3;
        	
        	if(que[1].equals("frontend")) 
        		start += 4;
        	else if(que[1].equals("-"))
        		end = 8;
        	
        	if(que[2].equals("junior"))
        		end -= 2;
        	else if(que[2].equals("senior")) {
        		start += 2;
        		end -= 2;
        		junior = 0;
        	}
        	else {
        		junior = 2;
        	}
        	
        	String[] str = que[3].split(" ");
        	if(str[0].equals("pizza"))
        		start++;
        	else if(str[0].equals("-"))
        		flag = 1;
        	
        	for(int j = 0; j < repeat; j++) {
        		for(int s = 8 * j + start; s < 8 * j + start + end; s += flag) {
        			if((s / 2) % 2 == junior)
        				continue;
                	Iterator iter = list[s].iterator();
                	if(iter.hasNext()) {
                		// 완탐하니까 시간초과
//                		if((int)iter.next() < Integer.parseInt(str[1]))
//                			break;
//                		answer[i]++;
                		// 이분탐색
                		answer[i] += list[s].size() - binarySearch(list[s], Integer.parseInt(str[1]));
                	}
        		}
        	}
        }
        
        return answer;
    }

	public static int binarySearch(ArrayList<Integer> list, int value) {
		int fir = 0;
		int end = list.size()-1;
		int mid = 0;
		
		while(fir <= end) {
			mid = (fir + end) / 2;
			if(list.get(mid) < value) 
				fir = mid + 1;
			else 
				end = mid - 1;
		}
        
		return fir;
	}
}
