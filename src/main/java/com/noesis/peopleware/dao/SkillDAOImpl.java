package com.noesis.peopleware.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.noesis.peopleware.model.Skill;

@Repository
public class SkillDAOImpl implements SkillDAO {

    @Autowired
    private SessionFactory sessionFactory;	

//    public void addSkill(Skill skill) {
//        sessionFactory.getCurrentSession().saveOrUpdate(skill);
//    }
    
    @SuppressWarnings("unchecked")
    public List<Skill> getAllSkills() {
        return sessionFactory.getCurrentSession().createQuery("from Skill").list();
    }

//    @Override
//    public Skill updateSkill(Skill skill) {
//        sessionFactory.getCurrentSession().update(skill);
//        return skill;
//    }
    
    public Skill getSkill(int id) {
        return (Skill) sessionFactory.getCurrentSession().get(Skill.class, id);
    }
}