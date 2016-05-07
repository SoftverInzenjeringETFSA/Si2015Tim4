package ba.unsa.etf.si.app.Inventura.Model;

public class KlasaArtikla {
	private int id;
	private String naziv;
	
	public KlasaArtikla(){}
	
	public KlasaArtikla(String _naziv){
		setId(0);
		setNaziv(_naziv);
	}
	
	public KlasaArtikla(int _id, String _naziv){
		setId(_id);
		setNaziv(_naziv);
	}
	
	@Override
	public String toString(){
		return getNaziv();
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
}
