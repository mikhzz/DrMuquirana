package controller;

import java.util.ArrayList;

import model.bo.DespesaBO;
import model.bo.ReceitaBO;
import model.seletor.DespesaSeletor;
import model.vo.DespesaVO;
import model.vo.ReceitaVO;

public class ControladoraDespesa {

	public void cadastrarDespesaController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		despesaBO.cadastrarReceitaBO(despesaVO);
		
	}

	public void excluirDespesaController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		despesaBO.excluirReceitaBO(despesaVO);
		
		
	}

	public void atualizarDespesaController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		despesaBO.atualizarDespesaBO(despesaVO);
		
	}

	public ArrayList<DespesaVO> consultarTodasDespesasController() {
		   DespesaBO despesaBO = new DespesaBO();
			
			
			return despesaBO.consultarDespesasBO();
		
	}

	public DespesaVO consultarDespesaController(DespesaVO despesaVO) {
		 DespesaBO despesaBO = new DespesaBO();
			
			
			
			return despesaBO.consultarDespesaBO(despesaVO);
	}

	public ArrayList<String> consultarCategorias() {
		// TODO Auto-generated method stub
		return null;
	}

	public int consultarTotalPaginas(DespesaSeletor seletor) {
		// TODO Auto-generated method stub
		return 0;
	}

}
