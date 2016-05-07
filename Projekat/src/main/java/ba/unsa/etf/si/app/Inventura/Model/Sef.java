package ba.unsa.etf.si.app.Inventura.Model;

public class Sef {

	private int id;
	public Sef() 
	{
		setId(0);
	
	}
	public Sef(int _id)
	{
		setId(_id);
	}

	void setId(int id)
	{
		this.id=id;
	}
	int getId()
	{
		return id;
	}
}
