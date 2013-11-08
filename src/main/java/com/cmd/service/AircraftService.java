package com.cmd.service;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cmd.dao.interfaces.IGenericDao;
import com.cmd.model.Aircraft;
import com.cmd.model.DesignBuiltTeam;
import com.cmd.model.DrawingReleasedInOE;
import com.cmd.service.interfaces.IAircraftService;

public class AircraftService implements IAircraftService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IGenericDao<Aircraft> dao;
	
	@PersistenceContext(name = "cmd")
    protected EntityManager getEntityManager;

	@Override
	public List<Aircraft> selectProgram() {
		Query query = getEntityManager.createNativeQuery("SELECT distinct cod_project FROM dmc.aircraft");
		List<Object[]> result = query.getResultList();
		List<Aircraft> listAircraft = new ArrayList<Aircraft>();
		for (Object row : result) {
			Aircraft aircraft = new Aircraft();
			aircraft.setCodProgram((String) row);
			listAircraft.add(aircraft);
		}
		return listAircraft;
	}

	@Override
	public List<Aircraft> selectModel(String codProject) {
		Query query = getEntityManager.createNativeQuery("SELECT distinct cod_model FROM dmc.aircraft");
		List<Object[]> result = query.getResultList();
		List<Aircraft> listAircraft = new ArrayList<Aircraft>();
		for (Object row : result) {
			Aircraft aircraft = new Aircraft();
			aircraft.setCodModel((String) row);
			listAircraft.add(aircraft);
		}
		return listAircraft;
	}

	@Override
	public List<Aircraft> selectDbt(String codProject) {
		Query query = getEntityManager.createNativeQuery("SELECT distinct d.DSCDBT FROM dmc.aircraft a, dmc.dbt d where a.CODDBT = d.CODDBT and a.COD_PROJECT = d.COD_PROJ_AENV");
		List<Object[]> result = query.getResultList();
		List<Aircraft> listAircraft = new ArrayList<Aircraft>();
		for (Object row : result) {
			Aircraft aircraft = new Aircraft();
			DesignBuiltTeam designBuiltTeam = new DesignBuiltTeam();
			designBuiltTeam.setDscDbt((String) row);
			aircraft.setDesignBuiltTeam(designBuiltTeam);
			listAircraft.add(aircraft);
		}
		return listAircraft;
	}

}
