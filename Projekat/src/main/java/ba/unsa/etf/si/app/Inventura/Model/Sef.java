package ba.unsa.etf.si.app.Inventura.Model;
import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Sef extends TipZaposlenika implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -689742975237300668L;
	public Sef() 
	{
	
	}
	public Sef(int _id)
	{
		setId(_id);
	}
}
