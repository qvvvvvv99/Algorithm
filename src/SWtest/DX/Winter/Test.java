package SWtest.DX.Winter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	private final static User usersolution = new User();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mNumber, mStock, mQuantity, mPrice;
		int userAns;

		usersolution.init();

		userAns = usersolution.buy(1, 1, 5, 105);
		userAns = usersolution.buy(2, 1, 5, 100);
		userAns = usersolution.sell(3, 1, 12, 100);
		usersolution.printList();
		System.out.println("return : " + userAns);
		userAns = usersolution.bestProfit(1);
		System.out.println("bestProfit : " + userAns);
		userAns = usersolution.sell(4, 1, 8, 90);
		userAns = usersolution.sell(5, 1, 1, 110);
		userAns = usersolution.buy(6, 1, 11, 110);
		usersolution.printList();
		System.out.println("return : " + userAns);
		userAns = usersolution.bestProfit(1);
		System.out.println("bestProfit : " + userAns);
		userAns = usersolution.buy(7, 1, 1, 80);
		userAns = usersolution.buy(8, 1, 1, 85);
		userAns = usersolution.sell(9, 1, 3, 70);
		usersolution.printList();
		System.out.println("return : " + userAns);
		usersolution.cancel(9);
		usersolution.printList();
		System.out.println("return : " + userAns);
		userAns = usersolution.buy(10, 1, 1, 70);
		userAns = usersolution.bestProfit(1);
		System.out.println("bestProfit : " + userAns);
		userAns = usersolution.sell(11, 5, 500000, 1000000);
		userAns = usersolution.sell(12, 5, 499999, 999999);
		userAns = usersolution.buy(13, 5, 1000000, 1000000);
		usersolution.printList();
		System.out.println("return : " + userAns);
		userAns = usersolution.bestProfit(5);
		System.out.println("bestProfit : " + userAns);
	}

}

class User {
	private List<NonBuyingTable> nonBuy;
	private List<NonSellingTable> nonSell;
	private List<TemporaryTable> box;
	int dealPrice[][] = new int[5][100];
	int dealCount[] = new int[5];

	public void init() {
		nonBuy = new ArrayList<NonBuyingTable>();
		nonSell = new ArrayList<NonSellingTable>();
	}

	public int buy(int mNumber, int mStock, int mQuantity, int mPrice) {
		int quantity = mQuantity;

		box = new ArrayList<TemporaryTable>();

		for (int i = 0; i < nonSell.size(); i++) {
			if (nonSell.get(i).getmStock() == mStock) {
				if (nonSell.get(i).getmPrice() <= mPrice) {
					box.add(new TemporaryTable(nonSell.get(i).getmNumber(), nonSell.get(i).getmQuantity(),
							nonSell.get(i).getmPrice()));
				}
			}
		}

		// SampleTable 정렬 (mPrice 낮은 순 -> mNumber 순)
		Collections.sort(box, new SortSellTemTable());

		// 계약 체결하기
		if (box.size() > 0) {
			while (quantity > 0) {
				quantity -= box.get(0).getmQuantity();

				if (quantity >= 0) {
					for (int i = 0; i < nonSell.size(); i++) {
						if (nonSell.get(i).getmNumber() == box.get(0).getmNumber()) {
							nonSell.remove(i);
							dealPrice[mStock-1][dealCount[mStock-1]] = box.get(0).getmPrice();
							dealCount[mStock-1]++;
						}
					}
					box.remove(0);
					if (box.size() == 0)
						break;
				} else {
					for (int i = 0; i < nonSell.size(); i++) {
						if (nonSell.get(i).getmNumber() == box.get(0).getmNumber()) {
							nonSell.get(i).setmQuantity(Math.abs(quantity));
							dealPrice[mStock-1][dealCount[mStock-1]] = box.get(0).getmPrice();
							dealCount[mStock-1]++;
						}
					}
				}
			}
		}

		for (int i = 0; i < box.size(); i++)
			System.out
					.println(box.get(i).getmNumber() + " " + box.get(i).getmQuantity() + " " + box.get(i).getmPrice());

		if (quantity > 0) {
			nonBuy.add(new NonBuyingTable(mNumber, mStock, quantity, mPrice));
			return quantity;
		}

		return 0;
	}

