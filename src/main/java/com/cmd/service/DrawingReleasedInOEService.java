package com.cmd.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

import com.cmd.dao.interfaces.IGenericDao;
import com.cmd.model.DrawingReleasedInOE;
import com.cmd.service.interfaces.IDrawingReleasedInOEService;

public class DrawingReleasedInOEService implements IDrawingReleasedInOEService,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IGenericDao<DrawingReleasedInOE> dao;
	
	@Inject
	@PersistenceContext(name = "cmd")
    protected EntityManager getEntityManager;

	@Override
	public List<Object[]> selectPlannedDwgWeek(String codProgram,
			Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("SELECT * FROM ztdp_pn_afetado");
		List<Object[]> result = query.getResultList();
		for (Object[] row : result) {
			String nomeMarca = (String) row[0];
			String descricao = (String) row[1];
			Float preco = (Float) row[2];
		}
		return result;
	}

	@Override
	public List<DrawingReleasedInOE> selectPlannedDwgMonthly(String codProgram,
			Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("{ call procedure_planned_dwg_monthly(?, ?, ?) }");
		query.setParameter(1, codProgram);
		query.setParameter(2, initialDate);
		query.setParameter(3, endDate);
		List results = query.getResultList();
		return results;
	}

	@Override
	public List<DrawingReleasedInOE> selectPlannedDwgYearly(String codProgram,
			Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("{ call procedure_planned_dwg_yearly(?, ?, ?) }");
		query.setParameter(1, codProgram);
		query.setParameter(2, initialDate);
		query.setParameter(3, endDate);
		List results = query.getResultList();
		return results;
	}

	@Override
	public List<DrawingReleasedInOE> selectReleasedDwgWeek(String codProgram,
			Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("{ call procedure_released_dwg_week(?, ?, ?) }");
		query.setParameter(1, codProgram);
		query.setParameter(2, initialDate);
		query.setParameter(3, endDate);
		List results = query.getResultList();
		return results;
	}

	@Override
	public List<DrawingReleasedInOE> selectReleasedDwgMonthly(
			String codProgram, Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("{ call procedure_released_dwg_monthly(?, ?, ?) }");
		query.setParameter(1, codProgram);
		query.setParameter(2, initialDate);
		query.setParameter(3, endDate);
		List results = query.getResultList();
		return results;
	}

	@Override
	public List<DrawingReleasedInOE> selectReleasedDwgYearly(String codProgram,
			Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("{ call procedure_released_dwg_yearly(?, ?, ?) }");
		query.setParameter(1, codProgram);
		query.setParameter(2, initialDate);
		query.setParameter(3, endDate);
		List results = query.getResultList();
		return results;
	}
}