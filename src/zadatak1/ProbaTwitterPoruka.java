package zadatak1;

import java.time.LocalDateTime;

public class ProbaTwitterPoruka {

	public static void main(String[] args) {
		TwitterPoruka tp = new TwitterPoruka();

		tp.postaviKorisnika("pera121");

		tp.postaviPoruku("Ovo je #moja prva #poruka");

		tp.ispisi();

		System.out.println("Hes tagova: " + tp.prebrojHash());

		System.out.println("Broj reci: " + tp.prebrojReci());

		/*
		 *10 februar 2000. godine. 
		 *0 sati 0 minuta 0 sekundi
		 */
		LocalDateTime rodjendan = LocalDateTime.of(2000, 2, 10, 0, 0, 0); 
		
		System.out.println("Napisano na rodjendan:" + tp.proveriRodjendan(rodjendan));
	}

}
