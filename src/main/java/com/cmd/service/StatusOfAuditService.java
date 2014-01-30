package com.cmd.service;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cmd.dao.interfaces.IGenericDao;
import com.cmd.model.StatusOfAudit;
import com.cmd.service.interfaces.IStatusOfAuditService;

public class StatusOfAuditService implements IStatusOfAuditService,
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IGenericDao<StatusOfAudit> dao;

	@PersistenceContext(name = "cmd")
	protected EntityManager getEntityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<StatusOfAudit> selectAuditNew(String codProgram, String dbt, Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("call procedure_traffic_light_audit_new(?, ?, ?, ?)");
		query.setParameter(1, codProgram);
		query.setParameter(2, dbt);
		query.setParameter(3, initialDate);
		query.setParameter(4, endDate);
		List<Object[]> result = query.getResultList();
		List<StatusOfAudit> listStatusOfAudits = new ArrayList<StatusOfAudit>();
		for (Object[] row : result) {
			StatusOfAudit statusOfAudit = new StatusOfAudit();
			statusOfAudit.setCodProgram((String) row[0]);
			statusOfAudit.setDbt(row[1].toString());
			statusOfAudit.setTypeAudit(row[2].toString());
			statusOfAudit.setQty(((BigInteger) row[3]).intValue());
			listStatusOfAudits.add(statusOfAudit);
		}
		return listStatusOfAudits;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StatusOfAudit> selectAuditLate(String codProgram, String dbt, Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("call procedure_traffic_light_audit_late(?, ?, ?, ?)");
		query.setParameter(1, codProgram);
		query.setParameter(2, dbt);
		query.setParameter(3, initialDate);
		query.setParameter(4, endDate);
		List<Object[]> result = query.getResultList();
		List<StatusOfAudit> listStatusOfAudits = new ArrayList<StatusOfAudit>();
		for (Object[] row : result) {
			StatusOfAudit statusOfAudit = new StatusOfAudit();
			statusOfAudit.setCodProgram((String) row[0]);
			statusOfAudit.setDbt(row[1].toString());
			statusOfAudit.setTypeAudit(row[2].toString());
			statusOfAudit.setQty(((BigInteger) row[3]).intValue());
			listStatusOfAudits.add(statusOfAudit);
		}
		return listStatusOfAudits;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StatusOfAudit> selectAuditAnswered(String codProgram,
			String dbt, Date initialDate, Date endDate) {
		Query query = getEntityManager
				.createNativeQuery("call procedure_traffic_light_audit_answered(?, ?, ?, ?)");
		query.setParameter(1, codProgram);
		query.setParameter(2, dbt);
		query.setParameter(3, initialDate);
		query.setParameter(4, endDate);
		List<Object[]> result = query.getResultList();
		List<StatusOfAudit> listStatusOfAudits = new ArrayList<StatusOfAudit>();
		for (Object[] row : result) {
			StatusOfAudit statusOfAudit = new StatusOfAudit();
			statusOfAudit.setCodProgram((String) row[0]);
			statusOfAudit.setDbt(row[1].toString());
			statusOfAudit.setTypeAudit(row[2].toString());
			statusOfAudit.setQty(((BigInteger) row[3]).intValue());
			listStatusOfAudits.add(statusOfAudit);
		}
		return listStatusOfAudits;
	}

}
