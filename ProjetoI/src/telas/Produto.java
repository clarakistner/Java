package telas;

import java.util.ArrayList;

public class Produto {
		
	static String nome;
	static float preco;
	static String codigo;
	
	static ArrayList<Produto> produtos = new ArrayList();
	
	public Produto(String nome, float preco, String codigo) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public static Produto buscarPorNome (String nome) {
		for (Produto p: produtos) {
			 if (p.getNome().equalsIgnoreCase(nome.trim())) {
	               return p;
	            }
		}
		return null;
	}
	
}
