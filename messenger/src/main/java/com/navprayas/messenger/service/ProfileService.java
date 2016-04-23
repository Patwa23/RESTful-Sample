package com.navprayas.messenger.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.navprayas.messenger.database.DatabaseClass;
import com.navprayas.messenger.database.HibernateDb;
import com.navprayas.messenger.exception.DataNotFoundException;
import com.navprayas.messenger.model.Address;
import com.navprayas.messenger.model.HibernateUtil;
import com.navprayas.messenger.model.Profile;
import com.navprayas.messenger.model.User;

public class ProfileService {
	private HibernateDb hDB=new HibernateDb();
	public ProfileService() {
		/*Address homeAddress=new Address();
		homeAddress.setStreet("Satgarawa");
		homeAddress.setCity("Gaya");
		homeAddress.setState("Bihar");
		homeAddress.setPincode("823003");
		
		Address officeAddress=new Address();
		officeAddress.setStreet("49 Buiteplein");
		officeAddress.setCity("Amstelveen");
		officeAddress.setState("Amsterdam");
		officeAddress.setPincode("1181 ZD");
		
		Profile profile1=new Profile("VikashProfile","Vikash","Patwa");
		
		profile1.getListOfAddresses().add(homeAddress);
		profile1.getListOfAddresses().add(officeAddress);		
		addProfile(profile1);
		
	//	System.out.println(profile1.getListOfAddresses().contains(officeAddress));
		
		Profile profile2=new Profile("PrakashProfile","Prakash","Patwa");
		profile2.getListOfAddresses().add(homeAddress);
		profile2.getListOfAddresses().add(officeAddress);
		
		addProfile(profile2);*/
	//	profiles.put(profile1.getProfileName(),profile1);
	//	profiles.put(profile2.getProfileName(),profile2);
				
	}
	
	/*public String getPath() {
	    return getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + "hibernate.cfg.xml";
	}*/
	
	
	public List<Profile> getAllProfiles(){
		return hDB.getAllProfiles();
	}
			
	public Profile getProfile(String profileName) {
		Profile profile=hDB.getProfile(profileName);
		if(profile==null){
			throw new DataNotFoundException("Profile not registered with name :"+profileName);
		}
		return profile;
	}
	
	public Profile addProfile(Profile profile){	
		return hDB.addProfile(profile);
	}
	
	public Profile updateProfile(Profile profile){		
		return hDB.updateProfile(profile);
	}
	
	public Profile removeProfile(String profileName){				
		return hDB.removeProfile(profileName);
	}
}