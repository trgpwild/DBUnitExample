package org.sharkness.dbunit.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tarefa")
@SuppressWarnings("serial")
public class Tarefa extends PersistenceEntity {

	@Column(name="nome")
	private String nome;

	@Temporal(TemporalType.DATE)
	private Calendar dataExecucao;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Calendar getDataExecucao() {
		return dataExecucao;
	}
	
	public void setDataExecucao(Calendar dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
	
	public String toString() {
		return getNome();
	}

}