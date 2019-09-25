package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DespesaVO extends LancamentoVO{
	
	
	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	private LocalDate dtVencimento;
	private LocalDate dtPagamento;
	private String categoria;
	
	
	public DespesaVO(int Id, int idUsuario, String descricao, double valor, int idDespesa, LocalDate dtVencimento,
			LocalDate dtPagamento, String categoria) {
		super(Id, idUsuario, descricao, valor);
		
		this.dtVencimento = dtVencimento;
		this.dtPagamento = dtPagamento;
		this.categoria = categoria;
	}


	public DespesaVO() {
		super();
		
	}


	
	
	
	


	public LocalDate getDtVencimento() {
		return dtVencimento;
	}


	public void setDtVencimento(LocalDate dtVencimento) {
		this.dtVencimento = dtVencimento;
	}


	public LocalDate getDtPagamento() {
		return dtPagamento;
	}


	public void setDtPagamento(LocalDate dtPagamento) {
		this.dtPagamento = dtPagamento;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public void imprimir() {
		System.out.printf("%3s  %-40s  %-15s  %-15s \n", 
				this.getIdUsuario(), 
				this.getDescricao(),
				this.getValor(),
				this.getDtVencimento(),
		        this.getDtPagamento(),
		        this.getCategoria());
		
	}
	
	
	

	
	
}
	
	
	
		