package com.noesis.peopleware.service;

import java.util.List;

import com.noesis.peopleware.model.Skill;

public interface SkillService {
	
//	public void addSkill(Skill skill);

	public List<Skill> getAllSkills();

	public Skill getSkill(int id);
	
//    public Skill updateApplicant(Skill applicant);

}
