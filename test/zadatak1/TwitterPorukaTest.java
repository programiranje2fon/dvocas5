package zadatak1;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.GregorianCalendar;

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
		GregorianCalendar dat = new GregorianCalendar();		
		assertEquals("Pocetna vrednost nije trenutni datum i vreme", dat.get(GregorianCalendar.YEAR), instance.datum.get(GregorianCalendar.YEAR));
		assertEquals("Pocetna vrednost nije trenutni datum i vreme", dat.get(GregorianCalendar.MONTH), instance.datum.get(GregorianCalendar.MONTH));
		assertEquals("Pocetna vrednost nije trenutni datum i vreme", dat.get(GregorianCalendar.DAY_OF_MONTH), instance.datum.get(GregorianCalendar.DAY_OF_MONTH));
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
		GregorianCalendar rodjendan = new GregorianCalendar();
		
		rodjendan.set(2001, rodjendan.get(GregorianCalendar.MONTH), rodjendan.get(GregorianCalendar.DAY_OF_MONTH));
		
		assertTrue("Kad se unese danasnji dan i mesec ali 2001. godine kao datum rodjenja, metoda ne vraca true", instance.proveriRodjendan(rodjendan));
	}
	
	@Test (timeout = 2000)
	public void metoda_proveriRodjendan_False() {
		GregorianCalendar rodjendan = new GregorianCalendar();
		
		rodjendan.set(2004, 1, 29);
		
		assertFalse("Kad se unese 29.2.2004. godine kao datum rodjenja, metoda ne vraca false", instance.proveriRodjendan(rodjendan));
	}
	
	@Test (timeout = 2000)
	public void metoda_proveriRodjendan_Null() {
		assertEquals("Kad se unese NULL kao datum rodjenja, metoda ne vraca false", false, instance.proveriRodjendan(null));
	}
	
	@Test (timeout = 2000)
	public void metoda_proveriRodjendan_BuduciDatum() {
		GregorianCalendar rodjendan = new GregorianCalendar();
		
		rodjendan.set(rodjendan.get(GregorianCalendar.YEAR)+1 , rodjendan.get(GregorianCalendar.MONTH), rodjendan.get(GregorianCalendar.DAY_OF_MONTH));

		assertEquals("Kad se unese datum rodjenja iz BUDUCNOSTI, metoda ne vraca false", false, instance.proveriRodjendan(rodjendan));
	}

}
