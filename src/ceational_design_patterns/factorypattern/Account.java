package ceational_design_patterns.factorypattern;

public interface Account {
	
	public void setAccountType();
	
	public void validateAccountNumber();
	
	public double calculateInterestRate();

	public String getAccountType();
}
