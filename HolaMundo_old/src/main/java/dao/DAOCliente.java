package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.Cliente;

public class DAOCliente {


	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Cliente read(int id){
		Cliente c=null;
		
		JdbcTemplate jdbc= new JdbcTemplate();
		c=jdbc.queryForObject(
				"select * from clientes where id=?",
				new Object[]{new Integer(id)},
				new RowMapper<Cliente>(){
					public Cliente mapRow(ResultSet rs, int rowNum)throws SQLException{
						Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nombre"),rs.getString("apellidos"));
						return cliente;
					}
				}
				);
		return c;
	}
}
