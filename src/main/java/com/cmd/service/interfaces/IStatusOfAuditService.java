package com.cmd.service.interfaces;

import java.util.Date;
import java.util.List;

import com.cmd.model.StatusOfAudit;

public interface IStatusOfAuditService {
	public List<StatusOfAudit> selectAuditNew(String codProgram, String dbt, Date initialDate, Date endDate);
	public List<StatusOfAudit> selectAuditLate(String codProgram, String dbt, Date initialDate, Date endDate);
	public List<StatusOfAudit> selectAuditAnswered(String codProgram, String dbt, Date initialDate, Date endDate);
}
