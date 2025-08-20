package telas;

public class Usuario {

	static String cpf;
	static String adm;
	static String nome;
	
	public Usuario(String cpf, String adm, String nome) {
		super();
		this.cpf = cpf;
		this.adm = adm;
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String isAdm() {
		return adm;
	}
	public void setAdm(String adm) {
		this.adm = adm;
	}
	
	
}
