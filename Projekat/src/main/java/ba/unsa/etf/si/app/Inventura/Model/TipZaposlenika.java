package ba.unsa.etf.si.app.Inventura.Model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
public class TipZaposlenika implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String ime;
	private String prezime;
	private String jmbg;
	private String adresa;
	private String brojTel;
	private String email;
	private String korisnickoIme;
	private String lozinka;
	private String privilegija;
	
	
	public TipZaposlenika() 
	{
		// TODO Auto-generated constructor stub
	}
	public TipZaposlenika(String _ime,String _prezime,String _jmbg, String _adresa, String _brojTel, String _email, String _korisnickoIme, String _lozinka,String _privilegija)
	{
		setIme(_ime);
		setPrezime(_prezime);
		setJmbg(_jmbg);
		setAdresa(_adresa);
		setBrojtel(_brojTel);
		setEmail(_email);
		setKorisnickoime(_korisnickoIme);
		setLozinka(_lozinka);
		setPrivilegija(_privilegija);
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getIme()
	{
		return ime;
	}
	
	public void setIme(String ime)
	{
		this.ime=ime;
	}
	public String getPrezime()
	{
		return prezime;
	}
	
	public void setPrezime(String prezime)
	{
		this.prezime=prezime;
	}
	
	public String getJmbg()
	{
		return jmbg;
	}
	public void setJmbg(String jmbg)
	{
		this.jmbg=jmbg;
	}
	public String getAdresa()
	{
		return adresa;
	}
	public void setAdresa(String adresa)
	{
		this.adresa=adresa;
	}
	public String getBrojtel()
	{
		return brojTel;
	}
	public void setBrojtel(String brojTel)
	{
		this.brojTel=brojTel;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getKorisnickoime()
	{
		return korisnickoIme;
	}
	public void setKorisnickoime(String korisnickoIme)
	{
		this.korisnickoIme=korisnickoIme;
	}
	public String getLozinka()
	{
		return lozinka;
	}
	public void setLozinka(String lozinka)
	{
		this.lozinka=lozinka;
	}
	public String getPrivilegija()
	{
		return privilegija;
	}
	public void setPrivilegija(String privil)
	{
		privilegija=privil;
	}
	public void izmjeniKorisnika(TipZaposlenika novi){
		ime=novi.ime;
		prezime=novi.prezime;
		jmbg=novi.jmbg;
		adresa=novi.adresa;
		brojTel=novi.brojTel;
		email=novi.email;
		lozinka=novi.lozinka;
		korisnickoIme=novi.korisnickoIme;
		
	}
}
