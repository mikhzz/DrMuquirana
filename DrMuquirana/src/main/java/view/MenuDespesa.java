package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControladoraDespesa;
import controller.ControladoraReceita;
import model.vo.DespesaVO;
import model.vo.ReceitaVO;

public class MenuDespesa {
	
	
	
       Scanner teclado = new Scanner(System.in);
       
       DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static final int OPCAO_MENU_CADASTRAR_DESPESA = 1;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA = 2;
	private static final int OPCAO_MENU_ATUALIZAR_DESPESA = 3;
	private static final int OPCAO_MENU_EXCLUIR_DESPESA= 4;
	private static final int OPCAO_MENU_DESPESA_SAIR = 5;
	
	
	private static final int OPCAO_MENU_CONSULTAR_TODAS_DESPESAS = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_DESPESA = 2;
	private static final int OPCAO_MENU_CONSULTAR_DESPESA_SAIR = 3;
	
	
	
public void apresentarMenuDespesa() {
		
		int opcao = this.apresentarOpcoesMenu();
		
		while(opcao != OPCAO_MENU_DESPESA_SAIR) {
			switch(opcao) {
			
			
			case OPCAO_MENU_CADASTRAR_DESPESA: {
				
				this.cadastrarDespesa();
				
			break;	
				
				
			}
			
			case OPCAO_MENU_CONSULTAR_DESPESA: {
				this.consultarDespesa();
		 	
		   break;
			}
			
			case OPCAO_MENU_ATUALIZAR_DESPESA: {
				this.atualizarDespesa();
				
				break;
			}
			
			case OPCAO_MENU_EXCLUIR_DESPESA: {
				this.excluirDespesa();
				
				break;
			
			}
			
			
			
			default: {
				
				
				 System.out.println("\nOpção Invalida");
				
				
			}
			
		}
			opcao = this.apresentarOpcoesMenu(); 
			
			
			
			
		}
		
	}
	
	
	
