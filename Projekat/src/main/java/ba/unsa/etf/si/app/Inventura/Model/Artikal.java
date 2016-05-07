 package ba.unsa.etf.si.app.Inventura.Model;
import java.io.Serializable;
import java.util.*;

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
	
    @OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="klasaArtikla_id")  
	private KlasaArtikla klasa;
	private String barkod;
	private Double cijena;
	private Double kolicina;
	private String mjera;
	
	public Artikal(){}
	
	public Artikal(int _id, String _naziv, KlasaArtikla _klasa, String _barkod, Double _cijena, Double _kolicina, String _mjera) throws Exception {
		setId(_id);
		setNaziv(_naziv);
		setKlasaArtikla(_klasa);
		setBarkod(_barkod);
		setCijena(_cijena);
		setMjera(_mjera);
		setKolicina(_kolicina);
	}
	
	public Artikal(String _naziv, KlasaArtikla _klasa, String _barkod, Double _cijena, Double _kolicina, String _mjera) throws Exception {
		setId(0);
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

	public void setId(int id) {
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

	public void setKolicina(Double kolicina) throws Exception {
		if(this.mjera.toLowerCase()=="komad" && kolicina!=Math.round(kolicina)){
			throw new Exception("Mjerna jedinica artikla je na komad.");
		}
		else if(kolicina<0){
			throw new Exception("Kolicina ne moze biti negativna.");
		}
		this.kolicina = kolicina;
	}

	public String getMjera() {
		return mjera;
	}

	public void setMjera(String mjera) {
		this.mjera = mjera;
	}

}
