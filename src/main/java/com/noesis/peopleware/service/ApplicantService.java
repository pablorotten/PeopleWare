package com.noesis.peopleware.service;

import java.util.List;

import com.noesis.peopleware.model.Applicant;

public interface ApplicantService {
	
	public void addApplicant(Applicant applicant);

	public List<Applicant> getAllApplicants();

	public Applicant getApplicant(int id);
	
    public Applicant updateApplicant(Applicant applicant);

}
