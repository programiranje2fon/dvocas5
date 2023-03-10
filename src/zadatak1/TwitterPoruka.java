package zadatak1;

import java.time.LocalDateTime;

public class TwitterPoruka {

	String korisnik = "nepoznato";
	String poruka = "nepoznato";
	LocalDateTime datum = LocalDateTime.now();

	void postaviKorisnika(String k) {
		if (k != null && !k.equals("nepoznato"))
			korisnik = k;
		else
			System.out.println("GRESKA");
	}

	void postaviPoruku(String p) {
		if (p != null && !p.equals("") && p.length() <= 140)
			poruka = p;
		else
			System.out.println("GRESKA");
	}

	int prebrojHash() {
		int brojac = 0;

		for (int i = 0; i < poruka.length(); i++)
			if (poruka.charAt(i) == '#')
				brojac++;

		return brojac;
	}

	int prebrojReci() {
		String[] reci = poruka.split(" ");
		return reci.length;
	}

	void ispisi() {
		System.out.println("Korisnik: " + korisnik);
		System.out.println("Datum: " + datum);
		System.out.println("Poruka: " + poruka);
	}

	boolean proveriRodjendan(LocalDateTime datumRodjenja) {
		if (datumRodjenja == null || datumRodjenja.isAfter(LocalDateTime.now()))
			return false;

		int mesecRodjenja = datumRodjenja.getMonthValue();
		int danRodjenja = datumRodjenja.getDayOfMonth();

		int mesecPoruke = datum.getMonthValue();
		int danPoruke = datum.getDayOfMonth();

		if (mesecRodjenja == mesecPoruke && danRodjenja == danPoruke)
			return true;
		else
			return false;
	}

}
