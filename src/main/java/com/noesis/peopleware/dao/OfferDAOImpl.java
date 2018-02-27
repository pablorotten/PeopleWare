package com.noesis.peopleware.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noesis.peopleware.model.Offer;

@Repository
public class OfferDAOImpl implements OfferDAO {

    @Autowired
    private SessionFactory sessionFactory;	

    public void addOffer(Offer offer) {
        sessionFactory.getCurrentSession().saveOrUpdate(offer);
    }
    
    @SuppressWarnings("unchecked")
    public List<Offer> getAllOffers() {
        return sessionFactory.getCurrentSession().createQuery("from Offer").list();
    }

    @Override
    public Offer updateOffer(Offer offer) {
        sessionFactory.getCurrentSession().update(offer);
        return offer;
    }
    
    public Offer getOffer(int id) {
//        Offer offer = (Offer) sessionFactory.getCurrentSession().get(Offer.class, id);
//        if(offer!=null){
//            Hibernate.initialize(offer.getDegrees());
//        }
//        return offer;
        return (Offer) sessionFactory.getCurrentSession().get(Offer.class, id);
    }
}