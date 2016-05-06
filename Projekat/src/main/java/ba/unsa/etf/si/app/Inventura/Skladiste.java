package ba.unsa.etf.si.app.Inventura;

import java.util.HashMap;
import java.util.Map;

public class Skladiste {
	private Map<Artikal, Double> lista;
	
	public Skladiste(){
		lista=new HashMap<Artikal, Double>();
	}
	
	public Skladiste(Map<Artikal, Double> _lista){
		setLista(_lista);
	}

	Map<Artikal, Double> getLista() {
		return lista;
	}
	void setLista(Map<Artikal, Double> lista) {
		this.lista = lista;
	}
}
