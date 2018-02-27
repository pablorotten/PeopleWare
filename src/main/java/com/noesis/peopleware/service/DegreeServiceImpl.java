package com.noesis.peopleware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noesis.peopleware.dao.DegreeDAO;
import com.noesis.peopleware.model.Degree;

@Service
@Transactional
public class DegreeServiceImpl implements DegreeService {

	@Autowired
	private DegreeDAO degreeDAO;

//	@Override
//	@Transactional
//	public void addDegree(Degree degree) {
//		degreeDAO.addDegree(degree);
//	}

	@Override
	@Transactional
	public List<Degree> getAllDegrees() {
		return degreeDAO.getAllDegrees();
	}

	public Degree getDegree(Integer id) {
		return degreeDAO.getDegree(id);
	}

//	public void setDegreeDAO(DegreeDAO degreeDAO) {
//		this.degreeDAO = degreeDAO;
//	}

//    public Degree updateDegree(Degree degree) {
//        // TODO Auto-generated method stub
//        return degreeDAO.updateDegree(degree);
//    }
}
