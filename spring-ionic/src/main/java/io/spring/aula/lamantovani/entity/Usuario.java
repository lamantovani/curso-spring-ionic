package io.spring.aula.lamantovani.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {
	
	@Id
	private String id;
	
	private String nome;
	
	private int idade;
	
	private String email; 
	
	private String senha;
	
	@DBRef
	private List<Perfil> perfis;
	
	public Usuario() {
	}
	
	public Usuario(String nome, String email, String senha, List<Perfil> perfis) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.perfis = perfis;
	}

	public Usuario(Usuario usuario) {
		this.nome = usuario.getNome();
		this.idade = usuario.getIdade();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.perfis = usuario.getPerfis();
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	
	
	
	

}
