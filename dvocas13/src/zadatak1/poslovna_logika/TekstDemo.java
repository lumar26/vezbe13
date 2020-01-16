package zadatak1.poslovna_logika;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TekstDemo {
	public String ucitajTekst(String filename) throws IOException {
		String text = "", pom = "";
		
		try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
			while ((pom = in.readLine()) != null)
				text = text + pom + "\n";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new FileNotFoundException("Fajl iz koga se ucitava nije nadjen");
		}
		
		return text;
	}
	
	public void upisiTekst(String filename, String text) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(filename));
		out.write(text);
		out.close();
	}
}
