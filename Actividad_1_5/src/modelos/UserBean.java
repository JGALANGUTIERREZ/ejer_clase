package modelos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="user")
@SessionScoped
public class UserBean {

	private String text = "Hola {0}";
	private String htmlInput = "<input type=\"{0}\" {1} />";
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHtmlInput() {
		return htmlInput;
	}
	public void setHtmlInput(String htmlInput) {
		this.htmlInput = htmlInput;
	}
	
	
}
