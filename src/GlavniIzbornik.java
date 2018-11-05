
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class GlavniIzbornik {
	
	public static ArrayList<Racun> ListaRacuna = new ArrayList<Racun>(); // baza podataka
	static boolean running = true;
	static Scanner input = new Scanner(System.in); // skener
	
	public static boolean dostupnost(int ID) {
		for (int i = 0; i < ListaRacuna.size(); i++) {
			if (ListaRacuna.get(i).getBrojRacuna() == ID) {
				System.out.println("Uneseni broj je zauzet, unesite drugi broj.");
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
	
		boolean nastaviUnos = true;
		
		while (running) {
			
				
				System.out.println("      ***DOBRODOSLI***     ");
				System.out.println("   Izaberite neku od sljedecih opcija: ");
				System.out.println("\n 1 Kreirajte racun. \n");
				System.out.println("\n 2. Transfer novca. \n");
				System.out.println("\n 3. Ispis racuna. \n");

				int izbor = input.nextInt();
			
				while (izbor != 1 && izbor != 2 && izbor != 3) {
					System.out.println("Pogresan izbor. Pokusajte ponovo.");
					izbor = input.nextInt();
				}
				switch (izbor) {
				case 1:
					Racun account = new Racun();
					ListaRacuna.add(account);
					System.out.println("Unesite vase ime :");
					input.nextLine();
					String ime = input.nextLine();
					account.setImeVlasnika(ime);
					System.out.println("Unesite broj racuna :");
					do {
						
						try {
							int brojRacuna = input.nextInt();
							input.nextLine();
							nastaviUnos = false;
							while (!dostupnost(brojRacuna)) {
								brojRacuna = input.nextInt();
							}
							account.setBrojRacuna(brojRacuna);
						}catch (InputMismatchException ex) {
							System.out.println("Try again. (" + "Pogresan unos, pokusajete ponovo.)");
							input.nextLine();
						}
					} while (nastaviUnos);
					System.out.println("Unesite sifru :");
					String password = input.nextLine();
					System.out.println("Unesite iznos koji postavljate na racun: ");
					int iznosZaUplatu = input.nextInt();
					account.setTrenutnoStanjeRacuna(iznosZaUplatu);
					System.out.println(ime + "\n  Vas racun je uspjesno kreiran. \n");
					
					break;
					
				case 2:
					Transakcija transakcija = new Transakcija();
					System.out.println("Unesite broj racuna sa kojeg zelite prebaciti novac:: ");
					int sourceBroj = input.nextInt();
					input.nextLine();
					transakcija.setIzvorniRacun(sourceBroj);;
					System.out.println("Unesite broj racuna na koji zelite prebaciti novac: ");
					int targetBroj = input.nextInt();
					input.nextLine();
					transakcija.setTargetRacun(targetBroj);
					System.out.println("Unesite iznos novca koji zelite uplatiti :");
					double novac = input.nextDouble();
					input.nextLine();
					transakcija.setIznosZaPrebacivanje(novac);
					if (transakcija.provjeriValidnost()) {
						transakcija.izvrsiTransakciju();
						System.out.println("Transakcija je uspjesno izvrsena.");
					} else {
						System.out.println("Greska.Transakcija nije uspjesno izvrsena.");
					}

					break;
					
				case 3:
					System.out.println();
					System.out.println("   ***DOBRODOSLI U IZBORNIK ZA ISPIS STANJA TRAZENOG RACUNA***   ");
					System.out.println("Unesite broj racuna :");
					int broj = input.nextInt();
					for (int i = 0; i < ListaRacuna.size(); i++) {
						if (ListaRacuna.get(i).getBrojRacuna() == broj) {
							System.out.println(ListaRacuna.get(i).toString());
							Racun.ispisRacuna(broj);
						}
					}
					break;
				
		default:
			System.out.println("Molimo izaberite jednu od ponudjenih opcija.");
			break;
		
				}
			}
		}
			 
	}

