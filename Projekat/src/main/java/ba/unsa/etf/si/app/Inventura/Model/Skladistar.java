package ba.unsa.etf.si.app.Inventura.Model;

public class Skladistar {

	private int id;
	private int inventuraId;
	
	public Skladistar() {
		// TODO Auto-generated constructor stub
	}
	
	public Skladistar(int _id, int _inventuraId)
	{
		setId(_id);
		setInvId(_inventuraId);
	}
	public Skladistar(int _inventuraId)
	{
		setId(0);
		setInvId(_inventuraId);
	}
	void setId(int id)
	{
		this.id=id;
	}
	void setInvId(int inventuraId)
	{
		this.inventuraId=inventuraId;
	}
	int getId()
	{
		return id;
	}
	int getInvId()
	{
		return inventuraId;
	}

}
