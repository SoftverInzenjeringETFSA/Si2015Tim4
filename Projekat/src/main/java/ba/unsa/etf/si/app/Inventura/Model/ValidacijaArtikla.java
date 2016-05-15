package ba.unsa.etf.si.app.Inventura.Model;

public final class ValidacijaArtikla {
	
	public static boolean validirajNaziv(String naziv){
		if(naziv==null || naziv.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajBarkod(String barkod){
		if(barkod==null || barkod.length()!=13){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajKlasu(KlasaArtikla klasa){
		if(klasa==null){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajMjeru(String mjera){
		if(mjera==null){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajCijenu(String txt_cijena){
		if(txt_cijena==null){
			return false;
		}
		
		try{
			Double cijena=Double.parseDouble(txt_cijena);
			if(cijena<0){
				return false;
			}
		}
		catch(NumberFormatException i){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajKolicinu(String txt_kolicina,  String mjera){
		if(txt_kolicina==null || !validirajMjeru(mjera)){
			return false;
		}
		
		try{
			Double kolicina=Double.parseDouble(txt_kolicina);
			if(kolicina<0){   //mjera==Math.floor(kom) &&
				return false;
			}
		}
		catch(NumberFormatException i){
			return false;
		}
		
		return true;
	}
}
