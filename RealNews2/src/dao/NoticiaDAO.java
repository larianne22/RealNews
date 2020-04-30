package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Noticia;

import java.sql.ResultSet;

public class NoticiaDAO {
	
	private Connection conexao;
	
	public NoticiaDAO() {
		this.conexao = ConnectionFactory.conectar();
	}

	public void cadastrar(Noticia noticia) {
			
		String inserir = "INSERT INTO noticia "
				+ " (descricao, titulo, texto) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTitulo());
			pst.setString(3, noticia.getTexto());
					
			
					
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
		}
	}
	
	public void alterar(Noticia noticia) {
		
		String inserir = "UPDATE noticia "
				+ "SET descricao = ?, titulo = ?, texto = ? "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, noticia.getDescricao());
			pst.setString(2, noticia.getTitulo());
			pst.setString(3, noticia.getTexto());
			
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
		}
	}
	
	public void excluir(Noticia noticia) {
		
		String inserir = "DELETE FROM noticia "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, noticia.getId());
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Noticia.");
			ex.printStackTrace();
		}
	}
	
	public Noticia consultar(Noticia noticia) {
		
		String inserir = "SELECT * FROM noticia "
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, noticia.getId());
			ResultSet resultado = pst.executeQuery();
			
			Noticia p = null;
			if (resultado.next() == true) {
				p = new Noticia();
				p.setDescricao(resultado.getString("descricao"));
				p.setTitulo(resultado.getString("titulo"));
				p.setTexto(resultado.getString("texto"));
				
			}
			return p;
			
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
			return null;
		}
	}

	
	public ArrayList<Noticia> listarNoticia() {
		
		String inserir = "SELECT * FROM noticia";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Noticia> lista = new ArrayList<>();
			while (resultado.next()) {
				Noticia p = new Noticia();
				p.setDescricao(resultado.getString("descricao"));
				p.setTitulo(resultado.getString("titulo"));
				p.setTexto(resultado.getString("texto"));
				p.setId(resultado.getInt("id"));
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
			return null;
		}
	}
	
	public ArrayList<Noticia> listarNoticiaId(Noticia noticia) {
		
		String inserir = "SELECT * FROM noticia"
				+ " WHERE id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, noticia.getId());
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Noticia> lista = new ArrayList<>();
			while (resultado.next()) {
				Noticia p = new Noticia();
				p.setDescricao(resultado.getString("descricao"));
				p.setTitulo(resultado.getString("titulo"));
				p.setTexto(resultado.getString("texto"));
				p.setId(resultado.getInt("id"));
				lista.add(p);
			}
			return lista;
			
		} catch (SQLException ex) {
			
			System.err.println("Não é possível manipular"
					+ "a tabela Noticia.");
			ex.printStackTrace();
			
			return null;
		}
	}

}
