package ba.unsa.etf.si.app.Inventura.Model;

import java.util.regex.Pattern;

public final class ValidacijaZaposlenika {
	public static boolean validirajIme(String ime){
		if(ime==null || ime.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajPrezime(String prezime){
		if(prezime==null || prezime.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajJmbg(String jmbg){
		if(jmbg==null || jmbg.isEmpty()){
			return false;
		}
		
		Pattern pattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])[0-9]{9}$"); 
		if (!pattern.matcher(jmbg).matches()) {
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajAdresu(String adresa){
		if(adresa==null || adresa.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajBrojTel(String brojTel){
		if(brojTel==null || brojTel.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajEmail(String email){
		if(email==null || email.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajKorisnickoIme(String korisnickoIme){
		if(korisnickoIme==null || korisnickoIme.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajLozinku(String lozinka){
		if(lozinka==null || lozinka.length()<10){
			return false;
		}
		
		Pattern pattern1=Pattern.compile("^\\S*[0-9]+\\S*$");
		Pattern pattern2=Pattern.compile("^\\S*[a-zA-Z]+\\S*$");
		
		if(!pattern1.matcher(lozinka).matches() || !pattern2.matcher(lozinka).matches()){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajInventuru(Inventura inventura){
		if(inventura==null){
			return false;
		}
		
		return true;
	}
}
