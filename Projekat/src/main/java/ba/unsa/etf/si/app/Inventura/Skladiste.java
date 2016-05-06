package ba.unsa.etf.si.app.Inventura;

import java.util.ArrayList;
import java.util.List;

public class Skladiste {
	private List<Artikal> artikli;

	public Skladiste(){
		artikli=new ArrayList<Artikal>();
	}
	
	public Skladiste(List<Artikal> _artikli){
		setArtikli(_artikli);
	}
	
	List<Artikal> getArtikli() {
		return artikli;
	}
	void setArtikli(List<Artikal> artikli) {
		this.artikli = artikli;
	}

}
