package zadatak2;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IstorijskiDogadjajTest {
	
	IstorijskiDogadjaj instance;

	@Before
	public void setUp() throws Exception {
		instance = new IstorijskiDogadjaj("Oslobadjanje Beograda", 1945, 10, 20);
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}

	@Test (timeout = 2000)
	public void konstruktor_IstorijskiDogadjaj() {
		instance = new IstorijskiDogadjaj("Oslobadjanje Beograda", 1945, 10, 20);
		
		assertEquals("Konstruktor ne postavlja naziv kako treba", "Oslobadjanje Beograda", instance.naziv);
		assertEquals("Konstruktor ne postavlja godinu kako treba", 1945, instance.datum.getYear());
		assertEquals("Konstruktor ne postavlja mesec kako treba", 10, instance.datum.getMonthValue());
		assertEquals("Konstruktor ne postavlja dan kako treba", 20, instance.datum.getDayOfMonth());		
	}
	
	@Test (timeout = 2000)
	public void konstruktor_IstorijskiDogadjaj_NazivNULL() {
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance = new IstorijskiDogadjaj(null, 1945, 10, 20);

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("Za unet NULL naziv NE ispisuje se rec GRESKA na ekranu", ispis.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}
	
	@Test (timeout = 2000)
	public void konstruktor_IstorijskiDogadjaj_NazivPrekratak() {
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance = new IstorijskiDogadjaj("Rat2", 1945, 10, 20);

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("Za unet prekratak naziv NE ispisuje se rec GRESKA na ekranu", ispis.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}

	@Test (timeout = 2000)
	public void konstruktor_IstorijskiDogadjaj_GodinaNegativna() {
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance = new IstorijskiDogadjaj("dogadjaj", -1, 10, 20);

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("Za unetu negativnu godinu NE ispisuje se rec GRESKA na ekranu", ispis.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}
	
	@Test (timeout = 2000)
	public void konstruktor_IstorijskiDogadjaj_MesecNegativan() {
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance = new IstorijskiDogadjaj("dogadjaj", 1945, -10, 20);

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("Za unet negativan mesec NE ispisuje se rec GRESKA na ekranu", ispis.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}
	
	@Test (timeout = 2000)
	public void konstruktor_IstorijskiDogadjaj_DanNegativan() {
		PrintStream pom = System.out;
		try {
			// Otvoren outputstream za redirekciju System.out
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			System.out.flush();
			// Redirekcija
			System.setOut(new PrintStream(buffer));

			instance = new IstorijskiDogadjaj("dogadjaj", 1945, 10, -5);

			System.out.flush();

			// Preuzimanje ispisa metode na ekranu
			String ispis = buffer.toString();

			// Vracanje System.out na staro
			System.setOut(pom);

			assertTrue("Za unet negativan dan NE ispisuje se rec GRESKA na ekranu", ispis.toString().toLowerCase().contains("GRESKA".toLowerCase()));
		} catch (Exception e) {
			System.setOut(pom);
			e.printStackTrace();
		}
	}

	@Test (timeout = 2000)
	public void metoda_vratiPreKoliko() {
		int trenutnaGodina = LocalDateTime.now().getYear();
		
		assertEquals("Za dogadjaj iz 1945 godine, ne vraca da je bio pre "+(trenutnaGodina - 1945)+" godina je bio", 
				trenutnaGodina - 1945, instance.vratiPreKoliko());
	}

	@Test (timeout = 2000)
	public void metoda_vratiNaopako() {
		assertEquals("Metoda ne vraca naziv naopako", "adargoeB ejnajdabolsO", instance.vratiNaopako());
	}

}
