package model.bo;

import java.util.ArrayList;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	public void cadastrarUsuarioBO(UsuarioVO usuarioVO) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		
		if(usuarioDAO.verificarRegistroPorCpf(usuarioVO.getCpf())) {
			System.out.println("\nUsuário já cadastrado.  ");
			
			
		} else {
			
			int resultado = usuarioDAO.cadastrarUsuarioDAO(usuarioVO);
			
			if(resultado == 1) {
				
				System.out.println("\nUsuário cadastrado com Sucesso");
				
				
				} else {
					
					System.out.println("\nNão foi possivel cadastrar o Usuário");
					
				}
			
		}
		
		
		
		
	}

	public void excluirUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
       if(usuarioDAO.verificaRegistroPorIDUsuario(usuarioVO.getIdUsuario())) {	
    	   int resultado = usuarioDAO.excluirUsuarioDAO(usuarioVO);
		if(resultado == 1 ) {
			
			System.out.println("\nUsuario excluido com Sucesso");
			
		} else { 
			
			System.out.println("\nNão foi possivel excluir o usuario");
		}
	    } else {
		
	        System.out.println("Usuario não existe na base de dados");
	}
	
	

}

	public void atualizaUsuarioBO(UsuarioVO usuarioVO) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		if(usuarioDAO.verificaRegistroPorIDUsuario(usuarioVO.getIdUsuario())) {	
	    	   int resultado = usuarioDAO.atualizarUsuarioDAO(usuarioVO);
			if(resultado == 1 ) {
				
				System.out.println("\nUsuario atualizado com Sucesso");
				
			} else { 
				
				System.out.println("\nNão foi possivel atualizar o usuario");
			}
		    } else {
			
		        System.out.println("Usuario não existe na base de dados");
		}
		
		
		}

	public ArrayList<UsuarioVO> consultarUsuariosBO() {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		ArrayList<UsuarioVO> listaUsuariosVO = usuarioDAO.consultarTodosUsuariosDAO();
		if(listaUsuariosVO.isEmpty()) {
			System.out.println("\nA Lista de usuários está vazia");
			
			
			
		}
		
		return listaUsuariosVO;
	}

	public UsuarioVO consultarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuario = usuarioDAO.consultarUsuarioDAO(usuarioVO);
		if(usuario == null) {
			System.out.println("\nUsuário não localizado");
			
			
			
		}
		
		return usuario;
	}
	
	
}
	
