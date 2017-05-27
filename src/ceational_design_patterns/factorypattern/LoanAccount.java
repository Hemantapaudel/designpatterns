package ceational_design_patterns.factorypattern;

public class LoanAccount implements Account{

private String accountNumber;
private String accountType;
	
	public LoanAccount() {
	this.accountNumber = "123456789369852";
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}

	@Override
	public void setAccountType() {
			this.accountType ="home loan";
	}

	@Override
	public void validateAccountNumber() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calculateInterestRate() {
		return 8.6;
	}

	@Override
	public String getAccountType() {
		System.out.println(accountType);
		return null;
	}
}
