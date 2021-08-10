package com.proje.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.proje.model.util.PhoneType;

@Entity
@Table(name="userDetail")
@NamedQueries({
	@NamedQuery(name = "UserDetail.getAllUserDetail",query = "SELECT ud FROM UserDetail ud"),
	@NamedQuery(name = "UserDetail.getUserDetailByUsername",query = "SELECT ud FROM UserDetail ud WHERE ud.user.username=:username"),
	@NamedQuery(name = "UserDetail.getWithPhoneListUserDetailByUsername",
			query = "SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.phoneList WHERE ud.user.username=:username")
})
public class UserDetail implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userDetailId;
	
	@Column(name = "firstname",length = 30,nullable = false)
	private String firstName;
	
	@Column(name = "lastname",length = 40,nullable = false)
	private String lastName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthOfDate;
	
	@OneToOne
	private User user;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "userDetail_phoneList",  joinColumns = @JoinColumn(name="userDetailId"))
	@MapKeyColumn(name = "phoneType")
	@Column(name = "phoneNumber")
	private Map<PhoneType, String> phoneList = new HashMap<>();
	
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "userDetail_addressList",joinColumns = @JoinColumn(name="userDetailId"))
	private List<Address> addressList =new ArrayList<Address>();
	
	@OneToMany(mappedBy = "userDetail",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
	private List<Advertisement> advertisementList =new ArrayList<>();
	
	public UserDetail() {

	}

	public UserDetail(String firstName, String lastName, Date birthOfDate, Map<PhoneType, String> phoneList,
			List<Address> addressList, List<Advertisement> advertisementList) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthOfDate = birthOfDate;
		this.phoneList = phoneList;
		this.addressList = addressList;
		this.advertisementList = advertisementList;
	}
	
	public void addUser(User user)
	{
		this.user=user;
	}

	public Integer getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Integer userDetailId) {
		this.userDetailId = userDetailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthOfDate() {
		return birthOfDate;
	}

	public void setBirthOfDate(Date birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<PhoneType, String> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(Map<PhoneType, String> phoneList) {
		this.phoneList = phoneList;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public List<Advertisement> getAdvertisementList() {
		return advertisementList;
	}

	public void setAdvertisementList(List<Advertisement> advertisementList) {
		this.advertisementList = advertisementList;
	}

	@Override
	public String toString() {
		return "UserDetail [userDetailId=" + userDetailId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthOfDate=" + birthOfDate + ", phoneList=" + phoneList + "]";
	}
}
