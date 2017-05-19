package dao;

import javax.sql.DataSource;
import modelos.Cliente;


public class DAOCliente {

	
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		System.out.println(dataSource);
		this.dataSource = dataSource;
	}
	
	public Cliente read(int id){
		Cliente c=null;
		System.out.println(dataSource);
		
		return c;
	}
	
	
}
