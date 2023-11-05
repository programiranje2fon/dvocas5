package zadatak2;

public class ProbaIstorijskiDogadjaj {

	public static void main(String[] args) {
		IstorijskiDogadjaj id = 
				new IstorijskiDogadjaj("Bombardovanje Beograda u II svetskom ratu",
						1941, 4, 6);

		System.out.println("Dogadjaj se desio pre " + id.vratiPreKoliko() + " godina");
		
		System.out.println("Naziv dogadjaja naopako: " + id.vratiNaopako());

	}

}
