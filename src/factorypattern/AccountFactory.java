package factorypattern;

public class AccountFactory {

	public static Account factory(String accountName) {

		if (accountName.equals("bank")) {
			return new BankAccount();
		}
		if (accountName.equals("card")) {
			return new CardAccount();
		}
		if (accountName.equals("loan")) {
			return new LoanAccount();
		}

		return null;
	}
}
