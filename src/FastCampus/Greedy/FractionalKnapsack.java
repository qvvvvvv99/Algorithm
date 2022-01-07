package FastCampus.Greedy;

import java.util.*;

class item {
	int weight;
	int value;
	double benefit;
}

// ¹Ì¿Ï¼º
public class FractionalKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int capacity = sc.nextInt();
		double profit = 0;
		item[] knapsack = new item[5];
		
		for(int i = 0; i < 5; i++) {
			knapsack[i].weight = sc.nextInt();
			knapsack[i].value = sc.nextInt();
			knapsack[i].benefit = (double)knapsack[i].value/knapsack[i].weight; 
		}
	}

}
