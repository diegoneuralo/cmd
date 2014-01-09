package com.cmd.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(schema="dmc", name="CURVE_RELEASE")
public class CurveRelease implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "idcurve_release")
	private Integer id;
	
	@Column(name = "MATNR")
	private String matnr;
	
	@Column(name = "NUMDES")
	private String numdes;
	
	@Column(name = "PROGRAM")
	private String program;
	
	@Column(name = "DANE")
	@Temporal(TemporalType.DATE)
	private Date dane;
	
	@Column(name = "DAT_PLAN")
	@Temporal(TemporalType.DATE)
	private Date datPlan;
	
	@Column(name = "DAT_LIB")
	@Temporal(TemporalType.DATE)
	private Date datLib;
	
	@Column(name = "IND_SIT")
	private String indSit;
	
	public CurveRelease(){
		
	}

	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getMatnr() {
		return matnr;
	}



	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}



	public String getNumdes() {
		return numdes;
	}

	public void setNumdes(String numdes) {
		this.numdes = numdes;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public Date getDane() {
		return dane;
	}

	public void setDane(Date dane) {
		this.dane = dane;
	}

	public Date getDatPlan() {
		return datPlan;
	}

	public void setDatPlan(Date datPlan) {
		this.datPlan = datPlan;
	}

	public Date getDatLib() {
		return datLib;
	}

	public void setDatLib(Date datLib) {
		this.datLib = datLib;
	}

	public String getIndSit() {
		return indSit;
	}

	public void setIndSit(String indSit) {
		this.indSit = indSit;
	}
	
	

}
