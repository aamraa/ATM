import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Racun extends GlavniIzbornik {
	
	//Atributi
	
	private int brojRacuna;
	private String imeVlasnika;
	protected double trenutnoStanjeRacuna;
	private static int ukupanBrojRacuna;
	
	// baza podataka
	protected static ArrayList<Racun>ListaRacuna = new ArrayList <Racun>(); 
	
	// Konstruktor
	public Racun() {
		ukupanBrojRacuna++;
	}
	
	public Racun(int brojRacuna, String imeValasika, double ukupanIznos) {
		this.brojRacuna=brojRacuna;
		this.imeVlasnika=imeValasika;
		this.trenutnoStanjeRacuna=ukupanIznos;
		ukupanBrojRacuna++;
	}
	//getters and setters 
	
	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getImeVlasnika() {
		return imeVlasnika;
	}

	public void setImeVlasnika(String imeVlasnika) {
		this.imeVlasnika = imeVlasnika;
	}

	public double getTrenutnoStanjeRacuna() {
		return trenutnoStanjeRacuna;
	}

	public void setTrenutnoStanjeRacuna(double trenutnoStanjeRacuna) {
		this.trenutnoStanjeRacuna = trenutnoStanjeRacuna;
	}

	public static int getUkupanBrojRacuna() {
		return ukupanBrojRacuna;
	}

	public static void setUkupanBrojRacuna(int ukupanBrojRacuna) {
		Racun.ukupanBrojRacuna = ukupanBrojRacuna;
	}
	
	//ponasanje
	
	public void povecajBalance(double iznos) {
		this.trenutnoStanjeRacuna += iznos;
	}
	
	public void smanjiBalance(double iznos) {
		this.trenutnoStanjeRacuna -= iznos;
	}
	public static void ispisRacuna(int brojRacuna) {
		for (int i = 0; i < ListaRacuna.size(); i++)
			if (ListaRacuna.get(i).brojRacuna == brojRacuna) {
				System.out.println(ListaRacuna.get(i).toString());
				return;
	}
		System.out.println("Racun nije pronadjen.");
		}
	
	public static void password(String password) {
		
		int brojac = 0;
		boolean unos = true;
		System.out.println("Molimo unesite sifru: ");

		if (password.length() < 8) {
			System.out.println("Greška.Unesite minimalno 8 brojeva.");
		unos = false;
		}
		
		for (int i = 0; i < password.length(); i++) {
			if (!Character.isDigit(password.charAt(i))) {
				System.out.println(
						"Sifra nije tacna, mora sadrzavati samo brojeve.");
			unos = false;
			}
			if (Character.isDigit(password.charAt(i))) {
				brojac++;
			}

		}
		if (brojac > 1 && password.length() > 8) {
			System.out.println("Unjeli ste ispravnu password.");
			unos = true;
		} else {
			System.out.println("Niste unjeli ispravn password.");
			unos = false;
		}		

	}

	@Override
	public String toString() {
		return "\n Broj racuna: " + brojRacuna + "\n Ime: " + imeVlasnika + "\n Trenutno stanje: "
				+ trenutnoStanjeRacuna;
	}

	
	
	
}