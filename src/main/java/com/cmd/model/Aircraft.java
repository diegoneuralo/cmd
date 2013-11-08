package com.cmd.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema="dmc", name="aircraft")
public class Aircraft implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="idaircraft")
	private Integer id;
	
	@Column(name="COD_PROJECT")
	private String codProgram;
	
	@Column(name="COD_MODEL")
	private String codModel;
	
	@OneToOne
	@JoinColumn(name="CODDBT", referencedColumnName="CODDBT")
	private DesignBuiltTeam designBuiltTeam = new DesignBuiltTeam();
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCodProgram() {
		return codProgram;
	}
	public void setCodProgram(String codProgram) {
		this.codProgram = codProgram;
	}
	public String getCodModel() {
		return codModel;
	}
	public void setCodModel(String codModel) {
		this.codModel = codModel;
	}
	public DesignBuiltTeam getDesignBuiltTeam() {
		return designBuiltTeam;
	}
	public void setDesignBuiltTeam(DesignBuiltTeam designBuiltTeam) {
		this.designBuiltTeam = designBuiltTeam;
	}	
	
}
