package ba.unsa.etf.si.app.Inventura.Model;


import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Skladistar extends TipZaposlenika implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3139103661356529498L;
	
	@OneToOne
    @JoinColumn(name="inventura_id") 
	private Inventura inventura;
	
	public Skladistar() {
		// TODO Auto-generated constructor stub
	}
	
	public Skladistar(long _id, Inventura inventura)
	{
		setId(_id);
		setInventura(inventura);
	}
	public Skladistar(Inventura inventura)
	{
		setInventura(inventura);
	}

	public void setInventura(Inventura inventura)
	{
		this.inventura=inventura;
	}

	public Inventura getInventura()
	{
		return inventura;
	}

}
