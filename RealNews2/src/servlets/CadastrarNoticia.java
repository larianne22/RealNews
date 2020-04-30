package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import model.Noticia;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.NoticiaService;


@WebServlet(name = "CadastrarNoticia.do", urlPatterns = { "/CadastrarNoticia.do" })
public class CadastrarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CadastrarNoticia() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recebendo os dados do HTML		
		
		String descricao = request.getParameter("descricao_noticia");
		String titulo = request.getParameter("titulo_noticia");
		String texto = request.getParameter("texto_noticia");
		
		
		//Instanciar objeto tipo noticia:
		
		Noticia noticia = new Noticia();
		noticia.setDescricao(descricao);
		noticia.setTitulo(titulo);
		noticia.setTexto(texto);
		
		
		// enviar o objeto prof para a service:
		
		NoticiaService noticiaService = new NoticiaService();
		noticiaService.cadastrar(noticia);
		
		PrintWriter saida = response.getWriter();
		
		saida.println("Cadastro efetuado com sucesso!");
		saida.println(" <a href='cadastrarnoticia.html'> Clique aqui para Cadastrar novamente </a>");
		
	}

}
