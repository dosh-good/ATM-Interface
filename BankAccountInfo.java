
public class BankAccountInfo {
	double balance;
	String name;
	
	public BankAccountInfo() {
		return;
	}
	
	public void addFunds (double add) {
		this.balance = balance + add;
	}
	
	public void withdrawFunds(int withdraw) {
		this.balance = balance - withdraw;	
	}
	
	public String getName(String name) {
		return name = this.name;
	}
	
	public double getBalance() {
			return this.balance;
	}
}
