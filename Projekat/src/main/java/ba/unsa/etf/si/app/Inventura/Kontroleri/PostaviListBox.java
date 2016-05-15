package ba.unsa.etf.si.app.Inventura.Kontroleri;
import ba.unsa.etf.si.app.Inventura.Kontroleri.HibernateUtil;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ba.unsa.etf.si.app.Inventura.Model.Artikal;
import ba.unsa.etf.si.app.Inventura.Model.Inventura;
import ba.unsa.etf.si.app.Inventura.Model.Izvjestaj;
import ba.unsa.etf.si.app.Inventura.Model.TipZaposlenika;

public final class PostaviListBox {
	
	public static void dokumentiViska(JTable tabela){
		List<Izvjestaj> izvjestaji = IzvjestajKontroler.lista();
		
		DefaultTableModel model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Vrsta", "Datum", "Opis"
				}
			);
		
		for(Izvjestaj i:izvjestaji){
			if(i.getVrsta().equals("Visak")){
				String[] red=new String[]{i.getVrsta(),i.getDatum().toString(),i.getOpis()};
				
				model.addRow(red);
			}
		}
		
		tabela.setModel(model);
	}
	
	public static void dokumentiManjka(JTable tabela){
		List<Izvjestaj> izvjestaji = IzvjestajKontroler.lista();
		
		DefaultTableModel model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Vrsta", "Datum", "Opis"
				}
			);
		
		for(Izvjestaj i:izvjestaji){
			if(i.getVrsta().equals("Manjak")){
				String[] red=new String[]{i.getVrsta(),i.getDatum().toString(),i.getOpis()};
				
				model.addRow(red);
			}
		}
		
		tabela.setModel(model);
	}
	
	public static void dokumentiOtpisa(JTable tabela){
		List<Izvjestaj> izvjestaji = IzvjestajKontroler.lista();
		
		DefaultTableModel model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Vrsta", "Datum", "Opis"
				}
			);
		
		for(Izvjestaj i:izvjestaji){
			if(i.getVrsta().equals("Otpis")){
				String[] red=new String[]{i.getVrsta(),i.getDatum().toString(),i.getOpis()};
				
				model.addRow(red);
			}
		}
		
		tabela.setModel(model);
	}
	
	public static void dokumentiIzlaza(JTable tabela){
		List<Izvjestaj> izvjestaji = IzvjestajKontroler.lista();
		
		DefaultTableModel model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Vrsta", "Datum", "Opis"
				}
			);
		
		for(Izvjestaj i:izvjestaji){
			if(i.getVrsta().equals("Izlaz")){
				String[] red=new String[]{i.getVrsta(),i.getDatum().toString(),i.getOpis()};
				
				model.addRow(red);
			}
		}
		
		tabela.setModel(model);
	}
	
	public static void dokumentiInventure(JTable tabela){
		List<Inventura> inventure = InventuraKontroler.lista();
		
		DefaultTableModel model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Datum", "Opis", "Stanje"
				}
			);
		
		for(Inventura i:inventure){
			String[] red=new String[]{i.getDatum().toString(), i.getOpis(), Double.toString(i.gettrenutnoStanje())};
			
			model.addRow(red);
		}
		
		tabela.setModel(model);
	}
	
	
	public static void artikliNaSkladistu(JTable tabela){
		List<Artikal> artikli = ArtikliKontroler.lista();
		
		DefaultTableModel model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Naziv", "Barkod", "Klasa", "Kolicina", "Cijena", "Mjera"
				}
			);
		
		for(Artikal a:artikli){
			String[] red=new String[]{a.getNaziv(), a.getBarkod(), a.getKlasaArtikla().toString(), a.getKolicina().toString(),
									  a.getCijena().toString(), a.getMjera()};
			
			model.addRow(red);
		}
		
		tabela.setModel(model);
	}
	
	public static void prikaziZaposlenike(JTable tabela){
		List<TipZaposlenika> zaposlenici = TipZaposlenikaKontroler.lista();
		
		DefaultTableModel model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Ime", "Prezime", "Korisnicko ime", "Broj telefona", "Funkcija"
				}
			);
		
		for(TipZaposlenika z:zaposlenici){
			String[] red=new String[]{z.getIme(), z.getPrezime(), z.getKorisnickoime(), z.getBrojtel(),z.getPrivilegija()
			};
			model.addRow(red);
		}
		
		tabela.setModel(model);
	}
}
