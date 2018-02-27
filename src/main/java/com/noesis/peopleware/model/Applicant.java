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

@Entity(name = "Applicant")
@Table(name = "APPLICANT")
public class Applicant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column
    private String name;
    
    @Column
    private String surname;
    
    @Column
    private String email;
    
    @Column
    private String telephone;
    
    @Column
    private double minimum_salary;
    
    @Column
    private Integer working_time;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
        name = "APPLICANT_DEGREE", 
        joinColumns = {@JoinColumn(name = "applicant_id")}, 
        inverseJoinColumns = {@JoinColumn(name = "degree_id")}
    )
    private Set<Degree> degrees = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
        name = "APPLICANT_SKILL", 
        joinColumns = {@JoinColumn(name = "applicant_id")}, 
        inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    private Set<Skill> skills = new HashSet<>();
    
    public Applicant() {}

    public Applicant(String name, String surname, String email, String telephone, double minimum_salary, Integer working_time) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.telephone = telephone;
        this.minimum_salary = minimum_salary;
        this.working_time = working_time;
    }
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public String getTelephone() {
        return telephone;
    }
    public double getMinimum_salary() {
        return minimum_salary;
    }
    public Integer getWorking_time() {
        return working_time;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setMinimum_salary(double minimum_salary) {
        this.minimum_salary = minimum_salary;
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
        degree.getApplicants().add(this);
    } 
    public void removeDegree(Degree degree) {
        degrees.remove(degree);
        degree.getApplicants().remove(this);
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
        skill.getApplicants().add(this);
    } 
    public void removeSkill(Skill skill) {
        skills.remove(skill);
        skill.getApplicants().remove(this);
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
         
        if (o == null || getClass() != o.getClass()) 
            return false;
         
        Applicant applicant = (Applicant) o;
        return Objects.equals(name, applicant.name) && Objects.equals(surname, applicant.surname) && Objects.equals(email, applicant.email) && Objects.equals(telephone, applicant.telephone);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(name,surname,email,telephone);
    }
}