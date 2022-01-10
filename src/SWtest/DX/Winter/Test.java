package SWtest.DX.Winter;

import java.util.ArrayList;
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
		userAns = usersolution.buy(mNumber, mStock, mQuantity, mPrice);
	}

}

class User {
	private List<NonBuyingTable> nonBuy;
	private List<NonSellingTable> nonSell;
	
	public void init()
	{
		nonBuy = new ArrayList<NonBuyingTable>();
		nonSell = new ArrayList<NonSellingTable>();
	}
	
	public int buy(int mNumber, int mStock, int mQuantity, int mPrice)
	{
		int quantity = 10;
		
		nonBuy.add(new NonBuyingTable(mNumber, mStock, mQuantity, mPrice));
		
		System.out.println(nonBuy.get(0).mNumber + " " + nonBuy.get(0).mStock+ " " + nonBuy.get(0).mQuantity+ " " + nonBuy.get(0).mPrice);
		
		for(int i = 0; i < nonSell.size(); i++) {
			if(nonSell.get(i).mStock == mStock) {
				// 최소 매도 값 찾기
				if(nonSell.get(i).mPrice <= mPrice) {
					quantity = nonSell.get(i).mQuantity - mQuantity;
					if(quantity == 0) {
						nonSell.remove(i);
					} else if(quantity < 0) {
						nonSell.remove(i);
						nonBuy.add(new NonBuyingTable(mNumber, mStock, Math.abs(quantity), mPrice));
					} else {
						// 매도 테이블 quantity 바꾸기
						// nonSele.set();
					}
				}
			}
		}
		return 0;
	}
}