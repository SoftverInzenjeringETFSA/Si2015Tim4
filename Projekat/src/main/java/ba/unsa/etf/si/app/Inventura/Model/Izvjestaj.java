package ba.unsa.etf.si.app.Inventura.Model;

import java.io.Serializable;
import javax.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
public class Izvjestaj implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1196699432522290970L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	String Vrsta="";
	String Opis="";
	Date Datum;
	//private List<Artikal> artikli;
	
	int i=0;
	
	public void setId(int id){
		this.id=id;
	}
	
	public long getId(){
		return id;
	}

	
	public String getVrsta(){
		return Vrsta;
	}
	
	public void setVrsta(String v) throws Exception{
		if(v==" ") {
			throw new Exception("Morate postojati tip izvještaja");
		}
		Vrsta=v;
	}
	
	public void setOpis(String o){	
		Opis=o;
	}
	
	public String getOpis(){
		return Opis;
	}

	
	public Date getDatum(){
		return Datum;
	}
	
	public void setDatum(Date d){
		Datum=d;
	}
	
	public Izvjestaj(){}
	
	public Izvjestaj(String v,String o, Date d) throws Exception
	{
		setVrsta(v);
		setOpis(o);
		setDatum(d);
	}
	
	/*
	public Izvjestaj(String _vrsta,String _opis, Date _datum, List<Artikal> _artikli) throws Exception // novi konstruktor
	{
		setVrsta(_vrsta);
		setOpis(_opis);
		setDatum(_datum);
		setArtikli(_artikli);
	}
	*/
	
	@Override
	public String toString(){
		return "Izvještaj: "+getVrsta()+" "+getDatum().toString();
	}

	/*
	public List<Artikal> getArtikli() {
		return artikli;
	}
	

	public void setArtikli(List<Artikal> artikli) {
		this.artikli = artikli;
	}
	*/
	
}
