package Basic;

class BankAccount{
	int balance;
	
	void deposit(int amount) {
		balance += amount;
	}
	
	void withdraw(int amount) {
		if(balance < amount)
		{
			System.out.println("ÀÜ¾× ºÎÁ·");
			return;
		}
		balance -= amount;
	}
	
	int getBalance() {
		return balance;
	}
	
	void addInterest() {
		balance *= 1.075;
	}
}

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount b = new BankAccount();
		b.balance = 100;
		b.withdraw(60);
		System.out.println(b.getBalance());
		b.addInterest();
		System.out.println(b.getBalance());
	}

}
