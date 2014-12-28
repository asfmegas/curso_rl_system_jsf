package br.com.asf.cursoRLSystem.Bean;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

import br.com.asf.cursoRLSystem.DAO.ClienteDAO;
import br.com.asf.cursoRLSystem.VO.ClienteVO;

@ManagedBean(name="cliBean")
@SessionScoped
public class ClienteBean extends ClienteVO{
	
	public String addUser(){
		String toReturn = "erro";
		
		try{
			ClienteDAO dao = new ClienteDAO();
			if(dao.insert(this))
				toReturn = "sucesso";
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro no sistema\n"+e.getMessage());
		}
		return toReturn;
	}
}
