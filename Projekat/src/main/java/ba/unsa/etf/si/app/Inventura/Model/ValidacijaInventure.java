package ba.unsa.etf.si.app.Inventura.Model;

import java.util.Date;

public final class ValidacijaInventure {
	public static boolean validirajDatum(Date datum){
		if(datum==null || datum.compareTo(new Date())>0){
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
	
	public static boolean validirajStanje(int stanje){
		if(stanje<0){
			return false;
		}
		
		return true;
	}

	public static boolean validirajSkladistara(Skladistar skladistar){
		if(skladistar==null){
			return false;
		}
		
		return true;
	}
}
