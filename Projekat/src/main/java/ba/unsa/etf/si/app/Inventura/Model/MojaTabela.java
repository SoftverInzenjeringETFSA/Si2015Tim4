package ba.unsa.etf.si.app.Inventura.Model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MojaTabela extends JTable{
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
		
		int broj_reda=objekti.indexOf(objekat);
		
		model.removeRow(broj_reda);
		model.insertRow(broj_reda, red);
	}
	
	public void isprazni(){
		DefaultTableModel model=(DefaultTableModel)getModel();
		
		
		int vel = model.getRowCount();
		/*	for(int i=0;i<vel;i++){
			model.removeRow(i);
		}*/
		objekti.clear();
		model.setRowCount(0);
	}

	public List<Object> getObjekti() {
		return objekti;
	}
	public void setObjekti(List<Object> objekti) {
		this.objekti = objekti;
	}
	
	
}
