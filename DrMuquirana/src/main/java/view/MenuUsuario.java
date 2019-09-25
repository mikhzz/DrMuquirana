package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraUsuario;
import model.vo.UsuarioVO;



public class MenuUsuario {

	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_CADASTRAR_USUARIO = 1;
	private static final int OPCAO_MENU_CONSULTAR_USUARIO = 2;
	private static final int OPCAO_MENU_ATUALIZAR_USUARIO = 3;
	private static final int OPCAO_MENU_EXCLUIR_USUARIO = 4;
	private static final int OPCAO_MENU_USUARIO_SAIR = 5;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_USUARIOS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_USUARIO = 2;
	private static final int OPCAO_MENU_CONSULTAR_USUARIO_SAIR = 3;
	
	
	public void apresentarMenuUsuario() {
		
		int opcao = this.apresentarOpcoesMenu();
		
			while(opcao != OPCAO_MENU_USUARIO_SAIR) {
				switch(opcao) {
				case OPCAO_MENU_CADASTRAR_USUARIO: {
					
					this.cadastrarUsuario();
					
					
					
				break;	
					
					
				}
				
				case OPCAO_MENU_CONSULTAR_USUARIO: {
					this.consultarUsuario();
			 	
			   break;
				}
				
				case OPCAO_MENU_ATUALIZAR_USUARIO: {
					this.atualizarUsuario();
					
					break;
				}
				
				case OPCAO_MENU_EXCLUIR_USUARIO: {
					this.excluirUsuario();
					
					break;
				
				}
				
				
				
				default: {
					
					
					 System.out.println("\nOpção Invalida");
					
					
				}
			
		}
			opcao = this.apresentarOpcoesMenu(); 
			
			
			
			
		}
		
	}
	
	
	
	private void consultarUsuario() {
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		
	    int opcao = this.apresentarOpcoesConsulta();
	  
	   while (opcao != OPCAO_MENU_USUARIO_SAIR) {
		  
			  switch(opcao) {
			  case OPCAO_MENU_CONSULTAR_TODOS_USUARIOS: {
				  
				  opcao = OPCAO_MENU_CONSULTAR_USUARIO_SAIR;
				  
				  ArrayList<UsuarioVO> listaUsuariosVO = controladoraUsuario.consultarTodosUsuariosController();
				  System.out.println("\n-------- RESULTADO DA CONSULTA ---------");
				  System.out.printf("\n %3s  %-40s  %-15s  %-15s  \n", "ID", "NOME", "CPF", "TELEFONE");
				  for(int i = 0; i < listaUsuariosVO.size(); i ++) {
					  
					  listaUsuariosVO.get(i).imprimir();
					  
					  }
			  break;
			  }
			  
			  case OPCAO_MENU_CONSULTAR_UM_USUARIO: {
				  
				  opcao = OPCAO_MENU_CONSULTAR_USUARIO_SAIR;
				  UsuarioVO usuarioVO = new UsuarioVO();
				  System.out.print("\nDigite o ID do Usuario:    ");
				  usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
				  UsuarioVO usuario = controladoraUsuario.consultarUsuarioController(usuarioVO);
				  System.out.println("\n-------- RESULTADO DA CONSULTA ---------");
				  System.out.printf("\n %3s  %-40s  %-15s  %-15s  \n", "ID", "NOME", "CPF", "TELEFONE");
				  usuario.imprimir();
				  break;
				  
			  }
			  default : {
				  System.out.println("Opção Invalida");
				  opcao = this.apresentarOpcoesConsulta();
			  }
	  }
			  
			  
	  }
		
	}

	
	


	private int apresentarOpcoesConsulta() {
		
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println(OPCAO_MENU_CONSULTAR_TODOS_USUARIOS + " - Consultar todos os Usuários");
		System.out.println(OPCAO_MENU_CONSULTAR_UM_USUARIO + " - Consultar um usuário específico");
		System.out.println(OPCAO_MENU_CONSULTAR_USUARIO_SAIR + " - Voltar");
		System.out.print("\nDigite a opção:   ");
		
		
		
		return Integer.parseInt(teclado.nextLine());
	}



	private void atualizarUsuario() {
		
        UsuarioVO usuarioVO = new UsuarioVO();
		
         System.out.print("\nDigite o ID do Usuario:    ");
		
		usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
        
		System.out.print("\nDigite o nome do Usuario:    ");
		
		usuarioVO.setNome(teclado.nextLine());
		
		System.out.print("\nDigite o Cpf:   "    );
		
		usuarioVO.setCpf(teclado.nextLine());
		
		System.out.print("\nDigite o Telefone:   "    );
		
		usuarioVO.setTelefone(teclado.nextLine());
		
		System.out.print("\nDigite o Login:   "    );
		
		usuarioVO.setLogin(teclado.nextLine());
		
		System.out.print("\nDigite a Senha:   "    );
		
		usuarioVO.setSenha(teclado.nextLine());
		
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		ControladoraUsuario.atualizarUsuarioController(usuarioVO);
		
		
	}



	private void excluirUsuario() {
		
		UsuarioVO usuarioVO = new UsuarioVO();
		
		System.out.println("\nDigite o Codigo do Usuario:  " );
		
		usuarioVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		
		controladoraUsuario.excluirUsuarioController(usuarioVO);
		
	}



	private void cadastrarUsuario() {
		
		
		UsuarioVO usuarioVO = new UsuarioVO();
		
		System.out.print("\nDigite o nome do Usuario:    ");
		
		usuarioVO.setNome(teclado.nextLine());
		
		System.out.print("\nDigite o Cpf:   "    );
		
		usuarioVO.setCpf(teclado.nextLine());
		
		System.out.print("\nDigite o Telefone:   "    );
		
		usuarioVO.setTelefone(teclado.nextLine());
		
		System.out.print("\nDigite o Login:   "    );
		
		usuarioVO.setLogin(teclado.nextLine());
		
		System.out.print("\nDigite a Senha:   "    );
		
		usuarioVO.setSenha(teclado.nextLine());
		
		
		ControladoraUsuario controladoraUsuario = new ControladoraUsuario();
		controladoraUsuario.cadastrarUsuarioController(usuarioVO);
	}



	public int apresentarOpcoesMenu() {

		System.out.println("\nDr. Muquirana - Controle de Gastos \n---------- Menu de Cadastro de  Usuário ----------");
		
		System.out.println("\nOpcões");
		System.out.println(OPCAO_MENU_CADASTRAR_USUARIO + " - Cadastro de Usuário");
		System.out.println(OPCAO_MENU_CONSULTAR_USUARIO + " - Consultar  Usuário");
		System.out.println(OPCAO_MENU_ATUALIZAR_USUARIO + " - Atualizar Usuário");
		System.out.println(OPCAO_MENU_EXCLUIR_USUARIO   + " - Excluir Usuário");
		System.out.println(OPCAO_MENU_USUARIO_SAIR      + "         - Voltar");
		System.out.print("\nDigite a Opção: ");
		
		
		 return Integer.parseInt(teclado.nextLine());
		
		
		
		}
	
}
