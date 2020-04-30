package servlets;

import java.io.IOException;
import service.ComentarioService;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.NoticiaService;
import model.Noticia;
import service.ComentarioService;
import model.Comentario;


/**
 * Servlet implementation class ListarComentario
 */
@WebServlet(name = "ListarNoticia.do", urlPatterns = { "/ListarNoticia.do" })
public class ListarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Noticia = null;
       
    public ListarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {							
		// solicitar a service da lista de Noticia
		
		NoticiaService noticiaService = new  NoticiaService();
		//instanciando uma lista de Comentario vazia
		ArrayList<Noticia> listaNoticia = null;
		//carregando a lista com Comentario do banco de dados
		listaNoticia = noticiaService.listarNoticia();
		
		// Definir o tipo de conteudo a ser enviado:
		response.setContentType ("text/html");
		
		//criando um objeto de saida de caracteres:
		PrintWriter saida = response.getWriter();
		saida.println("<table border='1'>");
		//percorrer toda a lista de objetos Comentario e imprimir os dados:
		listaNoticia.forEach(p ->{
			saida.println("<body>");
			
			saida.println("<tr>");
			saida.println("<th> Notícias </th>");
			saida.println("<th> Ação1 </th>");
			saida.println("<th> Ação2 </th>");
			//saida.println("<th> Ação3 </th>");
			saida.println("</td>");
			
			saida.println("<tr>");
			saida.println("<td>");
			saida.println(p.getTitulo());
			saida.println("</td>");			
			
			
		/*criando uma coluna para link de exclusão*/
			
			saida.println ("<td>");
			saida.println ("<a href='ListarComentario.do?id_noticia="
					+ p.getId() + " '> Acessar Notícia Completa </a>");
			saida.println("</td>");
						
			
			saida.println ("<td>");
			saida.println ("<a href='ExcluirNoticia.do?id_noticia="
					+ p.getId() + " '> Excluir</a>");
			saida.println("</td>");
			
			saida.println("</tr>");			
		}
		
		);
		
		saida.println("</table>");
		
	}
}

