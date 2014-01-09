package com.cmd.service.interfaces;

import java.util.Date;
import java.util.List;

import com.cmd.model.CurveReleaseSerie;

public interface ICurveReleaseService {
	
	public List<CurveReleaseSerie> selectCurveReleaseDaneWeek(String codProgram, Date initialDate, Date endDate);
	public List<CurveReleaseSerie> selectCurveReleaseDaneMonthly(String codProgram, Date initialDate, Date endDate);
	
	public List<CurveReleaseSerie> selectCurveReleasePlanWeek(String codProgram, Date initialDate, Date endDate);
	public List<CurveReleaseSerie> selectCurveReleasePlanMonthly(String codProgram, Date initialDate, Date endDate);
	
	public List<CurveReleaseSerie> selectCurveReleaseLibWeek(String codProgram, Date initialDate, Date endDate);
	public List<CurveReleaseSerie> selectCurveReleaseLibMonthly(String codProgram, Date initialDate, Date endDate);

	
}
