package com.noesis.peopleware.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noesis.peopleware.model.Degree;

@Repository
public class DegreeDAOImpl implements DegreeDAO {

    @Autowired
    private SessionFactory sessionFactory;	

//    public void addDegree(Degree degree) {
//        sessionFactory.getCurrentSession().saveOrUpdate(degree);
//    }
    
    @SuppressWarnings("unchecked")
    public List<Degree> getAllDegrees() {
        return sessionFactory.getCurrentSession().createQuery("from Degree").list();
    }

//    @Override
//    public Degree updateDegree(Degree degree) {
//        sessionFactory.getCurrentSession().update(degree);
//        return degree;
//    }
    
    public Degree getDegree(Integer id) {
        return (Degree) sessionFactory.getCurrentSession().get(Degree.class, id);
    }
}