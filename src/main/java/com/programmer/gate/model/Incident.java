package com.programmer.gate.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity


public class Incident {
	@Id
	@GeneratedValue
	private Long id;
	private String qualif;
	@Lob
	String description;
	
	private String commentaire;
	 public String getComment() {
		return commentaire;
	}
	public void setComment(String comment) {
		this.commentaire = comment;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQualif() {
		return qualif;
	}
	public void setQualif(String qualif) {
		this.qualif = qualif;
	}
	@Enumerated(EnumType.STRING)
    private errorState state;
	public long getId() {
		return id;
	}
	public void setId() {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		 return "Incident [id=" + id + ", description=" + description + ", state=" + state + ", mainerror=" + mainerror
				+ ", step=" + step + "]";
	}
	public errorState getState() {
		return state;
	}
	public void setState(errorState state) {
		this.state = state;
	}
	public String getMainerror() {
		return mainerror;
	}
	public void setMainerror(String mainerror) {
		this.mainerror = mainerror;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Step step;
	public Step getStep() {
		return step;
	}
	public void setStep(Step step) {
		this.step = step;
	}
	private String mainerror;
	
	//private List<String> Errordetails;
}
