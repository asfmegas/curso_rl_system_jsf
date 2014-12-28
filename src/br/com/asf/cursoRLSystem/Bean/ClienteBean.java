package br.com.asf.cursoRLSystem.Bean;

import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;

import br.com.asf.cursoRLSystem.DAO.ClienteDAO;
import br.com.asf.cursoRLSystem.VO.ClienteVO;

@ManagedBean(name="cliBean")
public class ClienteBean extends ClienteVO{
	
	public String addUser(){
		String toReturn = "erro";
		
		try{
			ClienteDAO dao = new ClienteDAO();
			if(dao.insert(this))
				toReturn = "sucesso";
		}catch(Exception e){
			//JOptionPane.showMessageDialog(null, "Erro no sistema\n"+e.getMessage());
		}
		return toReturn;
	}
}
