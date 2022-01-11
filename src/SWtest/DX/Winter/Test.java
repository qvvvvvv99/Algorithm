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
		
		mNumber = Integer.parseInt("1");
		mStock = Integer.parseInt("2");
		mQuantity = Integer.parseInt("3");
		mPrice = Integer.parseInt("4");
		userAns = usersolution.sell(mNumber, mStock, mQuantity, mPrice);
		userAns = usersolution.sell(2, 1, 5, 50);
		userAns = usersolution.sell(3, 1, 8, 100);
		userAns = usersolution.sell(5, 1, 10, 100);
		userAns = usersolution.sell(6, 1, 50, 100);
		userAns = usersolution.sell(7, 1, 100, 50);
		usersolution.printList();
		userAns = usersolution.buy(4, 1, 50, 30);
		
//		usersolution.cancel(2);
//		usersolution.printList();
		
//		usersolution.setQuantity(3);
//		usersolution.printList();
	}

}

class User {
	private List<NonBuyingTable> nonBuy;
	private List<NonSellingTable> nonSell;
	private List<TemporaryTable> box;
	
	public void init()
	{
		nonBuy = new ArrayList<NonBuyingTable>();
		nonSell = new ArrayList<NonSellingTable>();
	}
	
	public int buy(int mNumber, int mStock, int mQuantity, int mPrice)
	{
		int quantity = 10;
		
		box = new ArrayList<TemporaryTable>();
		
		for(int i = 0; i < nonSell.size(); i++) {
			if(nonSell.get(i).getmStock() == mStock) {
				if(nonSell.get(i).getmPrice() <= mPrice) {
					box.add(new TemporaryTable(mNumber, mQuantity, mPrice));
				}
			}
		}
		
		// SampleTable 정렬 (mPrice 낮은 순 -> mNumber 순)
		// *************다시 다시 다시
		Collections.sort(box, new SortTemTable());
		
		System.out.println(box);
		
		return 0;
	}
	
	public int sell(int mNumber, int mStock, int mQuantity, int mPrice)
	{
		nonSell.add(new NonSellingTable(mNumber, mStock, mQuantity, mPrice));
		
		return 0;
	}
	
	public void cancel(int mNumber)
	{
		for(int i = 0; i < nonBuy.size(); i++) {
			if(nonBuy.get(i).getmNumber() == mNumber)
				nonBuy.remove(i);
		}
	}
	
	public void printList() {
		System.out.println(nonSell.size());
		for(int i = 0; i < nonSell.size(); i++)
			System.out.println(nonSell.get(i).getmNumber() + " " + nonSell.get(i).getmStock()+ " " + nonSell.get(i).getmQuantity()+ " " + nonSell.get(i).getmPrice());
	}
	
	public void setQuantity(int mNumber) {
		for(int i = 0; i < nonBuy.size(); i++) {
			if(nonBuy.get(i).getmNumber() == mNumber)
				nonBuy.get(i).setmQuantity(5000);
		}
	}
}