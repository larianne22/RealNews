package model;

public class Comentario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String texto;
	private String nome;
	private int fkid;
	
	
	public Comentario() {}

	public Comentario(int id, String texto, String nome, int fkid) {
		super();
		this.id = id;
		this.texto = texto;
		this.nome = nome;
		this.fkid = fkid;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getFkId() {
		return fkid;
	}

	public void setFkId(int fkid) {
		this.fkid = fkid;
	}


	

}
