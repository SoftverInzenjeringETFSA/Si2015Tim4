package ba.unsa.etf.si.app.Inventura;

public class StanjeInventure {

	int stanje;
	Izvjestaj izvjestaj;
	Inventura inventura;
	
	int getStanje(){
		
		return stanje;
	}
	
	void setStanje(int s){
		stanje=s;
	}
	
	Izvjestaj getIzvjestaj(){
		return izvjestaj;
	}
	
	void setIzvjestaj(Izvjestaj i){
		
		izvjestaj=i;
	}
	
	Inventura getInventura(){
		return inventura;
		
	}
	
	void setInventura(Inventura inv){
		inventura=inv;
	}
	
	public StanjeInventure(int s,Izvjestaj i, Inventura inv)
	{
		setStanje(s);
		setIzvjestaj(i);
		setInventura(inv);
	}
	
}
