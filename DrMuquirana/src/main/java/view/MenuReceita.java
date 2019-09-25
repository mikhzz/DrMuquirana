package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraReceita;
import controller.ControladoraUsuario;
import model.vo.ReceitaVO;
import model.vo.UsuarioVO;

public class MenuReceita {

	Scanner teclado = new Scanner(System.in);
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_MENU_CADASTRAR_RECEITA = 1;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_RECEITA = 3;
	private static final int OPCAO_MENU_EXCLUIR_RECEITA= 4;
	private static final int OPCAO_MENU_RECEITA_SAIR = 5;
	
	
	private static final int OPCAO_MENU_CONSULTAR_TODAS_RECEITAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_RECEITA = 2;
	private static final int OPCAO_MENU_CONSULTAR_RECEITA_SAIR = 3;
	
	
public void apresentarMenuReceita() {
		
		int opcao = this.apresentarOpcoesMenu();
		
		while(opcao != OPCAO_MENU_RECEITA_SAIR) {
			switch(opcao) {
			case OPCAO_MENU_CADASTRAR_RECEITA: {
				
				this.cadastrarReceita();
				
				
				
			break;	
				
				
			}
			
			case OPCAO_MENU_CONSULTAR_RECEITA: {
				this.consultarReceita();
		 	
		   break;
			}
			
			case OPCAO_MENU_ATUALIZAR_RECEITA: {
				this.atualizarReceita();
				
				break;
			}
			
			case OPCAO_MENU_EXCLUIR_RECEITA: {
				this.excluirReceita();
				
				break;
			
			}
			
			
			
			default: {
				
				
				 System.out.println("\nOpção Invalida");
				
				
			}
			
		}
			opcao = this.apresentarOpcoesMenu(); 
			
			
			
			
		}
		
	}
	
	
	
	    private void atualizarReceita() {
		ReceitaVO receitaVO = new ReceitaVO();
		
        System.out.print("\nDigite o ID da Receita:    ");
		
		receitaVO.setId(Integer.parseInt(teclado.nextLine()));
       
		System.out.print("\nDigite o ID do Usuario:    ");
		
	    receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
		
		System.out.print("\nDigite a descrição da Receita:   "    );
		
		receitaVO.setDescricao(teclado.nextLine());
		
		System.out.print("\nDigite o valor da receita:   "    );
		
		receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
		
	     System.out.print("\nDigite a data da receita:   "    );
		
	     receitaVO.setDtReceita(LocalDate.parse(teclado.nextLine(), formataDate));
		
		
		
		ControladoraReceita controladoraReceita = new ControladoraReceita();
		controladoraReceita.atualizarReceitaController(receitaVO);
		
	
}



	private void consultarReceita() {
        ControladoraReceita controladoraReceita = new ControladoraReceita();
		
	    int opcao = this.apresentarOpcoesConsulta();
	  
	   while (opcao != OPCAO_MENU_RECEITA_SAIR) {
		  
			  switch(opcao) {
			  case OPCAO_MENU_CONSULTAR_TODAS_RECEITAS: {
				  
				  opcao = OPCAO_MENU_CONSULTAR_RECEITA_SAIR;
				  
				  ArrayList<ReceitaVO> listaReceitasVO = controladoraReceita.consultarTodasReceitasController();
				  System.out.println("\n-------- RESULTADO DA CONSULTA ---------");
				  System.out.printf("\n %3s  %-40s  %-15s  %-15s  \n", "ID", "DESCRIÇÃO", "VALOR", "DATA DA RECEITA");
				  for(int i = 0; i < listaReceitasVO.size(); i ++) {
					  
					  listaReceitasVO.get(i).imprimir();
					  
					  }
			  break;
			  }
			  
			  case OPCAO_MENU_CONSULTAR_UMA_RECEITA: {
				  
				  opcao = OPCAO_MENU_CONSULTAR_RECEITA_SAIR;
				  ReceitaVO receitaVO = new ReceitaVO();
				  System.out.print("\nDigite o ID do Usuario:    ");
				  receitaVO.setId(Integer.parseInt(teclado.nextLine()));
				  ReceitaVO receita = controladoraReceita.consultarReceitaController(receitaVO);
				  System.out.println("\n-------- RESULTADO DA CONSULTA ---------");
				  System.out.printf("\n %3s  %-40s  %-15s  %-15s  \n", "IDRECEITA", "IDUSUARIO", "DESCRIÇÃO", "VALOR", "DATA");
				  receita.imprimir();
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
		System.out.println(OPCAO_MENU_CONSULTAR_TODAS_RECEITAS + " - Consultar todas as Receitas");
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_RECEITA + " - Consultar uma Receita específica");
		System.out.println(OPCAO_MENU_CONSULTAR_RECEITA_SAIR + " - Voltar");
		System.out.print("\nDigite a opção:   ");
		
		
		
		return Integer.parseInt(teclado.nextLine());
	
	}



	private void excluirReceita() {
		
	ReceitaVO receitaVO = new ReceitaVO();
	System.out.println("\nDigite o Id da Receita:  ");
	receitaVO.setId(Integer.parseInt(teclado.nextLine()));
	ControladoraReceita controladoraReceita = new ControladoraReceita();
	
    controladoraReceita.excluirReceitaController(receitaVO);
	
}



	private void cadastrarReceita() {
	    ReceitaVO  receitaVO = new ReceitaVO();
	    
	//    System.out.println("\nDigite o ID:     ");
	    
	//    receitaVO.setIdReceita(Integer.parseInt(teclado.nextLine()));
	    
	    System.out.println("\nDigite o ID do usuário: "   );
	    
	    receitaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
	    
	    System.out.println("\nDigite a descrição da Receita:   "   );
	    
	    receitaVO.setDescricao(teclado.nextLine());
	    
	    System.out.println("\nDigite o valor da Receita :     ");
	    
	    receitaVO.setValor(Double.parseDouble(teclado.nextLine()));
	    
	     System.out.println("\nDigite a data da Receita:    ");
	     
	     receitaVO.setDtReceita(LocalDate.parse(teclado.nextLine(), formataDate));
	    
	    ControladoraReceita controladoraReceita = new ControladoraReceita();
	    controladoraReceita.cadastrarReceitaController(receitaVO);
	
}



	public int apresentarOpcoesMenu() {

		System.out.println("\nDr. Muquirana - Controle de Gastos \n---------- Menu de Cadastro de  Receita ----------");
		
		System.out.println("\nOpcões");
		System.out.println(OPCAO_MENU_CADASTRAR_RECEITA + " - Cadastro de Receita");
		System.out.println(OPCAO_MENU_CONSULTAR_RECEITA + " - Consultar  Receita");
		System.out.println(OPCAO_MENU_ATUALIZAR_RECEITA + " - Atualizar Receita");
		System.out.println(OPCAO_MENU_EXCLUIR_RECEITA   +  " - Excluir Receita");
		System.out.println(OPCAO_MENU_RECEITA_SAIR      + " - Voltar");
		System.out.print("\nDigite a Opção: ");
		
		
		 return Integer.parseInt(teclado.nextLine());
		
		
		
		}
	
	
	
	
	
	
}
