package utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import modelos.Usuario.Aficion;




public class EnumUtils{

	public static <T extends Enum>  ArrayList<SelectItem> getSelectItems(T[] valores,String bundle){
		FacesContext context = FacesContext.getCurrentInstance();
	    ResourceBundle bndl = context.getApplication().evaluateExpressionGet(context, "#{"+bundle+"}", ResourceBundle.class);
	    
	    ArrayList<SelectItem> items=new ArrayList<SelectItem>();
		for(T a : valores){
			String label=bndl.getString(a.name());
			items.add(new SelectItem(a.name(),label));
		}
		
		return items;
	}
	
	public static <T extends Enum> ArrayList<T> getListaDesdeStrings(ArrayList<String> s,Class<T> c){
		ArrayList<T> lista=new ArrayList<T>();
		
		for(String v:s){
			T vv=(T)Enum.valueOf(c,v);
			lista.add(vv);
		}
		
		return lista;
	}
	
	
}
