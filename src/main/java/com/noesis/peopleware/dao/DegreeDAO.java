package com.noesis.peopleware.dao;

import java.util.List;

import com.noesis.peopleware.model.Degree;

public interface DegreeDAO {
    
//    public void addDegree(Degree degree);

    public List<Degree> getAllDegrees();
    
//    public Degree updateDegree(Degree degree);

    public Degree getDegree(Integer id);	   
}
