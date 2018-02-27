package com.noesis.peopleware.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noesis.peopleware.dao.SkillDAO;
import com.noesis.peopleware.model.Skill;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillDAO skillDAO;

//	@Override
//	@Transactional
//	public void addSkill(Skill skill) {
//		skillDAO.addSkill(skill);
//	}

	@Override
	@Transactional
	public List<Skill> getAllSkills() {
		return skillDAO.getAllSkills();
	}

	public Skill getSkill(int id) {
		return skillDAO.getSkill(id);
	}

//	public void setSkillDAO(SkillDAO skillDAO) {
//		this.skillDAO = skillDAO;
//	}

//    public Skill updateSkill(Skill skill) {
//        // TODO Auto-generated method stub
//        return skillDAO.updateSkill(skill);
//    }
}
