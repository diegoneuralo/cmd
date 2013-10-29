package com.cmd.service.interfaces;

import java.util.Date;
import java.util.List;

import com.cmd.model.DrawingReleasedInOE;

public interface IDrawingReleasedInOEService {
	
	public List<Object[]> selectPlannedDwgWeek(String codProgram, Date initialDate, Date endDate);
	public List<DrawingReleasedInOE> selectPlannedDwgMonthly(String codProgram, Date initialDate, Date endDate);
	public List<DrawingReleasedInOE> selectPlannedDwgYearly(String codProgram, Date initialDate, Date endDate);
	public List<DrawingReleasedInOE> selectReleasedDwgWeek(String codProgram, Date initialDate, Date endDate);
	public List<DrawingReleasedInOE> selectReleasedDwgMonthly(String codProgram, Date initialDate, Date endDate);
	public List<DrawingReleasedInOE> selectReleasedDwgYearly(String codProgram, Date initialDate, Date endDate);
	
}
