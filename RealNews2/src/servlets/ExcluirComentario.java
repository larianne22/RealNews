package servlets;

import java.io.IOException;
import model.Comentario;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ComentarioService;

/**
 * Servlet implementation class ExcluirComentario
 */
@WebServlet(name = "ExcluirComentario.do", urlPatterns = { "/ExcluirComentario.do" })
public class ExcluirComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirComentario() {
        super();
       }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Captura de parametros: (a id a ser excluida do banco de dados.		
		
				int id = Integer.parseInt(request.getParameter("id_comentario"));
				
				//Instanciar objeto tipo comentario:
				
				Comentario comentario = new Comentario();
				comentario.setId(id);
				
				
				// enviar o objeto comentario para a service remover:
				
				ComentarioService comentarioService = new ComentarioService();
				comentarioService.excluir(comentario);
				
				PrintWriter saida = response.getWriter();							
				saida.println("Exclusão realizada com sucesso!");
				saida.println(" <a href='ListarNoticia.do'> Clique aqui para Ler as notícias atualizadas </a>");
				
	}

}
