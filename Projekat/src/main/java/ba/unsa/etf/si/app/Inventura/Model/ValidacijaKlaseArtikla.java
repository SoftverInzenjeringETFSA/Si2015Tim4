package ba.unsa.etf.si.app.Inventura.Model;

public final class ValidacijaKlaseArtikla {
	public static boolean validirajNaziv(String naziv){
		if(naziv==null || naziv.isEmpty()){
			return false;
		}
		
		return true;
	}
}
