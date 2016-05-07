package ba.unsa.etf.si.app.Inventura;

import java.util.Date;

public class Izvjestaj implements java.io.Serializable {
	

	long id;
	int ID;
	String Vrsta="";
	
	String Opis="";
	Date Datum;
	int i=0;
	
	void setID(int id){
		ID=id;
	}
	
	int getID(){
		return ID;
	}

	
	String getVrsta(){
		return Vrsta;
	}
	
	void setVrsta(String v) throws Exception{
		if(v==" ") {
			throw new Exception("Morate postojati tip izvještaja");
		}
		Vrsta=v;
	}
	
	
	void setOpis(String o){	
		Opis=o;
	}
	
	String getOpis(){
		return Opis;
	}

	
	Date getDatum(){
		return Datum;
	}
	
	void setDatum(Date d){
		Datum=d;
	}
	
	public Izvjestaj(){}
	
	public Izvjestaj(String v,String o, Date d) throws Exception
	{
		setID(i);
		setVrsta(v);
		setOpis(o);
		setDatum(d);
		i++;
	}
	
	
	
	
}
