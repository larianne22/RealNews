package service;

import dao.ComentarioDAO;
import model.Comentario;

import java.util.ArrayList;


public class ComentarioService {
	
	private ComentarioDAO ComentarioDAO;
	
	/**
	 * Instancia um objeto ComentarioDAO dentro do atributo ComentarioDAO.
	 */
	
	public ComentarioService() {
			this.ComentarioDAO = new ComentarioDAO ();
	}
	
	public void cadastrar(Comentario comentario) {
			this.ComentarioDAO.cadastrar(comentario);
			
		}
	
	public void alterar (Comentario comentario) {
		this.ComentarioDAO.alterar(comentario);
		
	}
	
	public void excluir (Comentario comentario) {
		this.ComentarioDAO.excluir(comentario);
	}
	
	public void consultar (Comentario comentario) {
		this.ComentarioDAO.consultar(comentario);
	}
	
	public ArrayList<Comentario> listarComentarios() {
		return this.ComentarioDAO.listarComentarios();
	}
	
	public ArrayList<Comentario> listarComentariosId(Comentario comentario) {
		return this.ComentarioDAO.listarComentariosId(comentario);
	}	

}
