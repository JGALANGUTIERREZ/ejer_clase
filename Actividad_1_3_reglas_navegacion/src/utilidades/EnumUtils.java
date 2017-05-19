package utilidades;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public class EnumUtils {

	
	public static <T extends Enum> ArrayList<SelectItem> getSelectItems(T[] valores,String bundle){
		FacesContext context=FacesContext.getCurrentInstance();
		ResourceBundle bndl=context.getApplication().evaluateExpressionGet(context,"#{"+bundle+"}", ResourceBundle.class);
		
		ArrayList<SelectItem> lista=new ArrayList<SelectItem>();
		
		for(T c : valores){
			lista.add(new SelectItem(c.name(),bndl.getString(c.name())));
		}
		
		
		return lista;
	}
}
