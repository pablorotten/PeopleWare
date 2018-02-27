package com.noesis.peopleware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noesis.peopleware.dao.ApplicantDAO;
import com.noesis.peopleware.model.Applicant;

@Service
@Transactional
public class ApplicantServiceImpl implements ApplicantService {

	@Autowired
	private ApplicantDAO applicantDAO;

	@Override
	@Transactional
	public void addApplicant(Applicant applicant) {
		applicantDAO.addApplicant(applicant);
	}

	@Override
	@Transactional
	public List<Applicant> getAllApplicants() {
		return applicantDAO.getAllApplicants();
	}

	public Applicant getApplicant(int id) {
		return applicantDAO.getApplicant(id);
	}

	public void setApplicantDAO(ApplicantDAO applicantDAO) {
		this.applicantDAO = applicantDAO;
	}

    public Applicant updateApplicant(Applicant applicant) {
        // TODO Auto-generated method stub
        return applicantDAO.updateApplicant(applicant);
    }
}
