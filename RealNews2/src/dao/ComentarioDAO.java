package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Comentario;

import java.sql.ResultSet;

public class ComentarioDAO {
	
	private Connection conexao;
	
	public ComentarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Comentario comentario) {
			
		String inserir = "INSERT INTO comentario "
				+ " (nome, texto, fk_noticia_id) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			
			pst.setString(1, comentario.getNome());
			pst.setString(2, comentario.getTexto());
			pst.setInt(3, comentario.getFkId());
		
			
					
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Comentario comentario) {
		
		String inserir = "UPDATE comentario "
				+ "SET nome = ?, texto = ? "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, comentario.getNome());
			pst.setString(2, comentario.getTexto());
			pst.setInt(3, comentario.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Comentario comentario) {
		
		String inserir = "DELETE FROM comentario "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, comentario.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Comentario.");
			ex.printStackTrace();
		}
	}
	
	public Comentario consultar(Comentario comentario) {
		
		String inserir = "SELECT * FROM comentario "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, comentario.getId());
			ResultSet resultado = pst.executeQuery();
			
			Comentario p = null;
			if (resultado.next() == true) {
				p = new Comentario();
				p.setNome(resultado.getString("nome"));
				p.setTexto(resultado.getString("texto"));
				p.setId(resultado.getInt("id"));
				
			}
			return p;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Comentario> listarComentarios() {
		
		String inserir = "SELECT * FROM comentario";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario p = new Comentario();
				p.setId(resultado.getInt("id"));
				p.setTexto(resultado.getString("texto"));
				p.setNome(resultado.getString("nome"));								
				
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}
	
	public ArrayList<Comentario> listarComentariosId(Comentario comentario) {
		
		String inserir = "SELECT * FROM comentario"
				+ " WHERE fk_noticia_id = ? ";;
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, comentario.getFkId());
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario p = new Comentario();
				p.setId(resultado.getInt("id"));
				p.setTexto(resultado.getString("texto"));
				p.setNome(resultado.getString("nome"));								
				
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Comentario.");
			ex.printStackTrace();
			
			return null;
		}
	}

}
