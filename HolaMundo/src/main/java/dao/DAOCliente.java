package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelos.Cliente;

public class DAOCliente {

	class RowMapperCliente implements RowMapper<Cliente>{
		
		public Cliente mapRow(ResultSet rs,int rowNum) throws SQLException {
			Cliente cliente=new Cliente(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellidos"));
			return cliente;
		}
		
	}

	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Cliente read(int id){
		Cliente c=null;
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		c=jdbc.queryForObject(
				"select * from clientes where id=?",
				new Object[]{new Integer(id)},
				new RowMapperCliente());
		return c;
	}
	
	public List<Cliente> listar(){
		List<Cliente> lista;
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		lista=jdbc.query("select * from clientes",new RowMapperCliente());
		
		return lista;
	}
	
	public List<Cliente> buscar(String palabra){
		List<Cliente> lista;
		
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		
		String c="%"+palabra+"%";
		lista=jdbc.query(
				"select * from clientes where nombre like ?",
				new Object[]{c},
				new RowMapperCliente());
		
		return lista;
	}
	
	
	
	
}
