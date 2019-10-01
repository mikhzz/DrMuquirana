package controller;

import java.util.ArrayList;

import model.bo.UsuarioBO;
import model.vo.UsuarioVO;

public class ControladoraUsuario {

	public static void cadastrarUsuarioController(UsuarioVO usuarioVO) {
		
		UsuarioBO usuarioBO = new UsuarioBO();
		usuarioBO.cadastrarUsuarioBO(usuarioVO);
		
	}

	public void excluirUsuarioController(UsuarioVO usuarioVO) {
		
		UsuarioBO usuarioBO = new UsuarioBO();
		
		usuarioBO.excluirUsuarioBO(usuarioVO);
		
	}

	public static  void atualizarUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();
		
		usuarioBO.atualizaUsuarioBO(usuarioVO);
		
		
	}

	public ArrayList<UsuarioVO> consultarTodosUsuariosController() {
		UsuarioBO usuarioBO = new UsuarioBO();
		
		
		return usuarioBO.consultarUsuariosBO();
	}

	public UsuarioVO consultarUsuarioController(UsuarioVO usuarioVO) {
		UsuarioBO usuarioBO = new UsuarioBO();
		
		
		
		return usuarioBO.consultarUsuarioBO(usuarioVO);
	}

	public String cadastrarUsuarioController(String nomeDigitado, String cpfDigitado, String telefoneDigitado,
			String loginDigitado, String senhaDigitada) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
