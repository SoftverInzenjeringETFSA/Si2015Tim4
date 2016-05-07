package ba.unsa.etf.si.app.Inventura.Model;


import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
public class StanjeInventure implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	int stanje;
	
    @OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="izvjestaj_id")  
	Izvjestaj izvjestaj;
    
    @OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="inventura_id")  
	Inventura inventura;
	
    public int getStanje(){
		
		return stanje;
	}
	
	public void setStanje(int s){
		stanje=s;
	}
	
	public Izvjestaj getIzvjestaj(){
		return izvjestaj;
	}
	
	public void setIzvjestaj(Izvjestaj i){
		
		izvjestaj=i;
	}
	
	public Inventura getInventura(){
		return inventura;
		
	}
	
	public void setInventura(Inventura inv){
		inventura=inv;
	}
	
	public StanjeInventure(int s,Izvjestaj i, Inventura inv)
	{
		setStanje(s);
		setIzvjestaj(i);
		setInventura(inv);
	}
	
	public StanjeInventure(){
	}
}
