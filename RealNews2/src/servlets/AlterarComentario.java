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
 * Servlet implementation class AlterarComentario
 */
@WebServlet(name = "AlterarComentario.do", urlPatterns = { "/AlterarComentario.do" })
public class AlterarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarComentario() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome_comentario");
		String texto = request.getParameter("texto_comentario");
		int id = Integer.parseInt(request.getParameter("id_comentario"));
		
		//Instanciar objeto tipo professor:
		
		Comentario comentario = new Comentario();
		comentario.setNome(nome);
		comentario.setTexto(texto);
		comentario.setId(id);
		
		
		// enviar o objeto prof para a service:
		
		ComentarioService comentarioService = new ComentarioService();
		comentarioService.alterar(comentario);
		
		PrintWriter saida = response.getWriter();
		
		saida.println("Alteração realizada com sucesso!");
		
	}

}
