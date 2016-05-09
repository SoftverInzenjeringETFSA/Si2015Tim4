package ba.unsa.etf.si.app.Inventura.Model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import java.util.Date;


@Entity
public class Inventura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 109277892540249923L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	Date datum;
	String opis;
	int trenutnoStanje;
	@OneToOne
    @JoinColumn(name="skladistar_id") 
	Skladistar skladistar;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDatum(){
		return datum;
	}
	
	public void setDatum(Date d)
	{
		datum=d;
	}
	
	public String getOpis(){
		return opis;
	}
	
	public void setOpis(String s)
	{
		opis=s;
	}
	
	public int gettrenutnoStanje() {
		return trenutnoStanje;
	}

	public void settrenutnoStanje(int s) throws Exception {
		if(s<0){
			throw new Exception("Kolicina ne moze biti negativna."); 
	    }
		trenutnoStanje = s;
	}

	public Skladistar getSkladistar(){
		return skladistar;
	}
	
	public void setSkladistar(Skladistar o)
	{
		skladistar=o;
	}
	

	
	public Inventura(){}
	public Inventura(long id, Date datum, String opis, int stanje, Skladistar osoba) throws Exception
	{
		setId(id);
		setDatum(datum);
		setOpis(opis);
		settrenutnoStanje(stanje);
		setSkladistar(osoba);
	}

	public void iskoristiInventuru(Inventura I){
		
		System.out.println("Inventura broj" + I.id);
		
		}
	
	@Override
	public String toString(){
		return opis;
	}
}
