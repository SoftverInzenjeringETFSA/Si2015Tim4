package ba.unsa.etf.si.app.Inventura.Model;

public final class ValidacijaStanjaInventure {
	public static boolean validirajStanje(int stanje){
		if(stanje<0){
			return false;
		}
		
		return true;
	}
	
	public static boolean validirajIzvjestaj(Izvjestaj izvjestaj){
		if(izvjestaj==null){
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
