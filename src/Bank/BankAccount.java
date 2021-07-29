package Bank;

public class BankAccount {
	String firstname;
	String secondname;
	String kontonummer;
	String currency;
	double money;
	double limit;
	
	public BankAccount(String vorname, String nachname, String kontonummer, String currency, double money, double limit) {
		this.firstname = vorname;
		this.secondname = nachname;
		this.kontonummer = kontonummer;
		this.currency = currency;
		this.money = money;
		this.limit = limit;
		System.out.printf("Deine Kontonummer : %s \n", kontonummer);
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getKontonummer() {
		return kontonummer;
	}

	public void setKontonummer(String kontonummer) {
		this.kontonummer = kontonummer;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public String kontostand() {
		return "Der Kontostand von " + firstname + " " + secondname + " beträgt " + this.money + " " + currency;
		}
	
	public double kontoEinzahlen(float moneyplus) {
		money+=moneyplus;
		return this.money;
		}
				
	public double kontoAuszahlen(float moneyminus) {
		money-=moneyminus;
		return this.money;
		}
}
