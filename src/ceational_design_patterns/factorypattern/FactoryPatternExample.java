package ceational_design_patterns.factorypattern;

public class FactoryPatternExample {
	public static void main(String[] args) {
			
		String accountName ="bank";
		Account account =  AccountFactory.factory(accountName);
		account.getAccountType();
	}

}
