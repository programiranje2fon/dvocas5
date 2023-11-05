package zadatak2;

import java.time.LocalDateTime;

public class IstorijskiDogadjaj {

	String naziv;
	LocalDateTime datum;

	public IstorijskiDogadjaj(String n, int godina, int mesec, int dan) {
		if (n != null && n.length() >= 5 && godina > 0 && mesec > 0 && dan > 0) {
			naziv = n;
			datum = LocalDateTime.of(godina, mesec, dan, 0, 0, 0);
		} else
			System.out.println("GRESKA");
	}

	int vratiPreKoliko() {
		LocalDateTime danas = LocalDateTime.now();

		int trenutnaGodina = danas.getYear();

		return trenutnaGodina - datum.getYear();
	}

	String vratiNaopako() {
		String naopako = "";

		for (int i = naziv.length() - 1; i >= 0; i--)
			naopako = naopako + naziv.charAt(i);

		return naopako;
	}

}
