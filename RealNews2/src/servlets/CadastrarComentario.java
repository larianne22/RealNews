package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import service.ComentarioService;
import model.Comentario;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "CadastrarComentario.do", urlPatterns = { "/CadastrarComentario.do" })
public class CadastrarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CadastrarComentario() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recebendo os dados do HTML		
		
		String nome = request.getParameter("nome_comentario");
		String texto = request.getParameter("texto_comentario");
		int fkid = Integer.parseInt(request.getParameter("id_noticia"));		
		
		//Instanciar objeto tipo comentario:
		
		Comentario comentario = new Comentario();
		comentario.setNome(nome);
		comentario.setTexto(texto);
		comentario.setFkId(fkid);
		
		
		// enviar o objeto comentario para a service:
		
		ComentarioService comentarioService = new ComentarioService();
		comentarioService.cadastrar(comentario);
		
		PrintWriter saida = response.getWriter();
		

		response.setContentType ("text/html");
		saida.println("Cadastro efetuado com sucesso!");
		saida.println(" <a href='ListarNoticia.do'> Clique aqui para Ler as notícias atualizadas </a>");
		
	}

}
