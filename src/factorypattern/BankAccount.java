package factorypattern;

public class BankAccount implements Account {
	 private String accountNumber ;
	 private String accountType;
	 public BankAccount(){
		  this.accountNumber = "123457858965874";
		  setAccountType();
	 }

	@Override
	public void setAccountType() {
     		this.accountType = "Saving Account";
	}

	@Override
	public void validateAccountNumber() {
		
	}

	@Override
	public double calculateInterestRate() {		
		return 6.0;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}

	@Override
	public String getAccountType() {
		System.out.println(accountType);
		return null;
	}
	
}
