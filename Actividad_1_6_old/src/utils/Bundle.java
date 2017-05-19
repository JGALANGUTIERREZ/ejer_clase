package utils;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class Bundle {

	public static String get(String bundle,String key){
		FacesContext context = FacesContext.getCurrentInstance();
	    ResourceBundle bndl = context.getApplication().evaluateExpressionGet(context, "#{"+bundle+"}", ResourceBundle.class);
	    return bndl.getString(key);
	}
}
