package model.bo;

import java.util.ArrayList;

import model.dao.ReceitaDAO;
import model.dao.UsuarioDAO;
import model.vo.ReceitaVO;
import model.vo.UsuarioVO;

public class ReceitaBO {

	public void cadastrarReceitaBO(ReceitaVO receitaVO) {
	             ReceitaDAO receitaDAO = new ReceitaDAO();
	             
	         //    if(receitaDAO.verificarRegistroPorId(receitaVO.getIdReceita())) {
	          //  	 System.out.println("\nReceita já Cadastrada  ");
	            	 
	           //  } else {
	            	 
	     			int resultado = receitaDAO.cadastrarReceitaDAO(receitaVO);
	     			if(resultado == 1) {
	    				
	    				System.out.println("\nReceita cadastrada com Sucesso");
	    				
	    				
	    				} else {
	    					
	    					System.out.println("\nNão foi possivel cadastrar a receita");
	    				

	            	}
	             
	             
		
	             }
//	}

	public void excluirReceitaBO(ReceitaVO receitaVO) {
		     ReceitaDAO receitaDAO = new ReceitaDAO();
		
	       if(receitaDAO.verificarRegistroPorId(receitaVO.getId())) {	
	    	   int resultado = receitaDAO.excluirReceitaDAO(receitaVO);
			if(resultado == 1 ) {
				
				System.out.println("\nReceita excluida com Sucesso");
				
			} else { 
				
				System.out.println("\nNão foi possivel excluir a Receita");
			}
			
		    } else {
			
		        System.out.println("\nReceita não existe na base de dados");
		}
		
	}

	public void atualizarReceitaBO(ReceitaVO receitaVO) {
             ReceitaDAO receitaDAO = new ReceitaDAO();
		
	//	if(receitaDAO.verificarRegistroPorId(receitaVO.getIdReceita())) {	
	    	   int resultado = receitaDAO.atualizarReceitaDAO(receitaVO);
			if(resultado == 1 ) {
				
				System.out.println("\nReceita atualizada com Sucesso");
				
			} else { 
				
				System.out.println("\nNão foi possivel atualizar a Receita");
			
			
	           }
	         
     
			
		        System.out.println("Receita não existe na base de dados");
		
	}






			
//	

	public ArrayList<ReceitaVO> consultarReceitasBO() {
           ReceitaDAO receitaDAO = new ReceitaDAO();
		
		ArrayList<ReceitaVO> listaReceitasVO = receitaDAO.consultarTodasReceitasDAO();
		
		if(listaReceitasVO.isEmpty()) {
			System.out.println("\nA Lista de receitas está vazia");
		
		
	}
		return listaReceitasVO;
	}
	
	
	

	public ReceitaVO consultarReceitaBO(ReceitaVO receitaVO) {
		ReceitaDAO receitaDAO = new ReceitaDAO();
		ReceitaVO  receita = receitaDAO.consultarReceitaDAO(receitaVO);
		if(receita == null) {
			System.out.println("\nReceita não localizada");
			
			
			
		}
		
		return receita;
	}

	 
		
				
		
	}



