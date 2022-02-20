package FastCampus.AlgoPrac;

import java.io.*;
import java.util.*;

public class BJ16165 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		StringBuffer sb = new StringBuffer();
		
		ArrayList<Member> list = new ArrayList<Member>();
		for(int i = 0; i < N; i++) {
			String group = br.readLine();
			int num = Integer.parseInt(br.readLine());
			for(int j = 0; j < num; j++) {
				String name = br.readLine();
				list.add(new Member(group, name));
			}
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			int num = Integer.parseInt(br.readLine());
			if(num == 1) {
				for(int j = 0; j < list.size(); j++) {
					if(list.get(j).getName().equals(str)) {
						sb.append(list.get(j).getGroup()+"\n");
						break;
					}
				}
			}else {
				for(int j = 0; j < list.size(); j++) {
					if(list.get(j).getGroup().equals(str))
						sb.append(list.get(j).getName()+"\n");
				}
			}
		}
		
		System.out.print(sb);
		br.close();
	}

}

class Member implements Comparable<Member>{
	private String group;
	private String name;
	
	Member(String group, String name){
		this.setGroup(group);
		this.setName(name);
	}

	@Override
	public int compareTo(Member mem) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(mem.getName());
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
