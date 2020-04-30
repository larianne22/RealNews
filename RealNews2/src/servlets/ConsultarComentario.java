package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comentario;
import service.ComentarioService;

/**
 * Servlet implementation class ConsultarComentario
 */
@WebServlet(name = "ConsultarComentario.do", urlPatterns = { "/ConsultarComentario.do" })
public class ConsultarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarComentario() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recebendo os dados do HTML		
		
				int id = Integer.parseInt(request.getParameter("id_comentario"));
				
				//Instanciar objeto tipo comentario:
				
				Comentario comentario = new Comentario();
				comentario.setId(id);
											
				// enviar o objeto comentario para a service:
				
				ComentarioService comentarioService = new ComentarioService();
				comentarioService.consultar(comentario);
				
				
				Comentario resultado = comentario;								
				
				PrintWriter saida = response.getWriter();
				saida.println(resultado);
				
				
				
	}

}
