package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceitaVO extends LancamentoVO{

	DateTimeFormatter formataDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
  	private LocalDate dtReceita;

	

	public ReceitaVO(int Id, int idUsuario, String descricao, double valor,int idReceita, LocalDate dtReceita) {
		super(Id, idUsuario, descricao, valor);
		
		this.dtReceita = dtReceita;
	}






   public ReceitaVO() {
		super();
		
	
	
	
	
	}



   
     public LocalDate getDtReceita() {
	return dtReceita;
}





       public void setDtReceita(LocalDate dtReceita) {
	this.dtReceita = dtReceita;





	}






      public void imprimir() {
	System.out.printf("%3s  %-40s  %-15s  %-15s \n", 
			this.getId(),
			this.getIdUsuario(), 
			this.getDescricao(),
			this.getValor(),
			this.getDtReceita());
	
	
}
      
      
}

