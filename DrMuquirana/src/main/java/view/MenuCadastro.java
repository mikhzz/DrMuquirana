package view;

import java.util.Scanner;

public class MenuCadastro {
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_CADASTRO_USUARIO = 1;
	private static final int OPCAO_MENU_CADASTRO_RECEITA = 2;
	private static final int OPCAO_MENU_CADASTRO_DESPESA = 3;
	private static final int OPCAO_MENU_CADASTRO_SAIR = 4;
	
	public void apresentarMenucadastro() {
		
		int opcao = this.apresentarOpcoesMenu();
		
		while(opcao != OPCAO_MENU_CADASTRO_SAIR) {
			switch(opcao) {
			case OPCAO_MENU_CADASTRO_USUARIO: {
				
				MenuUsuario menuUsuario = new MenuUsuario();
				menuUsuario.apresentarMenuUsuario();
				
				
			break;	
				
				
			}
			
			case OPCAO_MENU_CADASTRO_RECEITA: {
				
				MenuReceita menuReceita = new MenuReceita();
				
				menuReceita.apresentarMenuReceita();
				
				
		 	
		   break;
			}
			
			case OPCAO_MENU_CADASTRO_DESPESA: {
				
				
				MenuDespesa menuDespesa = new MenuDespesa();
				
				menuDespesa.apresentarMenuDespesa();
				
				
				break;
			}
			
			default: {
				 System.out.println("\nOpção Invalida");
				
				
			}
			
		}
			opcao = this.apresentarOpcoesMenu(); 
			
			
			
			
		}
	}
	
	
	public int apresentarOpcoesMenu() {

	System.out.println("\nDr. Muquirana - Controle de Gastos \n---------- Menu Cadastro ----------");
	
	System.out.println("\nOpcões");
	System.out.println(OPCAO_MENU_CADASTRO_USUARIO + " - Cadastro de Usuário");
	System.out.println(OPCAO_MENU_CADASTRO_RECEITA + " - Cadastro de Receita");
	System.out.println(OPCAO_MENU_CADASTRO_DESPESA + " - Cadastro de Despesa");
	System.out.println(OPCAO_MENU_CADASTRO_SAIR+ " - Sair");
	System.out.println("\nDigite a Opção: ");
	
	
	 return Integer.parseInt(teclado.nextLine());
	
	
	
	}

}