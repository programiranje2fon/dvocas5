package zadatak1;

import java.time.LocalDate;

public class ProveraTwitterPoruka {

	public static void main(String[] args) {
		TwitterPoruka tp = new TwitterPoruka();
		
		tp.postaviKorisnika("pera121");
		
		tp.postaviPoruku("Ovo je #moja prva #poruka");
		
		tp.ispisi();

		System.out.println("Hes tagova: " + tp.prebrojHash());

		System.out.println("Broj reci: " + tp.prebrojReci());
		
		LocalDate rodjendan = LocalDate.of(2000, 2, 10); //10 februar 2000. godine
		
		System.out.println("Napisano na rodjendan:" + tp.proveriRodjendan(rodjendan));
	}

}
