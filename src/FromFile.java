import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FromFile {
	
		public static ArrayList<Racun> readFromFile() {
		ArrayList<Racun> ListaRacuna = new ArrayList<Racun>();
		
		String imeFile = "accounts.exe";
		String line = null;
		System.out.println();

		try {
			
			BufferedReader buffered = new BufferedReader
					(new FileReader(new File("accounts.exe")));
			
			while ((line = buffered.readLine()) != null) {
				String[] info = line.split(" ");
				Racun  account = new Racun();
				 account.setBrojRacuna((Integer.parseInt(info[0])));
				 account.setImeVlasnika(info[1]);
				 account.setTrenutnoStanjeRacuna(Double.parseDouble(info[2]));
				 ListaRacuna.add(account);
			}
			buffered.close();
			
		} catch (FileNotFoundException ex) {
			System.out.println(imeFile + " file se ne moze otvoriti.  ");
		} catch (IOException ex) {
			System.out.println("Greska '" + imeFile + " ");

		}
		return  ListaRacuna;
	}
}
