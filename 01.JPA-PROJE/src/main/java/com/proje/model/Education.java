package com.proje.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "education")
@NamedQueries({
	@NamedQuery(name = "Education.getAllEducation",query = "SELECT e FROM Education e"),
	@NamedQuery(name = "Education.getEducationById",query = "SELECT e FROM Education e WHERE e.educationId=:educationId"),
	@NamedQuery(name = "Education.getWithAdvertisement",
				query = "SELECT e FROM Education e LEFT JOIN FETCH e.advertisementList WHERE e.educationId=:educationId")
})
public class Education implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;
	
	@Column(name = "educationName",length = 80,nullable = false)
	private String educationName;
	
	private int lisansYear;
	
	@ManyToMany(mappedBy = "educationList",fetch = FetchType.LAZY)
	private List<Advertisement> advertisementList =new ArrayList<>();
	
	public Education() {

	}

	public Education(String educationName, int lisansYear) {
		this.educationName = educationName;
		this.lisansYear = lisansYear;
	}

	public Integer getEducationId() {
		return educationId;
	}

	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}

	public String getEducationName() {
		return educationName;
	}

	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}

	public int getLisansYear() {
		return lisansYear;
	}

	public void setLisansYear(int lisansYear) {
		this.lisansYear = lisansYear;
	}

	public List<Advertisement> getAdvertisementList() {
		return advertisementList;
	}

	public void setAdvertisementList(List<Advertisement> advertisementList) {
		this.advertisementList = advertisementList;
	}

	@Override
	public String toString() {
		return "Education [educationId=" + educationId + ", educationName=" + educationName + ", lisansYear="
				+ lisansYear + ", advertisementList=" + advertisementList + "]";
	}
}
