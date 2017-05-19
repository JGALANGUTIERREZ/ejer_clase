package modelos;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import utils.Bundle;
import utils.EnumUtils;



@ManagedBean(name="usuario")
@SessionScoped
public class Usuario {
	private Properties msjs=new Properties();
	
	public enum Aficion{
		MUSICA,VIAJES,CINE,DEPORTE,LECTURA;
		
		@Override
		public String toString(){
			return Bundle.get("msjs", this.name());
		}
	}
	
	public enum Comida{
		CARNES,PESCADOS,PASTA;
		
		@Override
		public String toString(){
			return Bundle.get("msjs", this.name());
		}
	}
	public enum Estado{
		SOLTERO,CASADO,DIVORCIADO,VIUDO,CONPAREJA;
		
		@Override
		public String toString(){
			return Bundle.get("msjs", this.name());
		}
	}
	
	public enum Lenguaje{
		C,CPP,JAVA,PHP,PYTHON,CSHARP;
		
		@Override
		public String toString(){
			return Bundle.get("msjs", this.name());
		}
	}
	
	public enum SO{
		WINDOWS,LINUX,MAC,ANDROID;
		
		@Override
		public String toString(){
			return Bundle.get("msjs", this.name());
		}
	}

	private String nombre;
	private String email;
	private ArrayList<Aficion> aficiones=new ArrayList<Aficion>();
	private boolean fumador=false;
	private SO so=SO.WINDOWS;
	private ArrayList<Comida> comidas=new ArrayList<Comida>();
	private Estado estado;
	private ArrayList<Lenguaje> lenguajes=new ArrayList<Lenguaje>();
	private String comentario;
	private boolean deseoOpinar;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Aficion> getAficiones(){
		return aficiones;
	}
	
	public ArrayList<SelectItem> getAficionesItems(){
		return EnumUtils.getSelectItems(Aficion.values(),"msjs");
	}
	
	public void setAficiones(ArrayList<String> aficiones){
		this.aficiones=EnumUtils.getListaDesdeStrings(aficiones,Aficion.class);
	}
	
	public boolean getFumador(){
		return fumador;
	}
	
	public void setFumador(boolean f){
		fumador=f;
	}
	
	public SelectItem[] getFumadorItems(){
		SelectItem[] items=new SelectItem[2];
		items[0]=new SelectItem(false,Bundle.get("msjs","nofumador" ));
		items[1]=new SelectItem(true,Bundle.get("msjs","fumador" ));
		
		return items;
	}
	
	public SO getSo(){
		return so;
	}
	
	public void setSo(SO so){
		this.so=so;
	}
	
	public ArrayList<SelectItem> getSoItems(){
		return EnumUtils.getSelectItems(SO.values(),"msjs");
	}
	
	public  ArrayList<Comida> getComidas(){
		return comidas;
	}
	
	public void setComidas(ArrayList<String> comidas){
		this.comidas=EnumUtils.getListaDesdeStrings(comidas,Comida.class);
	}
	
	public ArrayList<SelectItem> getComidasItems(){
		return EnumUtils.getSelectItems(Comida.values(),"msjs");
	}
	
	public Estado getEstado(){
		return estado;
	}

	public void setEstado(Estado estado){
		this.estado=estado;
	}
	
	public ArrayList<SelectItem> getEstadoItems(){
		return EnumUtils.getSelectItems(Estado.values(),"msjs");
	}
	
	public ArrayList<Lenguaje> getLenguajes(){
		return lenguajes;
	}
	
	public void setLenguajes(ArrayList<String> lenguajes){
		this.lenguajes=EnumUtils.getListaDesdeStrings(lenguajes, Lenguaje.class);
	}
	
	public ArrayList<SelectItem> getLenguajesItems(){
		return EnumUtils.getSelectItems(Lenguaje.values(),"msjs");
	}
	
	public String getComentario(){
		return comentario;
	}
	
	public void setComentario(String comentario){
		this.comentario=comentario;
	}
	
	public boolean getDeseoOpinar(){
		return deseoOpinar;
	}

	public void setDeseoOpinar(boolean deseoOpinar){
		this.deseoOpinar=deseoOpinar;
	}
	
	
	public String procesar(){
		if(deseoOpinar){
			return "opinion";
		}
		else{
			return "mostrarinformacion";
		}
	}
}