	private void consultarDespesa() {
      ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		
	    int opcao = this.apresentarOpcoesConsulta();
	  
	   while (opcao != OPCAO_MENU_DESPESA_SAIR) {
		  
			  switch(opcao) {
			  case OPCAO_MENU_CONSULTAR_TODAS_DESPESAS: {
				  
				  opcao = OPCAO_MENU_CONSULTAR_DESPESA_SAIR;
				  
				  ArrayList<DespesaVO> listaDespesasVO = controladoraDespesa.consultarTodasDespesasController();
				  System.out.println("\n-------- RESULTADO DA CONSULTA ---------");
				  System.out.printf("\n %3s  %-40s  %-15s  %-15s  \n", "ID", "DESCRIÇÃO", "VALOR", "DATA");
				  for(int i = 0; i < listaDespesasVO.size(); i ++) {
					  
					  listaDespesasVO.get(i).imprimir();
					  
					  }
			  break;
			  }
			  
			  case OPCAO_MENU_CONSULTAR_UMA_DESPESA: {
				  
				  opcao = OPCAO_MENU_CONSULTAR_DESPESA_SAIR;
				  DespesaVO despesaVO = new DespesaVO();
				  System.out.print("\nDigite o ID do Usuario:    ");
				  despesaVO.setId(Integer.parseInt(teclado.nextLine()));
				  DespesaVO despesa = controladoraDespesa.consultarDespesaController(despesaVO);
				  System.out.println("\n-------- RESULTADO DA CONSULTA ---------");
				  System.out.printf("\n %3s  %-40s  %-15s  %-15s  \n", "ID", "DESCRIÇÃO", "VALOR", "DATA");
				  despesa.imprimir();
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
		System.out.println(OPCAO_MENU_CONSULTAR_TODAS_DESPESAS + " - Consultar todas as Despesas");
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_DESPESA + " - Consultar uma Despesa específica");
		System.out.println(OPCAO_MENU_CONSULTAR_DESPESA_SAIR + " - Voltar");
		System.out.print("\nDigite a opção:   ");
		
		
		
		return Integer.parseInt(teclado.nextLine());
	
		
	}



	private void atualizarDespesa() {
	
		DespesaVO despesaVO = new DespesaVO();
		
	   System.out.println("\nDigite o ID:     ");
	    
	    despesaVO.setId(Integer.parseInt(teclado.nextLine()));
	    
	    System.out.println("\nDigite o ID do usuário: "   );
	    
	    despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
	    
	    System.out.println("\nDigite a descrição da Despesa:   "   );
	    
	    despesaVO.setDescricao(teclado.nextLine());
	    
	    System.out.println("\nDigite o valor da Despesa :     ");
	    
	    despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
	    
	    System.out.println("\nDigite a data do vencimento da Despesa:    ");
	    
	    despesaVO.setDtVencimento(LocalDate.parse(teclado.nextLine(), formataDate));
	    
	    System.out.println("\nDigite a data do Pegamento da Despesa:    ");
	    
	    despesaVO.setDtPagamento(LocalDate.parse(teclado.nextLine() , formataDate ));
	    
	    System.out.println("\nDigite a categoria da despesa:  ");
	    
	    despesaVO.setCategoria(teclado.nextLine());
	    
	    ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
	    controladoraDespesa.atualizarDespesaController(despesaVO);


		
		
}



	private void excluirDespesa() {
		DespesaVO despesaVO = new DespesaVO();
		System.out.println("\nDigite o Id da Despesa:  ");
		despesaVO.setId(Integer.parseInt(teclado.nextLine()));
		ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
		
	    controladoraDespesa.excluirDespesaController(despesaVO);
		
	
}



	private void cadastrarDespesa() {
		
		
	DespesaVO despesaVO = new DespesaVO();
	
//	System.out.println("\nDigite o ID da Despesa:     ");
    
 //   despesaVO.setIdDespesa(Integer.parseInt(teclado.nextLine()));
    
    System.out.println("\nDigite o ID do usuário: "   );
    
    despesaVO.setIdUsuario(Integer.parseInt(teclado.nextLine()));
    
    System.out.println("\nDigite a descrição da Despesa:   "   );
    
    despesaVO.setDescricao(teclado.nextLine());
    
    System.out.println("\nDigite o valor da Despesa :     ");
    
    despesaVO.setValor(Double.parseDouble(teclado.nextLine()));
    
    System.out.println("\nDigite a data do vencimento da Despesa:    ");
    
    despesaVO.setDtVencimento(LocalDate.parse(teclado.nextLine(), formataDate));
    
    System.out.println("\nDigite a data do Pegamento da Despesa:    ");
    
    despesaVO.setDtPagamento(LocalDate.parse(teclado.nextLine(), formataDate));
    
    System.out.println("\nDigite a categoria da despesa:  ");
    
    despesaVO.setCategoria(teclado.nextLine());
    
    ControladoraDespesa controladoraDespesa = new ControladoraDespesa();
    controladoraDespesa.cadastrarDespesaController(despesaVO);

	
}



	public int apresentarOpcoesMenu() {

		System.out.println("\nDr. Muquirana - Controle de Gastos \n---------- Menu de Cadastro de  Despesa ----------");
		
		System.out.println("\nOpcões");
		System.out.println(OPCAO_MENU_CADASTRAR_DESPESA + " - Cadastro de Despesa");
		System.out.println(OPCAO_MENU_CONSULTAR_DESPESA + " - Consultar  Despesa");
		System.out.println(OPCAO_MENU_ATUALIZAR_DESPESA + " - Atualizar Despesa");
		System.out.println(OPCAO_MENU_EXCLUIR_DESPESA   +  " - Excluir Despesa");
		System.out.println(OPCAO_MENU_DESPESA_SAIR      + " - Voltar");
		System.out.print("\nDigite a Opção: ");
		
		
		 return Integer.parseInt(teclado.nextLine());
		
		
		
		}
	
	
	

}
