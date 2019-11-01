package zadatak1;

import java.util.GregorianCalendar;

public class TwitterPoruka {
	
	String korisnik = "nepoznato";
	String poruka = "nepoznato";
	GregorianCalendar datum = new GregorianCalendar();
	
	void postaviKorisnika (String k) {
		if (k != null && !k.equals("nepoznato"))
			korisnik = k;
		else
			System.out.println("GRESKA");
	}
	
	void postaviPoruku (String p) {
		if (p != null && !p.equals("") && p.length() <= 140)
			poruka = p;
		else
			System.out.println("GRESKA");
	}
	
	int prebrojHash() {
		int brojac = 0;
		
		for(int i=0;i<poruka.length();i++)
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
		System.out.println("Datum: " + datum.getTime());
		System.out.println("Poruka: " + poruka);
	}
	
	boolean proveriRodjendan(GregorianCalendar datumRodjenja) {
		if (datumRodjenja == null || datumRodjenja.after(new GregorianCalendar()))
			return false;
		
		int mesecRodjenja = datumRodjenja.get(GregorianCalendar.MONTH);
		int danRodjenja = datumRodjenja.get(GregorianCalendar.DAY_OF_MONTH);
		
		int mesecPoruke = datum.get(GregorianCalendar.MONTH);
		int danPoruke = datum.get(GregorianCalendar.DAY_OF_MONTH);
		
		if (mesecRodjenja == mesecPoruke && danRodjenja == danPoruke)
			return true;
		else
			return false;
	}

}
