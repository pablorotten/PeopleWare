package com.noesis.peopleware.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noesis.peopleware.model.Applicant;

@Repository
public class ApplicantDAOImpl implements ApplicantDAO {

    @Autowired
    private SessionFactory sessionFactory;	

    public void addApplicant(Applicant applicant) {
        sessionFactory.getCurrentSession().saveOrUpdate(applicant);
    }
    
    @SuppressWarnings("unchecked")
    public List<Applicant> getAllApplicants() {
        return sessionFactory.getCurrentSession().createQuery("from Applicant").list();
    }

    @Override
    public Applicant updateApplicant(Applicant applicant) {
        sessionFactory.getCurrentSession().update(applicant);
        return applicant;
    }
    
    public Applicant getApplicant(int id) {
//        Applicant applicant = (Applicant) sessionFactory.getCurrentSession().get(Applicant.class, id);
//        if(applicant!=null){
//            Hibernate.initialize(applicant.getDegrees());
//        }
//        return applicant;
        return (Applicant) sessionFactory.getCurrentSession().get(Applicant.class, id);
    }
}