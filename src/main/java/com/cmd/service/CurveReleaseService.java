package com.cmd.service;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

import com.cmd.dao.interfaces.IGenericDao;
import com.cmd.model.CurveReleaseSerie;
import com.cmd.model.DrawingReleasedInOE;
import com.cmd.service.interfaces.ICurveReleaseService;
import com.cmd.service.interfaces.IDrawingReleasedInOEService;

public class CurveReleaseService implements ICurveReleaseService,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IGenericDao<CurveReleaseSerie> dao;
	
	@PersistenceContext(name = "cmd")
    protected EntityManager getEntityManager;

	@Override
	public List<CurveReleaseSerie> selectCurveReleaseDaneWeek(String codProgram,
			Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("call procedure_curve_release_dane_week(?, ?, ?)");
		query.setParameter(1, codProgram);
		query.setParameter(2, initialDate);
		query.setParameter(3, endDate);
		List<Object[]> result = query.getResultList();
		List<CurveReleaseSerie> listCurveRelease = new ArrayList<CurveReleaseSerie>();
		for (Object[] row : result) {
			CurveReleaseSerie curveReleaseSerie = new CurveReleaseSerie();
			curveReleaseSerie.setCodProgram((String) row[0]);
			curveReleaseSerie.setQtyPn(((BigInteger)row[1]).intValue());
			curveReleaseSerie.setCategory(row[2].toString());
			listCurveRelease.add(curveReleaseSerie);
		}
		return listCurveRelease;
	}

	@Override
	public List<CurveReleaseSerie> selectCurveReleaseDaneMonthly(String codProgram,
			Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("call procedure_curve_release_dane_monthly(?, ?, ?)");
		query.setParameter(1, codProgram);
		query.setParameter(2, initialDate);
		query.setParameter(3, endDate);
		List<Object[]> result = query.getResultList();
		List<CurveReleaseSerie> listCurveRelease = new ArrayList<CurveReleaseSerie>();
		for (Object[] row : result) {
			CurveReleaseSerie curveReleaseSerie = new CurveReleaseSerie();
			curveReleaseSerie.setCodProgram((String) row[0]);
			curveReleaseSerie.setQtyPn(((BigInteger)row[1]).intValue());
			curveReleaseSerie.setCategory(row[2].toString());
			listCurveRelease.add(curveReleaseSerie);
		}
		return listCurveRelease;
	}

	@Override
	public List<CurveReleaseSerie> selectCurveReleasePlanWeek(String codProgram,
			Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("call procedure_curve_release_plan_week(?, ?, ?)");
		query.setParameter(1, codProgram);
		query.setParameter(2, initialDate);
		query.setParameter(3, endDate);
		List<Object[]> result = query.getResultList();
		List<CurveReleaseSerie> listCurveRelease = new ArrayList<CurveReleaseSerie>();
		for (Object[] row : result) {
			CurveReleaseSerie curveReleaseSerie = new CurveReleaseSerie();
			curveReleaseSerie.setCodProgram((String) row[0]);
			curveReleaseSerie.setQtyPn(((BigInteger)row[1]).intValue());
			curveReleaseSerie.setCategory(row[2].toString());
			listCurveRelease.add(curveReleaseSerie);
		}
		return listCurveRelease;
	}

	@Override
	public List<CurveReleaseSerie> selectCurveReleasePlanMonthly(String codProgram,
			Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("call procedure_curve_release_plan_monthly(?, ?, ?)");
		query.setParameter(1, codProgram);
		query.setParameter(2, initialDate);
		query.setParameter(3, endDate);
		List<Object[]> result = query.getResultList();
		List<CurveReleaseSerie> listCurveRelease = new ArrayList<CurveReleaseSerie>();
		for (Object[] row : result) {
			CurveReleaseSerie curveReleaseSerie = new CurveReleaseSerie();
			curveReleaseSerie.setCodProgram((String) row[0]);
			curveReleaseSerie.setQtyPn(((BigInteger)row[1]).intValue());
			curveReleaseSerie.setCategory(row[2].toString());
			listCurveRelease.add(curveReleaseSerie);
		}
		return listCurveRelease;
	}

	@Override
	public List<CurveReleaseSerie> selectCurveReleaseLibWeek(String codProgram,
			Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("call procedure_curve_release_lib_week(?, ?, ?)");
		query.setParameter(1, codProgram);
		query.setParameter(2, initialDate);
		query.setParameter(3, endDate);
		List<Object[]> result = query.getResultList();
		List<CurveReleaseSerie> listCurveRelease = new ArrayList<CurveReleaseSerie>();
		for (Object[] row : result) {
			CurveReleaseSerie curveReleaseSerie = new CurveReleaseSerie();
			curveReleaseSerie.setCodProgram((String) row[0]);
			curveReleaseSerie.setQtyPn(((BigInteger)row[1]).intValue());
			curveReleaseSerie.setCategory(row[2].toString());
			listCurveRelease.add(curveReleaseSerie);
		}
		return listCurveRelease;
	}

	@Override
	public List<CurveReleaseSerie> selectCurveReleaseLibMonthly(String codProgram,
			Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("call procedure_curve_release_lib_monthly(?, ?, ?)");
		query.setParameter(1, codProgram);
		query.setParameter(2, initialDate);
		query.setParameter(3, endDate);
		List<Object[]> result = query.getResultList();
		List<CurveReleaseSerie> listCurveRelease = new ArrayList<CurveReleaseSerie>();
		for (Object[] row : result) {
			CurveReleaseSerie curveReleaseSerie = new CurveReleaseSerie();
			curveReleaseSerie.setCodProgram((String) row[0]);
			curveReleaseSerie.setQtyPn(((BigInteger)row[1]).intValue());
			curveReleaseSerie.setCategory(row[2].toString());
			listCurveRelease.add(curveReleaseSerie);
		}
		return listCurveRelease;
	}

	
}