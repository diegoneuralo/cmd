package com.cmd.service.interfaces;

import java.util.List;

import com.cmd.model.Aircraft;

public interface IAircraftService {
	
	public List<Aircraft> selectProgram();
	public List<Aircraft> selectModel(String codProject);
	public List<Aircraft> selectDbt(String codProject);
	
}
