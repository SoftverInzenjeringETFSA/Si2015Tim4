package ba.unsa.etf.si.app.Inventura.Model;

import java.io.Serializable;
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
	Double trenutnoStanje;
	@OneToOne
    @JoinColumn(name="skladistar_id") 
	TipZaposlenika skladistar;
	
	public Inventura(){}
	
	public Inventura(Date datum, String opis, Double trenutnoStanje, TipZaposlenika osoba)
	{
		setDatum(datum);
		setOpis(opis);
		settrenutnoStanje(trenutnoStanje);
		setSkladistar(osoba);
	}
	
	public Inventura(Date datum, String opis, TipZaposlenika osoba)
	{
		setDatum(datum);
		setOpis(opis);
		setSkladistar(osoba);		
	}
	
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
	
	public Double gettrenutnoStanje() {
		return trenutnoStanje;
	}

	public void settrenutnoStanje(Double s){
		trenutnoStanje = s;
	}

	public TipZaposlenika getSkladistar(){
		return skladistar;
	}
	
	public void setSkladistar(TipZaposlenika o)
	{
		skladistar=o;
	}
	
	public void iskoristiInventuru(Inventura I)
	{
		System.out.println("Inventura broj" + I.id);
	}
	
	@Override
	public String toString(){
		return "Inventura: "+getDatum().toString();
	}

}
