package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.DespesaVO;

public class DespesaDAO {

	DateTimeFormatter formataDate2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public boolean verificarRegistroPorId(int id) {

		Connection conn = Banco.getConnection();

		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;

		String query = "SELECT iddespesa FROM despesa WHERE iddespesa = '" + id + "'";

		try {

			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				return true;

			}
		} catch (SQLException e) {

			System.out.println("Erro ao executar a query que verifica a existência de uma Despesa por Id");
			System.out.println("Erro: " + e.getMessage());

		} finally {

			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);

		}

		return false;

	}

	public int cadastrarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();

		Statement stmt = Banco.getStatement(conn);

		int resultado = 0;

		String query = "INSERT INTO despesa (iddespesa, Idusuario, descricao, valor, dtvencimento, dtpagamento, categoria) "
				+ " VALUES ('"+ despesaVO.getId()+ "','" + despesaVO.getIdUsuario() + "','" + despesaVO.getDescricao() + "','"
				+ despesaVO.getValor() + "','" + despesaVO.getDtVencimento() + "','" + despesaVO.getDtPagamento() + "','"
				+ despesaVO.getCategoria()+"')";

		try {

			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {

			System.out.println("Erro ao executar a query de cadastro de despesa");
			System.out.println("Erro: " + e.getMessage());

		} finally {

			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);

		}

		return resultado;

	}

	public int excluirReceitaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();

		Statement stmt = Banco.getStatement(conn);

		int resultado = 0;

		String query = "DELETE FROM despesa WHERE iddespesa = " + despesaVO.getId();

		try {

			resultado = stmt.executeUpdate(query);

		} catch (SQLException e) {

			System.out.println("Erro ao executar a query de exclusão de despesa");
			System.out.println("Erro: " + e.getMessage());

		} finally {

			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);

		}

		return resultado;

	}

	public int atualizarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();

		Statement stmt = Banco.getStatement(conn);

		int resultado = 0;

		String query = "UPDATE DESPESA SET IDDESPESA =" + despesaVO.getId() + ", IDUSUARIO = " + despesaVO.getIdUsuario() + ", descricao = '"
				+ despesaVO.getDescricao() + "', valor = " + despesaVO.getValor() + ", dtvencimento = '"
				+ despesaVO.getDtVencimento() + "', dtpagamento ='" + despesaVO.getDtPagamento()
				+ "', categoria = '" + despesaVO.getCategoria() + "' WHERE IDDESPESA = " + despesaVO.getId();

		try {

			resultado = stmt.executeUpdate(query); 
		//	 System.out.println(query);

		} catch (SQLException e) {

			System.out.println("Erro ao executar a query de atualização de Despesa");
			System.out.println("Erro: " + e.getMessage());

		} finally {

			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);

		}

		return resultado;

	}

	public ArrayList<DespesaVO> consultarTodasDespesasDAO() {

		Connection conn = Banco.getConnection();

		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;

		ArrayList<DespesaVO> despesasVO = new ArrayList<DespesaVO>();

		String query = "SELECT iddespesa,idusuario, descricao, dtvencimento, dtpagamento, categoria FROM despesa";

		try {

			resultado = stmt.executeQuery(query);

			while (resultado.next()) {

				DespesaVO despesaVO = new DespesaVO();

				despesaVO.setId(resultado.getInt(1));
				despesaVO.setIdUsuario(resultado.getInt(2));
				despesaVO.setDescricao(resultado.getString(3));
				despesaVO.setDtVencimento(LocalDate.parse(resultado.getString(4), formataDate2));
				despesaVO.setDtPagamento(LocalDate.parse(resultado.getString(5), formataDate2));
				despesaVO.setCategoria(resultado.getString(6));

				despesasVO.add(despesaVO);

			}

		} catch (SQLException e) {

			System.out.println("Erro ao executar a query de consulta de todas as Despesas");
			System.out.println("Erro:   " + e.getMessage());
		} finally {

			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return despesasVO;

	}

	public DespesaVO consultarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();

		Statement stmt = Banco.getStatement(conn);

		ResultSet resultado = null;

		DespesaVO despesa = new DespesaVO();

		String query = "SELECT iddespesa, idusuario, descricao, valor, dtvencimento, dtpagamento, categoria FROM despesa WHERE iddespesa = "
				+ despesaVO.getId();

		try {

			resultado = stmt.executeQuery(query);

			while (resultado.next()) {

				despesa.setId(resultado.getInt(1));
				despesa.setIdUsuario(resultado.getInt(2));
				despesa.setDescricao(resultado.getString(3));
				despesa.setValor(resultado.getDouble(4));
				despesa.setDtVencimento(LocalDate.parse(resultado.getString(5)));
				despesa.setDtPagamento(LocalDate.parse(resultado.getString(6)));
				despesa.setCategoria(resultado.getString(7));

			}

		} catch (SQLException e) {

			System.out.println("Erro ao executar a query de consulta de Despesa");
			System.out.println("Erro:   " + e.getMessage());

		} finally {

			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return despesa;

	}

}
