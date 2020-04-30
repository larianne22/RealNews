package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class AlterarNoticia
 */
@WebServlet(name = "AlterarNoticia.do", urlPatterns = { "/AlterarNoticia.do" })
public class AlterarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao = request.getParameter("descricao_noticia");
		String titulo = request.getParameter("titulo_noticia");
		String texto = request.getParameter("texto_noticia");
		int id = Integer.parseInt(request.getParameter("id_noticia"));
		
		//Instanciar objeto tipo noticia:
		
		Noticia noticia = new Noticia();
		noticia.setDescricao(descricao);
		noticia.setTitulo(titulo);
		noticia.setTexto(texto);
		noticia.setId(id);
		
		
		// enviar o objeto noticia para a service:
		
		NoticiaService noticiaService = new NoticiaService();
		noticiaService.alterar(noticia);
		
		PrintWriter saida = response.getWriter();
		
		saida.println("Alteração realizada com sucesso!");
		
	}

}
