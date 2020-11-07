package zadatak2;

import java.util.GregorianCalendar;

public class IstorijskiDogadjaj {
	
	String naziv;
	GregorianCalendar datum;
	
	public IstorijskiDogadjaj(String n, int godina, int mesec, int dan) {
		if (n != null && n.length() >= 5 && godina > 0 && mesec > 0 && dan > 0) {
			naziv = n;
			datum = new GregorianCalendar();
			datum.set(godina, mesec-1, dan);
		}
		else System.out.println("GRESKA");
	}
	
	int vratiPreKoliko() {
		GregorianCalendar danas = new GregorianCalendar();
		
		int trenutnaGodina = danas.get(GregorianCalendar.YEAR);
		
		return trenutnaGodina - datum.get(GregorianCalendar.YEAR);			
	}
	
	String vratiNaopako() {
		String naopako = "";
		
		for (int i = naziv.length()-1; i >= 0; i--)
			naopako = naopako + naziv.charAt(i);
		
		return naopako;
	}

}
