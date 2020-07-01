package com.programmer.gate.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Scenario {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String result;
	private  Boolean Pending=false;
	private String pendresult;
	private float errordays;
	private float penddays;

	public String getPendresult() {
		return pendresult;
	}
	public void setPendresult(String pendresult) {
		this.pendresult = pendresult;
	}
	public float getErrordays() {
		return errordays;
	}
	public void setErrordays(float errordays) {
		this.errordays = errordays;
	}
	public float getPenddays() {
		return penddays;
	}
	public void setPenddays(float penddays) {
		this.penddays = penddays;
	}
	public void setPending(Boolean pending) {
		Pending = pending;
	}
	public Boolean getPending() {
		return Pending;
	}
	public void setPending() {
		if(this.Pending==false) {
			this.Pending=true;
			this.pendresult="PENDING" ;
		}
		else 
		{
			this.Pending=true;
			this.pendresult=this.result;
			
	}
	}
	public Product getUs() {
		return us;
	}
	public void setUs(Product us) {
		this.us = us;
	}
	private  String dates ;
	private qualification qualif;
	 public qualification getQualif() {
		return qualif;
	}
	public void setQualif(qualification qualif) {
		this.qualif = qualif;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "scenario")
	
	private List<Step> steps=new ArrayList<Step>();
	 private double duration ;
	 @Temporal(TemporalType.DATE)
	    private Date date_sc;
	
	 public Date getDate_sc() {
		return date_sc;
	}
	public void setDate_sc(Date date_sc) {
		this.date_sc = date_sc;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "us_id", nullable = true)
	@JsonIgnore
	 private Product us;
	 public List<Step> getSteps() {
		return steps;
	}
	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	
	
	public void setsteps(List<Step> steps) {
		this.steps = steps;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
		
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
		setPending();
	}
	@Override
	public String toString() {
		return "Scenario [id=" + id + ", description=" + description + ", result=" + result + ", steps=" + steps
				+ ", duration=" + duration + ", errortype=" + errortype + "]";
	}
	private String errortype;
	public String getErrortype() {
		return errortype;
	}
	public void setErrortype(String errortype) {
		this.errortype = errortype;
	}
}
