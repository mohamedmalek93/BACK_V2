package com.programmer.gate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Step {
	@Id
	@GeneratedValue
	private Long id;
	@Lob
	private String description;
	@Lob
	private String sc_error;
	@ElementCollection
	private List<String> screenshots= new ArrayList<String>(); 
	@ElementCollection
	private List<String> images= new ArrayList<String>(); 
	 public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public List<String> getScreenshots() {
		return screenshots;
	}
	public void setScreenshots(List<String> screenshots) {
		this.screenshots = screenshots;
	}
	public String getSc_error() {
		return sc_error;
	}
	public void setSc_error(String sc_error) {
		this.sc_error = sc_error;
	}
	
	    private String result;
	    @ManyToOne(fetch = FetchType.LAZY )
	    @JoinColumn(name = "sc_id", nullable = false)
	    @JsonIgnore
	 private Scenario scenario ;
	 
	 public Scenario getScenario() {
		return scenario;
	}
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}
	
	@OneToOne(mappedBy = "step", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
	 private Incident incident;
	 private double duration ;
	 
	 public Incident getIncident() {
		return incident;
	}
	public void setIncidents(Incident incident) {
		this.incident = incident;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	}
	public Step(String description, String result) {
		super();
		this.description = description;
		this.result = result;
	}

	
	public Step() {
		// TODO Auto-generated constructor stub
	}
	
	
}
