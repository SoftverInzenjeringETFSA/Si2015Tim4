package ba.unsa.etf.si.app.Inventura;

import java.util.Date;

public class Inventura {

	int ID;
	Date Datum;
	String Opis;
	int trenutnoStanje;
	String odgovornoLice;
	int brojac=0;
	int getID() {
		return ID;
	}

	void setID(int id) {
		ID = id;
	}
	
	Date getDatum(){
		return Datum;
	}
	
	void setDatum(Date d)
	{
		Datum=d;
	}
	
	String getOpis(){
		return Opis;
	}
	
	void setOpis(String s)
	{
		Opis=s;
	}
	
	int gettrenutnoStanje() {
		return trenutnoStanje;
	}

	void settrenutnoStanje(int s) throws Exception {
		if(s<0){
			throw new Exception("Kolicina ne moze biti negativna."); 
	    }
		trenutnoStanje = s;
	}

	String getOdgovornoLice(){
		return odgovornoLice;
	}
	
	void setOdgovornoLice(String o)
	{
		odgovornoLice=o;
	}
	

	
	public Inventura(){}
	public Inventura(int id, Date datum, String opis, int stanje, String osoba) throws Exception
	{
		setID(brojac);
		setDatum(datum);
		setOpis(opis);
		settrenutnoStanje(stanje);
		setOdgovornoLice(osoba);
		brojac++;
	}

	public void iskoristiInventuru(Inventura I){
		
		System.out.println("Inventura broj" + I.ID);
		
		}
}
