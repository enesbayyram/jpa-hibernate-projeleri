package com.proje.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "advertisement")
@NamedQueries({
	@NamedQuery(name = "Advertisement.getAllAdvertisement",query = "SELECT a FROM Advertisement a"),
	@NamedQuery(name = "Advertisement.getAdvertisementById",query = "SELECT a FROM Advertisement a LEFT JOIN FETCH a.educationList WHERE a.advertisementId=:advertisementId"),
	@NamedQuery(name = "Advertisement.getAdvertisementByUsername",
				query = "SELECT a FROM User u LEFT JOIN u.userDetail ud LEFT JOIN ud.advertisementList a WHERE u.username=:username"
			)
})
public class Advertisement implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer advertisementId;
	
	private String title;
	
	@Lob
	private String workDefination;
	
	@Lob
	private String criteria;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate =new Date();
	
	private Date updateDate;
	
	private Date removeDate;
	
	private boolean enabled=false;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinTable(name = "advertisement_educationList",joinColumns = @JoinColumn(name="advertisementId"),
													inverseJoinColumns = @JoinColumn(name="educationId"))
	private List<Education> educationList =new ArrayList<>();

	@ManyToOne(fetch =  FetchType.LAZY,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userDetailId")
	private UserDetail userDetail;
	
	public Advertisement() {

	}

	public Advertisement(String title, String workDefination, String criteria, boolean enabled,List<Education> educations) {
		this.title = title;
		this.workDefination = workDefination;
		this.criteria = criteria;
		this.enabled = enabled;
		this.educationList = educations;
	}
	
	public void addEducation(Education education)
	{
		this.getEducationList().add(education);
	}
	
	public void addUserDetail(UserDetail userDetail)
	{
		this.userDetail=userDetail;
	}

	public Integer getAdvertisementId() {
		return advertisementId;
	}

	public void setAdvertisementId(Integer advertisementId) {
		this.advertisementId = advertisementId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkDefination() {
		return workDefination;
	}

	public void setWorkDefination(String workDefination) {
		this.workDefination = workDefination;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getRemoveDate() {
		return removeDate;
	}

	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Education> getEducationList() {
		return educationList;
	}

	public void setEducationList(List<Education> educationList) {
		this.educationList = educationList;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	@Override
	public String toString() {
		return "Advertisement [advertisementId=" + advertisementId + ", title=" + title + ", workDefination="
				+ workDefination + ", criteria=" + criteria + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", removeDate=" + removeDate + ", enabled=" + enabled + "]";
	}
}
