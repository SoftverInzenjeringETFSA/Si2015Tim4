package ba.unsa.etf.si.app.Inventura.Model;
import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


@Entity
public class KlasaArtikla implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -618509826704996864L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naziv;
	
	private List<Artikal> artikli;
	public List<Artikal> getArtikli() {
		return artikli;
	}

	public void setArtikli(List<Artikal> artikli) {
		this.artikli = artikli;
	}

	public KlasaArtikla(){}
	
	public KlasaArtikla(String _naziv){
		setNaziv(_naziv);
	}
	
	public KlasaArtikla(long _id, String _naziv){
		setId(_id);
		setNaziv(_naziv);
	}
	
	@Override
	public String toString(){
		return getNaziv();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}
