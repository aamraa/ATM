

public class Transakcija extends Racun {
	
	//Atributi
	private int izvorniRacun;
	private int targetRacun;
	private double iznosZaPrebacivanje;
	
	//Konsturktor
	public Transakcija() {

	}
	
	public Transakcija(int izvorniRacun, int targetRacun, double iznosZaPrebacivanje) {
		this.izvorniRacun = izvorniRacun;
		this.targetRacun = targetRacun;
		this.iznosZaPrebacivanje = iznosZaPrebacivanje;
	}
	
	//getters and setters

	public int getIzvorniRacun() {
		return izvorniRacun;
	}

	public void setIzvorniRacun(int izvorniRacun) {
		this.izvorniRacun = izvorniRacun;
	}

	public int getTargetRacun() {
		return targetRacun;
	}

	public void setTargetRacun(int targetRacun) {
		this.targetRacun = targetRacun;
	}

	public double getIznosZaPrebacivanje() {
		return iznosZaPrebacivanje;
	}

	public void setIznosZaPrebacivanje(double iznosZaPrebacivanje) {
		this.iznosZaPrebacivanje = iznosZaPrebacivanje;
	}
	
	//ponasanje

	public boolean provjeriValidnost() {
		boolean izvorniPostoji = false;
		boolean targetPostoji = false;
		boolean dovoljnoNovca = false;
	
		for (int i = 0; i < ListaRacuna.size(); i++) {
			if (ListaRacuna.get(i).getBrojRacuna() == izvorniRacun) {
				izvorniPostoji = true;
				return true;
			}else {
				System.out.println("Ovaj racun ne postoji.");
			}
		}
		
		for (int j = 0; j < ListaRacuna.size(); j++) {
			if (ListaRacuna.get(j).getBrojRacuna() == targetRacun) {
				targetPostoji = true;
				return true;
			}else {
				System.out.println("Ovaj racun ne postoji.");
			}
		}
		
		for (int n = 0; n < ListaRacuna.size(); n++) {
			if ((ListaRacuna.get(n).getTrenutnoStanjeRacuna() - iznosZaPrebacivanje) >= 0) {
				dovoljnoNovca = true;
				return true;
			}else {
				System.out.println("Nema dovoljno novca za transkaciju.");
			}
		}
		
		if (izvorniPostoji && targetPostoji && dovoljnoNovca) {
			return true;
		}

		else
			return false;
}
	public void izvrsiTransakciju() {
		for (int i = 0; i < ListaRacuna.size(); i++) {

			if (ListaRacuna.get(i).getBrojRacuna() == targetRacun)
				ListaRacuna.get(i).trenutnoStanjeRacuna += iznosZaPrebacivanje;
			
			if (ListaRacuna.get(i).getBrojRacuna() == izvorniRacun)
				ListaRacuna.get(i).trenutnoStanjeRacuna -= iznosZaPrebacivanje;

		}

	}
	
}