package com.navprayas.messenger.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.Type;


@XmlRootElement
@Entity
@Table(name="PR0FILE")
public class Profile {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="PROFILE_ID") // This can be also placed just above getter method and it will always consider that getter (return value)
	private int profileId;
//	@Column(name="PROFILE_NAME")
	private String profileName;
//	@Column(name="FNAME")
	private String firstName;
//	@Column(name="LNAME")
	private String lastName;
//	@Column(name="CREATED_DATE")
//	@Transient   //Transient or Static -hibernate is not persistence
	@Temporal(TemporalType.DATE)
	private Date created;
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="PROFILE_ADDRESS",joinColumns=@JoinColumn(name="PROFILE_ID"))
	@GenericGenerator(name="sequence-gen",strategy="sequence")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "sequence-gen", type = @Type(type="long"))
	private Collection<Address> listOfAddresses=new ArrayList<Address>();
	/*@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="HOME_STREET_NAME")),
		@AttributeOverride(name="city",column=@Column(name="HOME_CITY_NAME")),
		@AttributeOverride(name="state",column=@Column(name="HOME_STATE_NAME")),
		@AttributeOverride(name="pincode",column=@Column(name="HOME_PIN_CODE"))
	})	
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street",column=@Column(name="OFFICE_STREET_NAME")),
		@AttributeOverride(name="city",column=@Column(name="OFFICE_CITY_NAME")),
		@AttributeOverride(name="state",column=@Column(name="OFFICE_STATE_NAME")),
		@AttributeOverride(name="pincode",column=@Column(name="OFFICE_PIN_CODE"))
	})
	private Address officeAddress;*/
	
	public Profile(){		
	}

	public Profile(String profileName, String firstName,String lastName) {
		//this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created=new Date();
	//	this.homeAddress = homeAddress;
	//	this.officeAddress=officeAddress;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}



	/*public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}*/

	
	
	
}
