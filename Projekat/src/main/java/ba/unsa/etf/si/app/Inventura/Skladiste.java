package ba.unsa.etf.si.app.Inventura;

import java.util.ArrayList;
import java.util.List;

public class Skladiste {
	private List<Artikal> artikli;
	private String naziv;
	private String lokacija;

	public Skladiste(){
		artikli=new ArrayList<Artikal>();
	}
	
	public Skladiste(String _naziv, String _lokacija){
		setNaziv(_naziv);
		setLokacija(_lokacija);
		artikli=new ArrayList<Artikal>();
	}
	
	public Skladiste(String _naziv, String _lokacija, List<Artikal> _artikli){
		setNaziv(_naziv);
		setLokacija(_lokacija);
		setArtikli(_artikli);
	}
	
	List<Artikal> getArtikli() {
		return artikli;
	}
	void setArtikli(List<Artikal> artikli) {
		this.artikli = artikli;
	}

	String getNaziv() {
		return naziv;
	}

	void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	String getLokacija() {
		return lokacija;
	}

	void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}

}
