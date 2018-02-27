package com.noesis.peopleware.dao;

import java.util.List;

import com.noesis.peopleware.model.Skill;

public interface SkillDAO {
    
//    public void addSkill(Skill skill);

    public List<Skill> getAllSkills();
    
//    public Skill updateSkill(Skill skill);

    public Skill getSkill(int id);	   
}
