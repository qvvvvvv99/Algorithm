package SWtest.DX.Winter;

import java.util.*;

class UserSolution
{
	private List<NonBuyingTable> nonBuy;
	private List<NonSellingTable> nonSell;
	
	public void init()
	{
		nonBuy = new ArrayList<NonBuyingTable>();
		nonSell = new ArrayList<NonSellingTable>();
	}
	
	public int buy(int mNumber, int mStock, int mQuantity, int mPrice)
	{
		int quantity;
		
		for(int i = 0; i < nonSell.size(); i++) {
			if(nonSell.get(i).mStock == mStock) {
				if(nonSell.get(i).mPrice <= mPrice) {
					quantity = nonSell.get(i).mQuantity - mQuantity;
					if(quantity == 0) {
						nonSell.remove(i);
					} else if(quantity < 0) {
						nonSell.remove(i);
						nonBuy.add(new NonBuyingTable(mNumber, mStock, Math.abs(quantity), mPrice));
					} else {
					//	nonSell.set(i, 2, quantity);
					}
				}
			}
		}
		return 0;
	}
	
	public int sell(int mNumber, int mStock, int mQuantity, int mPrice)
	{
		return 0;
	}

	public void cancel(int mNumber)
	{
	}
	
	public int bestProfit(int mStock)
	{
		return 0;
	}
	
}

class NonBuyingTable {
	int mNumber;
	int mStock;
	int mQuantity;
	int mPrice;
	
	NonBuyingTable(){}
	NonBuyingTable(int mNumber, int mStock, int mQuantity, int mPrice){
		this.mNumber = mNumber;
		this.mStock = mStock;
		this.mQuantity = mQuantity;
		this.mPrice = mPrice;
	}
}

class NonSellingTable {
	int mNumber;
	int mStock;
	int mQuantity;
	int mPrice;
	
	NonSellingTable(){}
	NonSellingTable(int mNumber, int mStock, int mQuantity, int mPrice){
		this.mNumber = mNumber;
		this.mStock = mStock;
		this.mQuantity = mQuantity;
		this.mPrice = mPrice;
	}
}