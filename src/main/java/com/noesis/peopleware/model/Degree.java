package com.noesis.peopleware.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEGREE")
public class Degree {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "degrees")
    private Set<Applicant> applicants = new HashSet<>();
    @ManyToMany(mappedBy = "degrees")
    private Set<Offer> offers = new HashSet<>();
    
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Applicant Relationship
     */
    public Set<Applicant> getApplicants() {
        return applicants;
    }
    public void setApplicants(Set<Applicant> applicants) {
        this.applicants = applicants;
    }

    /*
     * Offer Relationship
     */
    public Set<Offer> getOffers() {
        return offers;
    }
    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }  
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Degree))
            return false;
        Degree other = (Degree) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;

        return true;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
