package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.NoticiaService;
import model.Noticia;

/**
 * Servlet implementation class ExcluirNoticia
 */
@WebServlet(name = "ExcluirNoticia.do", urlPatterns = { "/ExcluirNoticia.do" })
public class ExcluirNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirNoticia() {
        super();
       }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Captura de parametros: (a id a ser excluida do banco de dados.		
		
				int id = Integer.parseInt(request.getParameter("id_noticia"));
				
				//Instanciar objeto tipo noticia:
				
				Noticia noticia = new Noticia();
				noticia.setId(id);
				
				
				// enviar o objeto id para a service remover:
				
				NoticiaService noticiaService = new NoticiaService();
				noticiaService.excluir(noticia);
				
				PrintWriter saida = response.getWriter();							
				saida.println("Exclusão realizada com sucesso!");
				saida.println(" <a href='ListarNoticia.do'> Clique aqui para Ler as notícias atualizadas </a>");
				
	}

}
