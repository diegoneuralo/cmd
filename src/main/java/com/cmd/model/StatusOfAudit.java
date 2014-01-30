package com.cmd.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class StatusOfAudit implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String codProgram;
	@Column
	private String dbt;
	@Column
	private String typeAudit;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateAudit;
	@Column
	private String comment;
	@Column
	private Integer qty;
	
	public StatusOfAudit(){
		
	}

	public String getCodProgram() {
		return codProgram;
	}

	public void setCodProgram(String codProgram) {
		this.codProgram = codProgram;
	}

	public String getDbt() {
		return dbt;
	}

	public void setDbt(String dbt) {
		this.dbt = dbt;
	}

	public String getTypeAudit() {
		return typeAudit;
	}

	public void setTypeAudit(String typeAudit) {
		this.typeAudit = typeAudit;
	}

	public Date getDateAudit() {
		return dateAudit;
	}

	public void setDateAudit(Date dateAudit) {
		this.dateAudit = dateAudit;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	
}
