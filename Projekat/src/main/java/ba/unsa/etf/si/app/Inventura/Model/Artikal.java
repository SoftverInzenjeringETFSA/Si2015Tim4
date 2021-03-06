 package ba.unsa.etf.si.app.Inventura.Model;
import java.io.Serializable;
//import java.util.*;

import javax.persistence.*;


@Entity
public class Artikal implements Serializable {
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 2735917613496475984L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naziv;
	
	   
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private KlasaArtikla klasa;
	private String barkod;
	private Double cijena;
	private Double kolicina;
	private String mjera;
	
	public Artikal(){}
	
	public Artikal(long _id, String _naziv, KlasaArtikla _klasa, String _barkod, Double _cijena, Double _kolicina, String _mjera) {
		setId(_id);
		setNaziv(_naziv);
		setKlasaArtikla(_klasa);
		setBarkod(_barkod);
		setCijena(_cijena);
		setMjera(_mjera);
		setKolicina(_kolicina);
	}
	

	public Artikal(String _naziv, KlasaArtikla _klasa, String _barkod, Double _cijena, Double _kolicina, String _mjera) {
		setNaziv(_naziv);
		setKlasaArtikla(_klasa);
		setBarkod(_barkod);
		setCijena(_cijena);
		setMjera(_mjera);
		setKolicina(_kolicina);
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
	
	public KlasaArtikla getKlasaArtikla() {
		return klasa;
	}
	public void setKlasaArtikla(KlasaArtikla klasa) {
		this.klasa = klasa;
	}

	public String getBarkod() {
		return barkod;
	}
	public void setBarkod(String barkod) {
		this.barkod = barkod;
	}

	public Double getCijena() {
		return cijena;
	}
	public void setCijena(Double cijena) {
		this.cijena = cijena;
	}

	public Double getKolicina() {
		return kolicina;
	}
	public void setKolicina(Double kolicina) {
		this.kolicina = kolicina;
	}

	public String getMjera() {
		return mjera;
	}
	public void setMjera(String mjera) {
		this.mjera = mjera;
	}

}
