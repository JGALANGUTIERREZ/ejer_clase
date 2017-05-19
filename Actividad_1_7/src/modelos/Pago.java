package modelos;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pago")
@SessionScoped
public class Pago {

	private double cantidad;
	private double minCantidad;
	private double maxCantidad;
	private String tarjeta;
	private Date fecha;

	public Pago() {
		cantidad = 78888.454646;
		minCantidad = 50.;
		maxCantidad = 10000.;
		tarjeta = "";
		fecha = new Date();
		
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getMinCantidad() {
		return minCantidad;
	}

	public void setMinCantidad(double minCantidad) {
		this.minCantidad = minCantidad;
	}

	public double getMaxCantidad() {
		return maxCantidad;
	}

	public void setMaxCantidad(double maxCantidad) {
		this.maxCantidad = maxCantidad;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
