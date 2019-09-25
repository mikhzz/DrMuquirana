package view;

import java.util.Scanner;

public class Menu {
	
	
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_CADASTRO =1;
	private static final int OPCAO_MENU_RELATORIO = 2;
	private static final int OPCAO_MENU_SAIR = 3;
	
	public void apresentarMenu() {
		
		int opcao = this.apresentarOpcoesDeMenu();
		
		
		while(opcao != OPCAO_MENU_SAIR) {
			
			switch(opcao) {
			
			case OPCAO_MENU_CADASTRO : {
				
				MenuCadastro menuCadastro = new MenuCadastro();
				menuCadastro.apresentarMenucadastro();
				
				break;
			}
				
			case OPCAO_MENU_RELATORIO:{
					
				MenuRelatorio menuRelatorio = new MenuRelatorio();
				menuRelatorio.apresentarMenuRelatorio();
				
					break;
					
			}
				
			default: {
				
				System.out.println("\nOPÇÃO INVALIDA");
			   }
				
				
			 }
			
			opcao = this.apresentarOpcoesDeMenu();
			
			}
			
			
			
			
		}
		
		
		public int apresentarOpcoesDeMenu() {
		
		System.out.println("Dr. Muquirana - Controle de Gastos");
		System.out.println("\nOpções: ");
		System.out.println(OPCAO_MENU_CADASTRO + " - Cadastro");
		System.out.println(OPCAO_MENU_RELATORIO + " - Relatorio");
		System.out.println(OPCAO_MENU_SAIR + " - Sair");
		System.out.print("\nDigite uma opção: ");
		
		return Integer.parseInt(teclado.nextLine());
		
		
	}
	
	

}
