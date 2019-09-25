package model.vo;

public abstract class LancamentoVO {
	
	private int Id;
	private int idUsuario;
	private String descricao;
	private double valor;
	
	
	public LancamentoVO(int Id, int idUsuario, String descricao, double valor) {
		super();
		this.Id = Id;
		this.idUsuario = idUsuario;
		this.descricao = descricao;
		this.valor = valor;
	}


	public LancamentoVO() {
		super();
		
	}


	


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	
	
	

}
