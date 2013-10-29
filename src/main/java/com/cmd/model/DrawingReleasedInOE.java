package com.cmd.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DrawingReleasedInOE implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String codProgram;
	@Column
	private Integer qtyPn;
	@Column
	private Integer qtyPnAccum;
	@Column
	private String category;
	public String getCodProgram() {
		return codProgram;
	}
	public void setCodProgram(String codProgram) {
		this.codProgram = codProgram;
	}
	public Integer getQtyPn() {
		return qtyPn;
	}
	public void setQtyPn(Integer qtyPn) {
		this.qtyPn = qtyPn;
	}
	public Integer getQtyPnAccum() {
		return qtyPnAccum;
	}
	public void setQtyPnAccum(Integer qtyPnAccum) {
		this.qtyPnAccum = qtyPnAccum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
