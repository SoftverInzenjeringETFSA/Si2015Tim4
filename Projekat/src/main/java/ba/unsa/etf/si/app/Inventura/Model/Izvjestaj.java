package ba.unsa.etf.si.app.Inventura.Model;

import java.io.Serializable;
import javax.persistence.*;


import java.util.Date;

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
	
	
	Double i=(double) 0;
	
	public void setId(int id){
		this.id=id;
	}
	
	public long getId(){
		return id;
	}
	
	public void setI(Double i){
		this.i=i;
	}
	
	public Double getI(){
		return i;
	}

	
	public String getVrsta(){
		return Vrsta;
	}
	
	public void setVrsta(String v){
		
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
	
	public Izvjestaj(String v,String o, Date d, Double i)
	{
		setVrsta(v);
		setOpis(o);
		setDatum(d);
		setI(i);
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
