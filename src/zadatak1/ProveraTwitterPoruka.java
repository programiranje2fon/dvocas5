package zadatak1;

import java.util.GregorianCalendar;

public class ProveraTwitterPoruka {

	public static void main(String[] args) {
		TwitterPoruka tp = new TwitterPoruka();
		
		tp.postaviKorisnika("pera121");
		
		tp.postaviPoruku("Ovo je #moja prva #poruka");
		
		tp.ispisi();

		System.out.println("Hes tagova: " + tp.prebrojHash());

		System.out.println("Broj reci: " + tp.prebrojReci());
		
		GregorianCalendar rodjendan = new GregorianCalendar();
		
		rodjendan.set(2001, 9, 27);
		
		System.out.println("Napisano na rodjendan:" + tp.proveriRodjendan(rodjendan));
	}

}
