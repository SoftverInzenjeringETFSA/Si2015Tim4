package ba.unsa.etf.si.app.Inventura.Kontroleri;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import ba.unsa.etf.si.app.Inventura.Model.Izvjestaj;

public final class PostaviListBox {
	public static void dokumentiViska(JList list){
		List<Izvjestaj> tmp = IzvjestajKontroler.lista();
		
		List<Izvjestaj> visak=new ArrayList<Izvjestaj>();
		
		for(Izvjestaj i:tmp){
			if(i.getVrsta()=="Visak"){
				visak.add(i);
			}
		}
		
		DefaultListModel listModel=new DefaultListModel();
		for(Izvjestaj i:visak){
			listModel.addElement(i);
		}
		list.setModel(listModel);
	}
	
	public static void dokumentiManjka(JList list){
		List<Izvjestaj> tmp = IzvjestajKontroler.lista();
		
		List<Izvjestaj> manjak=new ArrayList<Izvjestaj>();
		
		for(Izvjestaj i:tmp){
			if(i.getVrsta()=="Manjak"){
				manjak.add(i);
			}
		}
		
		DefaultListModel listModel=new DefaultListModel();
		for(Izvjestaj i:manjak){
			listModel.addElement(i);
		}
		list.setModel(listModel);
	}
	
	public static void dokumentiOtpisa(JList list){
		List<Izvjestaj> tmp = IzvjestajKontroler.lista();
		
		List<Izvjestaj> otpis=new ArrayList<Izvjestaj>();
		
		for(Izvjestaj i:tmp){
			if(i.getVrsta()=="Otpis"){
				otpis.add(i);
			}
		}
		
		DefaultListModel listModel=new DefaultListModel();
		for(Izvjestaj i:otpis){
			listModel.addElement(i);
		}
		list.setModel(listModel);
	}
	
	public static void dokumentiIzlaza(JList list){
		List<Izvjestaj> tmp = IzvjestajKontroler.lista();
		
		List<Izvjestaj> izlaz=new ArrayList<Izvjestaj>();
		
		for(Izvjestaj i:tmp){
			if(i.getVrsta()=="Izlaz"){
				izlaz.add(i);
			}
		}
		
		DefaultListModel listModel=new DefaultListModel();
		for(Izvjestaj i:izlaz){
			listModel.addElement(i);
		}
		list.setModel(listModel);
	}
}
