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
 * Servlet implementation class ConsultarNoticia
 */
@WebServlet(name = "ConsultarNoticia.do", urlPatterns = { "/ConsultarNoticia.do" })
public class ConsultarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recebendo os dados do HTML		
		
				int id = Integer.parseInt(request.getParameter("id_noticia"));
				
				//Instanciar objeto tipo noticia:
				
				Noticia noticia = new Noticia();
				noticia.setId(id);
											
				// enviar o objeto noticia para a service:
				
				NoticiaService noticiaService = new NoticiaService();
				noticiaService.consultar(noticia);
				
				
				Noticia resultado = noticia;								
				
				PrintWriter saida = response.getWriter();
				saida.println(resultado);
				
				
				
	}

}
