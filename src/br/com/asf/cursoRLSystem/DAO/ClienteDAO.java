package br.com.asf.cursoRLSystem.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.asf.cursoRLSystem.VO.ClienteVO;

public class ClienteDAO {
	
	private Connection getConexao(){
		Connection toReturn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			toReturn = DriverManager.getConnection("jdbc:mysql://localhost/bdcursojsf","root","asfmegas18");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}
	
	public boolean insert(ClienteVO vo){
		String sql = "insert into clientes (nome,email,idade) values (?,?,?)";
		boolean toReturn = false;
		int x = 0;
		try{
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(++x, vo.getNome());
			stmt.setString(++x, vo.getEmail());
			stmt.setString(++x, vo.getIdade());
			
			if(stmt.executeUpdate() > 0){
				toReturn = true;
			}
			stmt.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro");
		}
		return toReturn;
	}
	
	public boolean delete(ClienteVO vo){
		String sql = "delete from clientes where id = ?";
		boolean toReturn = false;
		try{
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, vo.getId());
			
			if(stmt.executeUpdate() > 0){
				toReturn = true;
			}
			stmt.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro");
		}
		return toReturn;
	}
	
	public boolean update(ClienteVO vo){
		String sql = "update clientes set nome=?, email=?, idade=? where id =?";
		boolean toReturn = false;
		int x = 0;
		try{
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(++x, vo.getNome());
			stmt.setString(++x, vo.getEmail());
			stmt.setString(++x, vo.getIdade());
			stmt.setInt(++x, vo.getId());
			
			if(stmt.executeUpdate() > 0){
				toReturn = true;
			}
			stmt.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro");
		}
		return toReturn;
	}
	
	public ClienteVO getById(int id){
		String sql = "select * from clientes where id = ?";
		ClienteVO cliente = new ClienteVO();
		try{
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, id);
			
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				cliente.setId(Integer.parseInt("id"));
				cliente.setNome("nome");
				cliente.setEmail("email");
				cliente.setIdade("idade");
			}
			rs.close();
			stmt.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro");
		}
		return cliente;
	}
	
	public List<ClienteVO> getListAll(ClienteVO vo){
		String sql = "select * from clientes where id = ?";
		List<ClienteVO> clienteList = new ArrayList<ClienteVO>();
		try{
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, vo.getId());
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				ClienteVO cliente = new ClienteVO();
				cliente.setId(Integer.parseInt("id"));
				cliente.setNome("nome");
				cliente.setEmail("email");
				cliente.setIdade("idade");
				clienteList.add(cliente);
			}
			rs.close();
			stmt.close();
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro");
		}
		return clienteList;
	}
}
