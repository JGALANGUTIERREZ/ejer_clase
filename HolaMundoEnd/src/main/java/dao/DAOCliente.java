package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import modelo.Cliente;

public class DAOCliente {
	
/*class RowMapperClient implemnts RowMapper<cliente>{
	
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException{
		Cliente cliente=new Cliente(rs.getInt("id"), rs.getString("nombre"),rs.getString("apellidos"));
		
		return cliente;*/
	
		
	
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
		"select *for cliente wher id=?",
		new Object[]{new Integer(id)},
		new RowMapper<Cliente>(){
			public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException{
				Cliente cliente=new Cliente(rs.getInt("id"), rs.getString("nombre"),rs.getString("apellidos"));
				return cliente;
//new RowMapper<Cliente>(){
			}
				
		}
		
	);
	
	return c;

	}
	
	/*Para realizar un busqueda, se debe realizar de esta manera.
	 * 
	 * public List<Cliente> buscar(String pablabra){
		List<Cliente> lista;
	
	JdbcTemplate jdbc=new JdbcTemplate(dataSource);
	
		String c="%"+palabra+"%";
		lista=jdbc.query{
			"select * from cliente where nombre like ?",
			new Object[]{c};
			new RowMappwrCliente());
			
			return lista;*/
		
	
	
	
	
	
	
	public List<Cliente> listar(){
		List<Cliente> lista;
	
	JdbcTemplate jdbc=new JdbcTemplate(dataSource);
	
	lista=jdbc.query("select * from cliente",
			new RowMapper<Cliente>(){
				public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException{
					Cliente cliente=new Cliente(rs.getInt("id"), rs.getString("nombre"),rs.getString("apellidos"));
					return cliente;
			
// solo con esto valdria con el constructor de arriba. new RowMapper<Cliente>(){
				}
			}
		);
	 	
		return lista;
	}
}



