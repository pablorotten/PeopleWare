package com.noesis.peopleware.dao;

import java.util.List;

import com.noesis.peopleware.model.Applicant;

public interface ApplicantDAO {
    
    public void addApplicant(Applicant applicant);

    public List<Applicant> getAllApplicants();
    
    public Applicant updateApplicant(Applicant applicant);

    public Applicant getApplicant(int id);	   
}
