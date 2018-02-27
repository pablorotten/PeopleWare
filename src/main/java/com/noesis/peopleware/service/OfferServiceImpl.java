package com.noesis.peopleware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noesis.peopleware.dao.OfferDAO;
import com.noesis.peopleware.model.Offer;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {

	@Autowired
	private OfferDAO offerDAO;

	@Override
	@Transactional
	public void addOffer(Offer offer) {
		offerDAO.addOffer(offer);
	}

	@Override
	@Transactional
	public List<Offer> getAllOffers() {
		return offerDAO.getAllOffers();
	}

	public Offer getOffer(int id) {
		return offerDAO.getOffer(id);
	}

	public void setOfferDAO(OfferDAO offerDAO) {
		this.offerDAO = offerDAO;
	}

    public Offer updateOffer(Offer offer) {
        // TODO Auto-generated method stub
        return offerDAO.updateOffer(offer);
    }
}
