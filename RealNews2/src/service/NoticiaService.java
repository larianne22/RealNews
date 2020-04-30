package service;

import dao.NoticiaDAO;
import model.Noticia;
import java.util.ArrayList;


public class NoticiaService {
	
	private NoticiaDAO NoticiaDAO;
	
	/**
	 * Instancia um objeto NoticiaDAO dentro do atributo NoticiaDAO.
	 */
	
	public NoticiaService() {
			this.NoticiaDAO = new NoticiaDAO ();
	}
	
	public void cadastrar(Noticia noticia) {
			this.NoticiaDAO.cadastrar(noticia);
			
		}
	
	public void alterar (Noticia noticia) {
		this.NoticiaDAO.alterar(noticia);
		
	}
	
	public void excluir (Noticia noticia) {
		this.NoticiaDAO.excluir(noticia);
	}
	
	public void consultar (Noticia noticia) {
		this.NoticiaDAO.consultar(noticia);
	}
	
	public ArrayList<Noticia> listarNoticia() {
		return this.NoticiaDAO.listarNoticia();
	}

	public ArrayList<Noticia> listarNoticiaId(Noticia noticia) {
		return this.NoticiaDAO.listarNoticiaId(noticia);
	}	
}
