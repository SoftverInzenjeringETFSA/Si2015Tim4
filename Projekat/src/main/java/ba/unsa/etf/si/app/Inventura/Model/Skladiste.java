package ba.unsa.etf.si.app.Inventura.Model;

import java.util.ArrayList;
import java.util.List;


import java.io.Serializable;
//import java.util.*;

import javax.persistence.*;



@Entity
public class Skladiste implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1980505334179949986L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@OneToMany(cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval=true)
	private List<Artikal> artikli= new ArrayList<Artikal>();
	private String naziv;
	private String lokacija;

	
	
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "sef_id")
	private TipZaposlenika sef;
	
	public TipZaposlenika getSef() {
		return sef;
	}

	public void setSef(TipZaposlenika sef) {
		this.sef = sef;
	}
	
	
	@OneToMany(cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval=true)
	private List<TipZaposlenika> skladistari=new ArrayList<TipZaposlenika>();

	public List<TipZaposlenika> getSkladistari() {
		return skladistari;
	}

	public void setSkladistari(List<TipZaposlenika> skladistari) {
		this.skladistari = skladistari;
	}

	public Skladiste(){
		artikli=new ArrayList<Artikal>();
	}
	
	public Skladiste(String _naziv, String _lokacija,TipZaposlenika sef){
		setNaziv(_naziv);
		setLokacija(_lokacija);
		setSef(sef);
	
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
