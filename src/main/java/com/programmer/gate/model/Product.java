package com.programmer.gate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	@Lob
	private String description;
	private Double completed;
	private String result;
    private String feat_path;
    private String nom;
    private String htmlreport;
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((feat_path == null) ? 0 : feat_path.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (feat_path == null) {
			if (other.feat_path != null)
				return false;
		} else if (!feat_path.equals(other.feat_path))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "us")
	
	 private List<Scenario> scenarios=new ArrayList<Scenario>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "US [id=" + id + ", description=" + description + ", completed=" + completed + ", result=" + result
				+ ", feat_path=" + feat_path + ", nom=" + nom + ", scenarios=" + scenarios + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCompleted() {
		return completed;
	}

	public void setCompleted() {
		int succ = 0;
		int num=this.getScenarios().size();
		for(Scenario sc :this.getScenarios()) {
			if(sc.getResult()=="SUCCESS")
				succ=succ+1;
		}
		this.completed = (double) (succ/num)*100;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getFeat_path() {
		return feat_path;
	}

	public void setFeat_path(String feat_path) {
		this.feat_path = feat_path;
	}

	public List<Scenario> getScenarios() {
		return scenarios;
	}

	public void setSteps(List<Scenario> steps) {
		this.scenarios = steps;
	}
	
}
