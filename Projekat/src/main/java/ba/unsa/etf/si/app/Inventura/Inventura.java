package ba.unsa.etf.si.app.Inventura;

import java.util.Date;

public class Inventura {

	int ID;
	Date Datum;
	String Opis;
	int trenutnoStanje;
	String odgovornoLice;
	
	public Inventura(){}
	public Inventura(int id,Date datum, String opis, int stanje, String osoba)
	{
		ID=id;
		Datum=datum;
		Opis=opis;
		trenutnoStanje=stanje;
		odgovornoLice=osoba;
	}

	public void iskoristiInventuru(Inventura I){
		
		System.out.println("Inventura broj" + I.ID);
		
		}
}
