package ba.unsa.etf.si.app.Inventura;

public class Artikal {
	private int id;
	private String naziv;
	private KlasaArtikla klasa;
	private String barkod;
	private Double cijena;
	private Double kolicina;
	private String mjera;
	
	public Artikal(){}
	
	public Artikal(int _id, String _naziv, KlasaArtikla _klasa, String _barkod, Double _cijena, Double _kolicina, String _mjera) throws Exception {
		setId(_id);
		setNaziv(_naziv);
		setKlasa(_klasa);
		setBarkod(_barkod);
		setCijena(_cijena);
		setMjera(_mjera);
		setKolicina(_kolicina);
	}
	
	public Artikal(String _naziv, KlasaArtikla _klasa, String _barkod, Double _cijena, Double _kolicina, String _mjera) throws Exception {
		setId(0);
		setNaziv(_naziv);
		setKlasa(_klasa);
		setBarkod(_barkod);
		setCijena(_cijena);
		setMjera(_mjera);
		setKolicina(_kolicina);
	}
	
	@Override
	public String toString(){
		return getNaziv();
	}
	
	public void izmjeniArtikal(Artikal novi){
		naziv=novi.naziv;
		setKlasa(novi.getKlasa());
		barkod=novi.barkod;
		cijena=novi.cijena;
		mjera=novi.mjera;
		kolicina=novi.kolicina;
	}

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}

	String getNaziv() {
		return naziv;
	}

	void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	private KlasaArtikla getKlasa() {
		return klasa;
	}

	private void setKlasa(KlasaArtikla klasa) {
		this.klasa = klasa;
	}

	String getBarkod() {
		return barkod;
	}

	void setBarkod(String barkod) {
		this.barkod = barkod;
	}

	Double getCijena() {
		return cijena;
	}

	void setCijena(Double cijena) {
		this.cijena = cijena;
	}

	Double getKolicina() {
		return kolicina;
	}

	void setKolicina(Double kolicina) throws Exception {
		if(this.mjera.toLowerCase()=="komad" && kolicina!=Math.round(kolicina)){
			throw new Exception("Mjerna jedinica artikla je na komad.");
		}
		else if(kolicina<0){
			throw new Exception("Kolicina ne moze biti negativna.");
		}
		this.kolicina = kolicina;
	}

	String getMjera() {
		return mjera;
	}

	void setMjera(String mjera) {
		this.mjera = mjera;
	}

}
