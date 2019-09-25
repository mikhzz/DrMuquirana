package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.ReceitaVO;
import model.vo.UsuarioVO;

     public class ReceitaDAO {
	
	DateTimeFormatter formataDate2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	

	public boolean verificarRegistroPorId(int id) {
		
         Connection conn = Banco.getConnection();
		
		Statement stmt = Banco.getStatement(conn);
		
		ResultSet resultado = null;
		
		String query = "SELECT idreceita FROM receita WHERE idreceita = '"+ id +"'";
		
		try {
			
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
				
			}
		} catch (SQLException e) {
			
			System.out.println("Erro ao executar a query que verifica a existência de uma receita por Id");
			System.out.println("Erro: " + e.getMessage() );
			
		} finally {
			
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}
		
		
		return false;
	}
		
		
		
		
		
		
	

	public int cadastrarReceitaDAO(ReceitaVO receitaVO) {
		
        Connection conn = Banco.getConnection();
		
		Statement stmt = Banco.getStatement(conn);
		
		int resultado =0;
		
		String query = "INSERT INTO receita (idusuario, descricao, valor, dtReceita) "
		+ " VALUES ('"
		+ receitaVO.getIdUsuario() + "','"
		+ receitaVO.getDescricao()+"','"
		+ receitaVO.getValor()+"','"
		+ receitaVO.getDtReceita()+"')";
		
		try {
			
			 resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			
			
			System.out.println("Erro ao executar a query de cadastro do  usuário");
			System.out.println("Erro: " + e.getMessage() );
			
		} finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
			
		}
		
		
		return resultado; 
		
		
	}








	public int excluirReceitaDAO(ReceitaVO receitaVO) {
          Connection conn = Banco.getConnection();
		
		Statement stmt = Banco.getStatement(conn);
		
		int resultado = 0;
		
		String query = "DELETE FROM receita WHERE idreceita = "
		+ receitaVO.getId();
		
		try {
			
			 resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			
			
			System.out.println("Erro ao executar a query de exclusão de receita");
			System.out.println("Erro: " + e.getMessage() );
			
		} finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
			
		}
		
		
		
		return resultado;
	}








	public int atualizarReceitaDAO(ReceitaVO receitaVO) {
           Connection conn = Banco.getConnection();
		
		   Statement stmt = Banco.getStatement(conn);
		
		   int resultado = 0;
		
		String query = "UPDATE  receita SET idreceita = "+receitaVO.getId() + ", idusuario = "
		                                                  +receitaVO.getIdUsuario()+ ", descricao = '"
				                                          +receitaVO.getDescricao()+ "', valor = "
		                                                  +receitaVO.getValor()+", DtReceita = '"
				                                          +receitaVO.getDtReceita() + "'WHERE idreceita = " +receitaVO.getId();
		
		try {
			
			 resultado = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			
			
			System.out.println("Erro ao executar a query de atualização de receita");
			System.out.println("Erro: " + e.getMessage() );
			
		} finally {
			
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
			
		}
		
		
		
		return resultado;
		
		
	}








	public ArrayList<ReceitaVO> consultarTodasReceitasDAO() {
		    Connection conn = Banco.getConnection();
			
		    Statement stmt = Banco.getStatement(conn);
		
		    ResultSet resultado = null;
		   
		    ArrayList<ReceitaVO> receitasVO = new ArrayList<ReceitaVO>();
		   
		    String query = "SELECT idreceita,idusuario,descricao,valor, dtreceita FROM receita";
		   
			   try {
				
				   resultado = stmt.executeQuery(query);
				
				while(resultado.next()) {
				   ReceitaVO receitaVO = new ReceitaVO();
				   
				   receitaVO.setId(resultado.getInt(1));
				   receitaVO.setIdUsuario(resultado.getInt(2));
				   receitaVO.setDescricao(resultado.getString(3));
				   receitaVO.setValor(resultado.getDouble(4));
				   receitaVO.setDtReceita(LocalDate.parse(resultado.getString(5)));
				  
				   
				   receitasVO.add(receitaVO);   
					
				}
				
				
			} catch (SQLException e) {
				
				System.out.println("Erro ao executar a query de consulta de todas as Receitas");
				System.out.println("Erro:   "    +e.getMessage());
			} finally {
				
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
		}
		   
		return receitasVO;
		
		
		
	}








	public ReceitaVO consultarReceitaDAO(ReceitaVO receitaVO) {
		   Connection conn = Banco.getConnection();
			
		   Statement stmt = Banco.getStatement(conn);
		
		   ResultSet resultado = null;
		   
		   ReceitaVO receita = new ReceitaVO();
		   
		   String query = "SELECT idreceita, idusuario, descricao, valor, dtreceita FROM receita WHERE idreceita = " +receitaVO.getId();
		   
		   
		   try {
			   
			resultado = stmt.executeQuery(query);
			
			while(resultado.next()) {
				   
				   receita.setId(resultado.getInt(1));
				   receita.setIdUsuario(resultado.getInt(2));
				   receita.setDescricao(resultado.getString(3));
				   receita.setValor(resultado.getDouble(4));
				   receita.setDtReceita(LocalDate.parse(resultado.getString(5)));
				   
				   
				      
					
				}
			
			
			
		} catch (SQLException e) {
			
			System.out.println("Erro ao executar a query de consulta de Receita");
			System.out.println("Erro:   "    +e.getMessage());
			
		} finally {
			
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		   
		return receita;
		
	}
	
	}


