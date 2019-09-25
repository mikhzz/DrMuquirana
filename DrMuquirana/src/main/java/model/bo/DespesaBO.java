package model.bo;

import java.util.ArrayList;

import model.dao.DespesaDAO;
import model.dao.ReceitaDAO;
import model.dao.UsuarioDAO;
import model.vo.DespesaVO;
import model.vo.UsuarioVO;

public class DespesaBO {

	public void cadastrarReceitaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
        
    //    if(despesaDAO.verificarRegistroPorId(despesaVO.getIdDespesa())) {
     //  	 System.out.println("\nReceita já Cadastrada  ");
       	 
    //    } else {
       	 
			int resultado = despesaDAO.cadastrarDespesaDAO(despesaVO);
			if(resultado == 1) {
				
				System.out.println("\nDespesa cadastrada com Sucesso");
				
				
				} else {
					
					System.out.println("\nNão foi possivel cadastrar a despesa");
				

       	}
        
        

        }

		
	// }

	public void excluirReceitaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		
	       if(despesaDAO.verificarRegistroPorId(despesaVO.getId())) {	
	    	   int resultado = despesaDAO.excluirReceitaDAO(despesaVO);
			if(resultado == 1 ) {
				
				System.out.println("\nDespesa excluida com Sucesso");
				
			} else { 
				
				System.out.println("\nNão foi possivel excluir a Despesa");
			}
		    } else {
			
		        System.out.println("\nDespesa não existe na base de dados");
		}
		
		
	}

	public void atualizarDespesaBO(DespesaVO despesaVO) {
               DespesaDAO despesaDAO = new DespesaDAO();
		
		if(despesaDAO.verificarRegistroPorId(despesaVO.getId())) {	
	    	   int resultado = despesaDAO.atualizarDespesaDAO(despesaVO);
			if(resultado == 1 ) {
				
				System.out.println("\nDespesa atualizada com Sucesso");
				
			} else { 
				
				System.out.println("\nNão foi possivel atualizar a Despesa");
			}
		    } else {
			
		        System.out.println("Despesa não existe na base de dados");
		}
		
	}

	public ArrayList<DespesaVO> consultarDespesasBO() {
          DespesaDAO despesaDAO = new DespesaDAO();
		
		ArrayList<DespesaVO> listaDespesasVO = despesaDAO.consultarTodasDespesasDAO();
		if(listaDespesasVO.isEmpty()) {
			System.out.println("\nA Lista de usuários está vazia");
			
			
			
		}
		
		return listaDespesasVO;
		
	}

	public DespesaVO consultarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		DespesaVO despesa = despesaDAO.consultarDespesaDAO(despesaVO);
		if(despesa == null) {
			System.out.println("\nDespesa não localizado");
			
			
			
		}
		
		return despesa;
		
	
		
	}

}