	public int sell(int mNumber, int mStock, int mQuantity, int mPrice) {
		int quantity = mQuantity;

		box = new ArrayList<TemporaryTable>();

		for (int i = 0; i < nonBuy.size(); i++) {
			if (nonBuy.get(i).getmStock() == mStock) {
				if (nonBuy.get(i).getmPrice() >= mPrice) {
					box.add(new TemporaryTable(nonBuy.get(i).getmNumber(), nonBuy.get(i).getmQuantity(),
							nonBuy.get(i).getmPrice()));
				}
			}
		}

		Collections.sort(box, new SortBuyTemTable());

		// 계약 체결하기
		if (box.size() > 0) {
			while (quantity > 0) {
				quantity -= box.get(0).getmQuantity();

				if (quantity >= 0) {
					for (int i = 0; i < nonBuy.size(); i++) {
						if (nonBuy.get(i).getmNumber() == box.get(0).getmNumber()) {
							nonBuy.remove(i);
							dealPrice[mStock-1][dealCount[mStock-1]] = box.get(0).getmPrice();
							dealCount[mStock-1]++;
						}
					}
					box.remove(0);
					if (box.size() == 0)
						break;
				} else {
					for (int i = 0; i < nonBuy.size(); i++) {
						if (nonBuy.get(i).getmNumber() == box.get(0).getmNumber()) {
							nonBuy.get(i).setmQuantity(Math.abs(quantity));
							dealPrice[mStock-1][dealCount[mStock-1]] = box.get(0).getmPrice();
							dealCount[mStock-1]++;
						}
					}
				}
			}
		}

		for (int i = 0; i < box.size(); i++)
			System.out
					.println(box.get(i).getmNumber() + " " + box.get(i).getmQuantity() + " " + box.get(i).getmPrice());

		if (quantity > 0) {
			nonSell.add(new NonSellingTable(mNumber, mStock, quantity, mPrice));
			return quantity;
		}

		return 0;
	}

	public void cancel(int mNumber) {
		for (int i = 0; i < nonBuy.size(); i++) {
			if (nonBuy.get(i).getmNumber() == mNumber) {
				nonBuy.remove(i);
				return;
			}
		}
		for(int i = 0; i < nonSell.size(); i++) {
			if(nonSell.get(i).getmNumber() == mNumber) {
				nonSell.remove(i);
				return;
			}
		}
	}
	
	public int bestProfit(int mStock)
	{
		System.out.println(dealCount[mStock-1]);
		return dealPrice[mStock-1][dealCount[mStock-1]-1] - dealPrice[mStock-1][0];
	}

	public void printList() {
		System.out.println("NonSell Table : " + nonSell.size());
		for (int i = 0; i < nonSell.size(); i++)
			System.out.println(nonSell.get(i).getmNumber() + " " + nonSell.get(i).getmStock() + " "
					+ nonSell.get(i).getmQuantity() + " " + nonSell.get(i).getmPrice());

		System.out.println("NonBuy Table : " + nonBuy.size());
		for (int i = 0; i < nonBuy.size(); i++)
			System.out.println(nonBuy.get(i).getmNumber() + " " + nonBuy.get(i).getmStock() + " "
					+ nonBuy.get(i).getmQuantity() + " " + nonBuy.get(i).getmPrice());
	}
	
	public void printDeal() {
		for(int i = 0; i < 5; i++) {
			System.out.print("주식번호 " + (i+1)+" : ");
			for(int j = 0; j < dealCount[i]; j++) {
				System.out.print(dealPrice[i][j]+" ");
			}
			System.out.println();
		}
	}

	public void setQuantity(int mNumber) {
		for (int i = 0; i < nonBuy.size(); i++) {
			if (nonBuy.get(i).getmNumber() == mNumber)
				nonBuy.get(i).setmQuantity(5000);
		}
	}
}