package uebungen.aufgaben;
import java.util.Scanner;
import java.util.ArrayList;

public class _Exercise9 {

	public static void main(String[] args) {
        System.out.println("*****************************");
        System.out.println("*** WILLKOMMEN BEIM LOTTO ***");
        System.out.println("*****************************");
		Scanner scglobal = new Scanner(System.in);
        System.out.println("Geben Sie hier ihre Teilnehmeranzahl des Lottospiels an: ");
        int teilnehmer = scglobal.nextInt();
        ArrayList <ArrayList<Integer>> teilnehmerlottozettel = new ArrayList <ArrayList<Integer>> ();
        
        for (int x = 1; x <= teilnehmer; x++)
        {
        	System.out.println("Teilnehmer " + x + " ist dran!");
        	teilnehmerlottozettel.add(new ArrayList <Integer>());
        	teilnehmerlottozettel.set((x-1), (Spieler6ZahlenEinlesen(scglobal)));
        }
        ArrayList<Integer> lotto49Array = Lottoziehung();
        
        for (int x = 1; x <= teilnehmer; x++) {
        	System.out.println("Teilnehmer " + x);
        	überprüfung(teilnehmerlottozettel.get(x-1), lotto49Array);
        }
       
	}

	public static ArrayList<Integer> Spieler6ZahlenEinlesen(Scanner scglobale) {
		ArrayList<Integer> lottozettel = new ArrayList<Integer>();
		System.out.println("Geben sie ihre 6 Lottozahlen an");
		for(int i = 0; i < 6; i++) {
			int lottozahl = scglobale.nextInt();
			if(!(lottozettel.contains(lottozahl)))
				lottozettel.add(lottozahl);
			else {
					System.out.println("Diese Zahl ist auf ihrem Zettel vorhanden");
					--i;				
			}
		}
		System.out.println("Ihre Zahlen lauten : " + lottozettel);
		return lottozettel;
	}
	
	public static ArrayList<Integer> Lottoziehung(){
		ArrayList<Integer> lotto49pool = new ArrayList<Integer>();
			for( int j = 1; j < 50; j++) {
				lotto49pool.add(j);
			}
			ArrayList<Integer> gezogeneLottoZahlen = new ArrayList<Integer>();
			for(int k = 0; k != 6; k++) {
				int zufallszahlen = (int) ((Math.random() * (lotto49pool.size()-1)) + 1);
				gezogeneLottoZahlen.add(lotto49pool.get(zufallszahlen));
				lotto49pool.remove(zufallszahlen);
			}
			System.out.println("########################################################");
			System.out.println("Die gezogenen Lottozahlen sind: " + gezogeneLottoZahlen);
			System.out.println("########################################################");
			
			int zusatzzahlrandom = (int) ((Math.random() * lotto49pool.size()-1) + 1);
			gezogeneLottoZahlen.add(lotto49pool.get(zusatzzahlrandom));
			System.out.println("Die gezogenen Zusatzzahl ist: " + (lotto49pool.get(zusatzzahlrandom)));
			System.out.println("########################################################");
			lotto49pool.remove(zusatzzahlrandom);
			return gezogeneLottoZahlen;

}
	public static void überprüfung(ArrayList<Integer> Lottozettel, ArrayList<Integer> sechsgezogeneLottoZahlenundzusatzzahl  ) {
		ArrayList<Integer> getroffeneZahlen = new ArrayList<Integer>();
		for(int i = 0; i < (Lottozettel.size() -1); i++ ) {
			if(sechsgezogeneLottoZahlenundzusatzzahl.contains(Lottozettel.get(i)))
				getroffeneZahlen.add((Lottozettel.get(i)));
		}
		if(((getroffeneZahlen.size()==0)))
			System.out.println("Sie haben von ihrem Zettel: "+ Lottozettel + " keine Zahl getroffen !!! ");
		else if((getroffeneZahlen.size()!=0))
			System.out.println("Sie haben von ihrem Zettel: "+ Lottozettel + " die Zahl(en) " + getroffeneZahlen +" getroffen");	
			if(Lottozettel.contains((sechsgezogeneLottoZahlenundzusatzzahl.get(6))))
				System.out.println("Und dazu NOCH die Zusatzzahl :  " + (sechsgezogeneLottoZahlenundzusatzzahl.get(6)) );

	}
}

