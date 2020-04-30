package servlets;

import java.io.IOException;
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
 * Servlet implementation class ListarNoticia
 */
@WebServlet(name = "ListarComentario.do", urlPatterns = { "/ListarComentario.do" })
public class ListarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Comentario = null;
       
    public ListarComentario() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {							
		
		int id = Integer.parseInt(request.getParameter("id_noticia"));
		String texto = request.getParameter("texto_comentario");
		
		Noticia noticia = new Noticia();
		noticia.setId(id);
		
		Comentario comentario = new Comentario();
		comentario.setTexto(texto);
		comentario.setFkId(id);
		
		// solicitar a service da lista de noticia
		
		NoticiaService noticiaService = new NoticiaService();
		//instanciando uma lista de noticia vazia
		ArrayList<Noticia> listaNoticia = null;
		//carregando a lista com noticia do banco de dados
		listaNoticia = noticiaService.listarNoticiaId(noticia);
		
		ComentarioService comentarioService = new ComentarioService();
		//instanciando uma lista de comentario vazia
		ArrayList<Comentario> listaComentario = null;
		//carregando a lista com noticia do banco de dados
		listaComentario = comentarioService.listarComentariosId(comentario);
		
		
		// Definir o tipo de conteudo a ser enviado:
		response.setContentType ("text/html");
		
		//criando um objeto de saida de caracteres:
		PrintWriter saida = response.getWriter();
		//PrintWriter writer = resp.getWriter(); writer.println("<h1>Livro enviado com sucesso</h1>");
		//percorrer toda a lista de objetos noticia e imprimir os dados:
		
		
		saida.println("<h1>RealNews</h1>");
		saida.println("<h4>_________________________________________________</h4>");
		//saida.println("Cadastro de Notícia");
		//saida.println("</title>");
		
		listaNoticia.forEach(p ->{
			//saida.println("<body>");
			
			saida.println("<h2>");
			//saida.println(p.getId());		
			saida.println(p.getTitulo());				
			saida.println("</h2>");			
			saida.println(p.getTexto());			
			saida.println("<br/>");		
		}		
			
		);
		saida.println("<h3>Comentários</h3>");
		listaComentario.forEach(p ->{
			//saida.println("<body>");
			
			saida.println("<h4>");
				//saida.println(p.getId());		
				saida.println(p.getNome());				
			saida.println("</h4>");			
			saida.println(p.getTexto());
			saida.println("<a href='AlterarComentario.do?id_comentario="
					+ p.getId() + "'> Alterar </a>");
			saida.println("<a href='ExcluirComentario.do?id_comentario="
					+ p.getId() + "'> Excluir </a>");
			saida.println("<p>_________________________________________________</p>");
		}
				
		);
		
		saida.println("<br/>");
		saida.println("<h2>Adicionar Comentário:</h2>");		
		saida.println("<form method= 'post' action='CadastrarComentario.do'>");		
		saida.println("Nome:<input type='text' name='nome_comentario' /> <br>");		
		saida.println("Comentario:<input type='text' name= 'texto_comentario' /> <br>");		
		saida.println("Número da Notícia:<input type='text' name= 'id_noticia' value='" 
							+ comentario.getFkId() + "'> <br>");
		saida.println("<input type='submit'>");
		saida.println("</form>");		
		
	}
		
}

