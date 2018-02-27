package com.noesis.peopleware.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity(name = "Offer")
@Table(name = "OFFER")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String company;
    
    @Column
    private String name;
    
    @Column
    private String description;

    @Column
    private double salary_range_min;
    
    @Column
    private double salary_range_max;
    
    @Column
    private Integer working_time;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
        name = "OFFER_DEGREE", 
        joinColumns = {@JoinColumn(name = "offer_id")}, 
        inverseJoinColumns = {@JoinColumn(name = "degree_id")}
    )
    private Set<Degree> degrees = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
        name = "OFFER_SKILL", 
        joinColumns = {@JoinColumn(name = "offer_id")}, 
        inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    private Set<Skill> skills = new HashSet<>();
    
    public Offer() {}

    public Offer(String company, String name, String description, double salary_range_min, double salary_range_max, Integer working_time) {
        this.company = company;
        this.name = name;
        this.description = description;
        this.salary_range_min = salary_range_min;
        this.salary_range_max = salary_range_max;
        this.working_time = working_time;
    }
    
    public int getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getSalary_range_min() {
        return salary_range_min;
    }

    public double getSalary_range_max() {
        return salary_range_max;
    }

    public Integer getWorking_time() {
        return working_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSalary_range_min(double salary_range_min) {
        this.salary_range_min = salary_range_min;
    }

    public void setSalary_range_max(double salary_range_max) {
        this.salary_range_max = salary_range_max;
    }

    public void setWorking_time(Integer working_time) {
        this.working_time = working_time;
    }

    /*
     * Degrees Relationship
     */
    public Set<Degree> getDegrees() {
        return degrees;
    }
    public void setDegrees(Set<Degree> degrees) {
        this.degrees = degrees;
    }
    public void addDegree(Degree degree) {
        degrees.add(degree);
        degree.getOffers().add(this);
    } 
    public void removeDegree(Degree degree) {
        degrees.remove(degree);
        degree.getOffers().remove(this);
    }

    /*
     * Skills Relationship
     */
    public Set<Skill> getSkills() {
        return skills;
    }
    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
    public void addSkill(Skill skill) {
        skills.add(skill);
        skill.getOffers().add(this);
    } 
    public void removeSkill(Skill skill) {
        skills.remove(skill);
        skill.getOffers().remove(this);
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
         
        if (o == null || getClass() != o.getClass()) 
            return false;
         
        Offer offer = (Offer) o;
        return Objects.equals(company, offer.company) && Objects.equals(name, offer.name) && Objects.equals(description, offer.description);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(company, name, description);
    }

   }