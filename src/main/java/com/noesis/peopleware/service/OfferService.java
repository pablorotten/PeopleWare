package com.noesis.peopleware.service;

import java.util.List;

import com.noesis.peopleware.model.Offer;

public interface OfferService {
	
	public void addOffer(Offer offer);

	public List<Offer> getAllOffers();

	public Offer getOffer(int id);
	
    public Offer updateOffer(Offer offer);

}
