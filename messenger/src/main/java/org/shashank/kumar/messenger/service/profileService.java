/**
 * 
 */
package org.shashank.kumar.messenger.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.shashank.kumar.messenger.database.DatabaseClass;
import org.shashank.kumar.messenger.model.Message;
import org.shashank.kumar.messenger.model.Profile;


public class profileService {

	
	public profileService() {

	}

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public List<Profile> getAllProfiles() {

		List<Profile> list = Collections.list(Collections.enumeration(profiles.values()));

		return list;
	}
	
	public Object getProfile(String profileName) {

		return profiles.get(profileName);

	}
	
	public Profile addProfile(Profile Profile) {

		Profile.setId(profiles.size() + 1);
		Profile.setCreated(new Date());
		profiles.put(Profile.getProfileName(), Profile);
		
		return Profile ;
	}
	
	public Profile deleteProfile(String profileName) {

		profiles.remove(profileName);
		return null ;
	}

	
}
