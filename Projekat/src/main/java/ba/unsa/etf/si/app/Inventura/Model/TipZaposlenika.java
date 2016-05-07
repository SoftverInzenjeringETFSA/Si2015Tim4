package ba.unsa.etf.si.app.Inventura.Model;

public class TipZaposlenika {

	private int id;
	private String ime;
	private Skladistar skladistar;
	private Sef sef;
	private String prezime;
	private String jmbg;
	private String adresa;
	private String brojTel;
	private String email;
	private String korisnickoIme;
	private String lozinka;
	
	
	public TipZaposlenika() 
	{
		// TODO Auto-generated constructor stub
	}
	public TipZaposlenika(String _ime,Skladistar _skladistar, Sef _sef,String _prezime,String _jmbg, String _adresa, String _brojTel, String _email, String _korisnickoIme, String _lozinka)
	{
		setId(0);
		setIme(_ime);
		setPrezime(_prezime);
		setJmbg(_jmbg);
		setSkladistar(_skladistar);
		setSef(_sef);
		setAdresa(_adresa);
		setBrojtel(_brojTel);
		setEmail(_email);
		setKorisnickoime(_korisnickoIme);
		setLozinka(_lozinka);
	}
	public TipZaposlenika(int _id, String _ime, Skladistar _skladistar, Sef _sef,String _prezime,String _jmbg, String _adresa, String _brojTel, String _email, String _korisnickoIme, String _lozinka)
	{
		setId(_id);
		setIme(_ime);
		setPrezime(_prezime);
		setJmbg(_jmbg);
		setSkladistar(_skladistar);
		setSef(_sef);
		setAdresa(_adresa);
		setBrojtel(_brojTel);
		setEmail(_email);
		setKorisnickoime(_korisnickoIme);
		setLozinka(_lozinka);
	}
	
	private void setSkladistar(Skladistar skladistar)
	{
		this.skladistar=skladistar;
	}
	private void setSef(Sef sef)
	{
		this.sef=sef;
	}
	private Skladistar getSkladistar()
	{
		return skladistar;
	}
	private Sef getSef()
	{
		return sef;
	}
	int getId() {
		return id;
	}
	void setId(int id) {
		this.id = id;
	}
	
	String getIme()
	{
		return ime;
	}
	
	void setIme(String ime)
	{
		this.ime=ime;
	}
	String getPrezime()
	{
		return prezime;
	}
	
	void setPrezime(String prezime)
	{
		this.prezime=prezime;
	}
	
	String getJmbg()
	{
		return jmbg;
	}
	void setJmbg(String jmbg)
	{
		this.jmbg=jmbg;
	}
	String getAdresa()
	{
		return adresa;
	}
	void setAdresa(String adresa)
	{
		this.adresa=adresa;
	}
	String getBrojtel()
	{
		return brojTel;
	}
	void setBrojtel(String brojTel)
	{
		this.brojTel=brojTel;
	}
	String getEmail()
	{
		return email;
	}
	void setEmail(String email)
	{
		this.email=email;
	}
	String getKorisnickoime()
	{
		return korisnickoIme;
	}
	void setKorisnickoime(String korisnickoIme)
	{
		this.korisnickoIme=korisnickoIme;
	}
	String getLozinka()
	{
		return lozinka;
	}
	void setLozinka(String lozinka)
	{
		this.lozinka=lozinka;
	}
	public void izmjeniKorisnika(TipZaposlenika novi){
		ime=novi.ime;
		setSkladistar(novi.getSkladistar());
		setSef(novi.getSef());
		prezime=novi.prezime;
		jmbg=novi.jmbg;
		adresa=novi.adresa;
		brojTel=novi.brojTel;
		email=novi.email;
		lozinka=novi.lozinka;
		korisnickoIme=novi.korisnickoIme;
		
	}
}
