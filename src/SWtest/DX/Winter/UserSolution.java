package SWtest.DX.Winter;

import java.util.*;

class UserSolution
{
	private List<NonBuyingTable> nonBuy;
	private List<NonSellingTable> nonSell;
	private List<TemporaryTable> box;
	int dealPrice[][] = new int[5][100];
	int dealCount[] = new int[5];
	
	public void init()
	{
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

		// 계약 체결하기
		if (box.size() > 0) {
			// SampleTable 정렬 (mPrice 낮은 순 -> mNumber 순)
			Collections.sort(box, new SortSellTemTable());
			
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

		// 계약 체결하기
		if (box.size() > 0) {
			Collections.sort(box, new SortBuyTemTable());
			
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

		if (quantity > 0) {
			nonSell.add(new NonSellingTable(mNumber, mStock, quantity, mPrice));
			return quantity;
		}

		return 0;
	}

	public void cancel(int mNumber)
	{
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
		return dealPrice[mStock-1][dealCount[mStock-1]-1] - dealPrice[mStock-1][0];
	}
	
}

// 매수 시 매도 가능 SampleTable 정렬 (mPrice 낮은 순 -> mNumber 순)
class SortSellTemTable implements Comparator<TemporaryTable>{
	int ret = 0;
	
	@Override
	public int compare(TemporaryTable t1, TemporaryTable t2) {
		// TODO Auto-generated method stub
		// mPrice 낮은 순
		if(t1.getmPrice() > t2.getmPrice()) 
			ret = 1;
		else if(t1.getmPrice() < t2.getmPrice())
			ret = -1;
		else{	// mPrice가 같으면 mNumber 낮은 순
			if(t1.getmNumber() > t2.getmNumber()) 
				ret = 1;
			else
				ret = -1;
		}
		
		return ret;
	}
	
}
//매도 시 매수 가능 SampleTable 정렬 (mPrice 높은 순 -> mNumber 순)
class SortBuyTemTable implements Comparator<TemporaryTable>{
	int ret = 0;
	
	@Override
	public int compare(TemporaryTable t1, TemporaryTable t2) {
		// TODO Auto-generated method stub
		// mPrice 높은 순
		if(t1.getmPrice() < t2.getmPrice()) 
			ret = 1;
		else if(t1.getmPrice() > t2.getmPrice())
			ret = -1;
		else{	// mPrice가 같으면 mNumber 낮은 순
			if(t1.getmNumber() > t2.getmNumber()) 
				ret = 1;
			else
				ret = -1;
		}
		
		return ret;
	}
	
}

class NonBuyingTable {
	private int mNumber;
	private int mStock;
	private int mQuantity;
	private int mPrice;
	
	NonBuyingTable(){}
	NonBuyingTable(int mNumber, int mStock, int mQuantity, int mPrice){
		this.mNumber = mNumber;
		this.mStock = mStock;
		this.mQuantity = mQuantity;
		this.mPrice = mPrice;
	}
	
	public int getmNumber() {
		return mNumber;
	}
	public void setmNumber(int mNumber) {
		this.mNumber = mNumber;
	}
	public int getmStock() {
		return mStock;
	}
	public void setmStock(int mStock) {
		this.mStock = mStock;
	}
	public int getmQuantity() {
		return mQuantity;
	}
	public void setmQuantity(int mQuantity) {
		this.mQuantity = mQuantity;
	}
	public int getmPrice() {
		return mPrice;
	}
	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}
}

class NonSellingTable {
	private int mNumber;
	private int mStock;
	private int mQuantity;
	private int mPrice;
	
	NonSellingTable(){}
	NonSellingTable(int mNumber, int mStock, int mQuantity, int mPrice){
		this.mNumber = mNumber;
		this.mStock = mStock;
		this.mQuantity = mQuantity;
		this.mPrice = mPrice;
	}
	
	public int getmNumber() {
		return mNumber;
	}
	public void setmNumber(int mNumber) {
		this.mNumber = mNumber;
	}
	public int getmStock() {
		return mStock;
	}
	public void setmStock(int mStock) {
		this.mStock = mStock;
	}
	public int getmQuantity() {
		return mQuantity;
	}
	public void setmQuantity(int mQuantity) {
		this.mQuantity = mQuantity;
	}
	public int getmPrice() {
		return mPrice;
	}
	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}
}

// 매수/매도 가능 주문 임시 저장 테이블
class TemporaryTable {
	private int mNumber;
	private int mQuantity;
	private int mPrice;
	
	TemporaryTable(){}
	TemporaryTable(int mNumber, int mQuantity, int mPrice){
		this.mNumber = mNumber;
		this.mQuantity = mQuantity;
		this.mPrice = mPrice;
	}
	
	public int getmNumber() {
		return mNumber;
	}
	public void setmNumber(int mNumber) {
		this.mNumber = mNumber;
	}
	public int getmQuantity() {
		return mQuantity;
	}
	public void setmQuantity(int mQuantity) {
		this.mQuantity = mQuantity;
	}
	public int getmPrice() {
		return mPrice;
	}
	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}
}