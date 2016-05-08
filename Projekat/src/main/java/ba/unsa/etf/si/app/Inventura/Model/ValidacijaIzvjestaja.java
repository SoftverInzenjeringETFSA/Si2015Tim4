package ba.unsa.etf.si.app.Inventura.Model;

import java.util.Date;

public final class ValidacijaIzvjestaja {
	public static boolean validirajVrstu(String vrsta){
		if(vrsta==null || vrsta.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajOpis(String opis){
		if(opis==null || opis.isEmpty()){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajDatum(Date datum){
		if(datum==null || datum.compareTo(new Date())>0){
			return false;
		}
		
		return true;
	}
}
