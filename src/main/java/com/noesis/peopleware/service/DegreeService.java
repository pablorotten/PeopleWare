package com.noesis.peopleware.service;

import java.util.List;

import com.noesis.peopleware.model.Degree;

public interface DegreeService {
	
//	public void addDegree(Degree degree);

	public List<Degree> getAllDegrees();

	public Degree getDegree(Integer id);
	
//    public Degree updateApplicant(Degree applicant);

}
