# Laboratorijske vežbe – dvočas br. 5

## Zadatak 1
(radi ga laborant u saradnji sa studentima)

Napraviti klasu **TwitterPoruka** u paketu **zadatak1** koja ima:

1. Atribut **korisnik** koji predstavlja korisničko ime osobe koja je napisala poruku. Početna vrednost je reč "nepoznato".

2. Atribut **poruka** koji predstavlja poruku koju je korisnik napisao. Početna vrednost je reč "nepoznato".

3. Atribut **vreme** koji predstavlja datum i vreme kad je poruka objavljena. Početna vrednost je trenutni datum i vreme.

4. Metodu **postaviKorisnika** koja kao parametar prima korisničko ime i postavlja atribut korisnik na unetu vrednost samo ako je uneto korisničko ime različito od null i reči "nepoznato". U suprotnom, metoda ispisuje reč "GRESKA" na ekranu.

5. Metodu **postaviPoruku** koja kao parametar prima tekst poruke i postavlja atribut poruka na unetu vrednost ako je uneta poruka različita od null, nije prazan String i dužine je do 140 znakova. U suprotnom, metoda ispisuje reč "GRESKA" na ekranu. 

6. Metodu **prebrojHash** koja prebrojava i vraća koliko ima heš tagova (hash tag) u tekstu poruke. Svaki heš tag počinje znakom #, pri čemu posle tog znaka ne sme da ide znak blanko. 

7. Metodu **prebrojReci** koja prebrojava i vraća koliko ima reči u tekstu poruke. Smatrati da se između svake dve reči nalazi blanko znak.

8. Metodu **ispisi** koja na ekranu ispisuje korisnika, poruku i vreme poruke uz odgovarajući tekst. 

9. Metodu **proveriRodjendan** koja kao parametar prima datum rođenja korisnika (GregorianCalendar). Metoda prvo proverava da li je uneti različit od null i da li se odnosi na neki trenutak u prošlosti. Ako je tako, metoda proverava da li je korisnik ovu Twitter poruku napisao na svoj rođendan. Ako jeste, metoda vraća true, a u svim ostalim situacijama metoda vraća false.

Napraviti klasu **ProbaTwitterPoruka** u paketu **zadatak1** koja u main metodi pravi jedan objekat klase TwitterPoruka i postavlja da je korisnik "pera121", a da je poruka "Ovo je #moja prva #poruka". Ispisati sve podatke o poruci, kao i koliko ima reči i heš tagova u njoj. Onda napraviti GregorianCalendar sa datumom 27.10.2001. i proveriti da li je korisnik napisao poruku na svoj rođendan.


## Zadatak 2
(rade ga studenti sami)

Napraviti klasu **IstorijskiDogadjaj** u paketu **zadatak2** koja ima:

1. Atribut **naziv** koji je tipa String.

2. Atribut **datum** koji je tipa GregorianCalendar.

3. Konstruktor koji prima četiri parametra: String i tri cela broja. Prvi parametar predstavlja naziv događaja dok naredna tri predstavljaju godinu, mesec i dan kada se događaj odigrao. Ovaj konstruktor postavlja vrednosti odgovarajućih atributa klase i to samo ako je uneti naziv događaja različit od null i dužine bar 5 znakova, i ako su svi uneti brojevi veći od nule. Ako to nije slučaj, konstruktor ispisuje reč "GRESKA" na ekranu.

4. Metodu **vratiPreKoliko** koja kao povratnu vrednost vraća pre koliko godina se desio taj istorijski događaj (u odnosu na trenutnu godinu).

5. Metodu **vratiNaopako** koja vraća String sa nazivom istorijskog događaja, ali tako da slova budu u obrnutom redosledu.

Napraviti klasu **ProbaIstorijskiDogadjaj** u paketu **zadatak2** koja u main metodi kreira objekat klase IstorijskiDogadjaj: "Bombardovanje Beograda u II svetskom ratu", datuma 6.4.1941. Potrebno je ispisati na ekranu pre koliko godina se desio taj događaj, kao i naziv događaja ali tako da slova budu ispisana u obrnutom redosledu.
