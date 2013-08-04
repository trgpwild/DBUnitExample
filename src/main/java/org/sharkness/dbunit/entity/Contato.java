package org.sharkness.dbunit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="contato")
@SuppressWarnings("serial")
public class Contato extends PersistenceEntity {
	
	@Column(name="nome")
	private String nome;

	@Column(name="endereco")
	private String endereco;

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	@Override
	public String toString() {
		return getNome();
	}

}