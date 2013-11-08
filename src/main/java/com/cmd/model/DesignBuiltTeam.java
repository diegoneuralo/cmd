package com.cmd.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="dmc", name="dbt")
public class DesignBuiltTeam implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "iddbt")
	private Integer id;
	
	@Column(name = "COD_PROJ_AENV")
	private String codProject;
	
	@Column(name = "CODDBT")
	private String codDbt;
	
	@Column(name = "DSCDBT")
	private String dscDbt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodProject() {
		return codProject;
	}

	public void setCodProject(String codProject) {
		this.codProject = codProject;
	}

	public String getCodDbt() {
		return codDbt;
	}

	public void setCodDbt(String codDbt) {
		this.codDbt = codDbt;
	}

	public String getDscDbt() {
		return dscDbt;
	}

	public void setDscDbt(String dscDbt) {
		this.dscDbt = dscDbt;
	}

}
