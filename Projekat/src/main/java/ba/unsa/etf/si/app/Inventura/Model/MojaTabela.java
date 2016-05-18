package ba.unsa.etf.si.app.Inventura.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MojaTabela extends JTable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7845048495337451755L;
	
	private List<Object> objekti;
	
	public MojaTabela(){
		objekti=new ArrayList<Object>();
	}
	
	public MojaTabela(DefaultTableModel model){
		objekti=new ArrayList<Object>();
		this.setModel(model);
	}
	
	public void dodajRed(Object objekat, String[] red){
		DefaultTableModel model=(DefaultTableModel)getModel();
		model.addRow(red);
		
		objekti.add(objekat);
	}
	
	public void obrisiRed(int red){
		DefaultTableModel model=(DefaultTableModel)getModel();
		model.removeRow(red);
		
		objekti.remove(red);
	}
	
	public Object dajRed(int red){
		return objekti.get(red);
	}
	
	public void izmjeniRed(Object objekat, String[] red){
		DefaultTableModel model=(DefaultTableModel)getModel();
		
		int brojReda=objekti.indexOf(objekat);
		
		model.removeRow(brojReda);
		model.insertRow(brojReda, red);
	}
	
	public void isprazni(){
		objekti.clear();
		
		DefaultTableModel model=(DefaultTableModel)getModel();
		while (model.getRowCount()!=0) {
			model.removeRow(0);
		}
	}

	public List<Object> getObjekti() {
		return objekti;
	}
	public void setObjekti(List<Object> objekti) {
		this.objekti = objekti;
	}
	
	
}
