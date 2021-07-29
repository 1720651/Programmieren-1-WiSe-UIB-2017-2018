package Bankprojekt.Hummelbank.de.hsma.pr1.banking.domain;

import Bankprojekt.Hummelbank.de.hsma.pr1.banking.ui.TextUi;

public class BankApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Bank spk = new Bank("Sparkasse Mannheim", "de", 500, "BICSPKMA");
		TextUi tui = new TextUi(spk);
	}

}
