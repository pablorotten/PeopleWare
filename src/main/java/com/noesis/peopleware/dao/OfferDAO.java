package com.noesis.peopleware.dao;

import java.util.List;

import com.noesis.peopleware.model.Offer;

public interface OfferDAO {
    
    public void addOffer(Offer offer);

    public List<Offer> getAllOffers();
    
    public Offer updateOffer(Offer offer);

    public Offer getOffer(int id);	   
}
