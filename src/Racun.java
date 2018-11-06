

public class Racun extends GlavniIzbornik {
	
	//Atributi
	
	private int brojRacuna;
	private String imeVlasnika;
	protected double trenutnoStanjeRacuna;
	private static int ukupanBrojRacuna;
	
	
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
	
	
	@Override
	public String toString() {
		return "\n Broj racuna: " + brojRacuna + "\n Ime: " + imeVlasnika + "\n Trenutno stanje: "
				+ trenutnoStanjeRacuna;
	}

	
	
	
}