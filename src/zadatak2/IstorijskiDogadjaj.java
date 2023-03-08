package zadatak2;

import java.time.LocalDate;

public class IstorijskiDogadjaj {
	
	String naziv;
	LocalDate datum;
	
	public IstorijskiDogadjaj(String n, int godina, int mesec, int dan) {
		if (n != null && n.length() >= 5 && godina > 0 && mesec > 0 && dan > 0) {
			naziv = n;
			datum = LocalDate.of(godina, mesec, dan);
		}
		else System.out.println("GRESKA");
	}
	
	int vratiPreKoliko() {
		LocalDate danas = LocalDate.now();
		
		int trenutnaGodina = danas.getYear();
		
		return trenutnaGodina - datum.getYear();		
	}
	
	String vratiNaopako() {
		String naopako = "";
		
		for (int i = naziv.length()-1; i >= 0; i--)
			naopako = naopako + naziv.charAt(i);
		
		return naopako;
	}

}
