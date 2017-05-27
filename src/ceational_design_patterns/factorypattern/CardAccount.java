package ceational_design_patterns.factorypattern;



public class CardAccount implements Account{
	
	private String accountNumber;
	 private String accountType;
	public CardAccount() {
	this.accountNumber = "123456789369852";
	}
	
	
	@Override
	public void setAccountType() {
		this.accountType = "Visa card";		
	}

	@Override
	public void validateAccountNumber() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calculateInterestRate() {
			return 15.2;
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
