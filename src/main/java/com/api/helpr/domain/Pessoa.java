package com.api.helpr.domain;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.api.helpr.domain.enums.Perfil;

//DEIXA A CLASSE PREPARADA PARA RECEBER ORIENTAÇÕES DE SQL
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	protected String nome;
	protected String cpf;
	protected String email;
	protected String senha;
	//SETA O CONSTRUTOR
	//INTEGER PRA PEGAR APENAR O CODIGO DA CONSTANTE QUE TA NO ENUM
	//O HASH É PORQUE PRECISA SEPARAR UM ESPAÇO NA MEMORIA
	protected Set<Integer> perfils = new HashSet<>();
	protected LocalDate dataCriacao = LocalDate.now();
	
	//CONSTRUTOR
	public Pessoa() {
		super();
		addPerfils(Perfil.CLIENTE);
	}
	
	public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		addPerfils(Perfil.CLIENTE);
	}
	
	
	//GETTERS E SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public Set<Perfil> getPerfils() {
		return perfils.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfils(Perfil perfil) {
		this.perfils.add(perfil.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	//COMPARAÇÃO DE CLASSES
	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
}
