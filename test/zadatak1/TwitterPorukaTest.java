package zadatak1;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {
	
	TwitterPoruka instance;

	@Before
	public void setUp() throws Exception {
		instance = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test (timeout = 2000)
	public void atribut_korisnik() {
		assertEquals("Pocetna vrednost nije 'nepoznato'", "nepoznato", instance.korisnik);
	}
	
	@Test (timeout = 2000)
	public void atribut_poruka() {
		assertEquals("Pocetna vrednost nije 'nepoznato'", "nepoznato", instance.poruka);
	}
	
	@Test (timeout = 2000)
	public void atribut_datum() {
		LocalDateTime dat = LocalDateTime.now();	
		assertEquals("Pocetna vrednost nije trenutni datum i vreme", dat.getYear(), instance.datum.getYear());
		assertEquals("Pocetna vrednost nije trenutni datum i vreme", dat.getMonthValue(), instance.datum.getMonthValue());
		assertEquals("Pocetna vrednost nije trenutni datum i vreme", dat.getDayOfMonth(), instance.datum.getDayOfMonth());
	}

	@Test (timeout = 2000)
	public void metoda_postaviKorisnika() {
		instance.postaviKorisnika("mika");
		
		assertEquals("Kad se unese 'mika' atribut korisnik ne dobija tu vrednost", "mika", instance.korisnik);
	}

	@Test (timeout = 2000)
	public void metoda_postaviKorisnika_Null() {
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance.postaviKorisnika(null);

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("Za unet NULL String NE ispisuje se rec GRESKA na ekranu", ispis.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}

	@Test (timeout = 2000)
	public void metoda_postaviKorisnika_Nepoznato() {
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance.postaviKorisnika("nepoznato");

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("Za unet String 'nepoznato' NE ispisuje se rec GRESKA na ekranu", ispis.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}
	
	@Test (timeout = 2000)
	public void metoda_postaviPoruku() {
		instance.postaviPoruku("Moja poruka");
		
		assertEquals("Kad se unese 'Moja poruka' atribut poruka ne dobija tu vrednost", "Moja poruka", instance.poruka);
		
	}

	@Test (timeout = 2000)
	public void metoda_postaviPoruku_Null() {
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance.postaviPoruku(null);

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("Za unet NULL String NE ispisuje se rec GRESKA na ekranu", ispis.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}

	@Test (timeout = 2000)
	public void metoda_postaviPoruku_Predugacka() {
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance.postaviPoruku("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + 
					"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + 
					"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("Za unetu predugacku poruku NE ispisuje se rec GRESKA na ekranu", ispis.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}

	@Test (timeout = 2000)
	public void metoda_prebrojHash() {
		instance.postaviPoruku("Moja poruka sa #jednim ili #dva hes taga.");
		
		assertEquals("Ako se unese poruka 'Moja poruka sa #jednim ili #dva hes taga.', ne prebrojava dva taga", 2, instance.prebrojHash());
	}

	@Test (timeout = 2000)
	public void metoda_prebrojReci() {
		instance.postaviPoruku("Moja poruka sa #jednim ili #dva hes taga.");
		
		assertEquals("Ako se unese poruka 'Moja poruka sa #jednim ili #dva hes taga.', ne prebrojava osam reci", 8, instance.prebrojReci());
	}

	@Test (timeout = 2000)
	public void metoda_proveriRodjendan_True() {
		LocalDateTime rodjendan = LocalDateTime.now();
		
		rodjendan = rodjendan.withYear(2001);
		
		assertTrue("Kad se unese danasnji dan i mesec ali 2001. godine kao datum rodjenja, metoda ne vraca true", instance.proveriRodjendan(rodjendan));
	}
	
	@Test (timeout = 2000)
	public void metoda_proveriRodjendan_False() {
		LocalDateTime rodjendan = LocalDateTime.of(2004, 2, 29, 0,0,0);
		
		assertFalse("Kad se unese 29.2.2004. godine kao datum rodjenja, metoda ne vraca false", instance.proveriRodjendan(rodjendan));
	}
	
	@Test (timeout = 2000)
	public void metoda_proveriRodjendan_Null() {
		assertEquals("Kad se unese NULL kao datum rodjenja, metoda ne vraca false", false, instance.proveriRodjendan(null));
	}
	
	@Test (timeout = 2000)
	public void metoda_proveriRodjendan_BuduciDatum() {
		LocalDateTime date = LocalDateTime.now();
		LocalDateTime rodjendan = LocalDateTime.of(date.getYear()+1, 2, 29,0,0,0);

		assertEquals("Kad se unese datum rodjenja iz BUDUCNOSTI, metoda ne vraca false", false, instance.proveriRodjendan(rodjendan));
	}

}
