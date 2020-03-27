package com.estafet.openshift.boost.console.api.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estafet.openshift.boost.console.api.user.model.User;
import com.estafet.openshift.boost.console.api.user.openshift.OpenShiftClient;
import com.openshift.restclient.model.user.IUser;

@Service
public class UserService {

	@Autowired
	private OpenShiftClient client;

	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();;
		List<IUser> iusers = client.getUsers();
		for (IUser iuser : iusers) {
		    User user = new User();
		    user.setName(iuser.getName());
		    user.setUid(iuser.getUID());
			users.add(user);
		}		
		return users;
	}
	
	
	public User getUserByName(String name) {
		System.out.println("Username: " + name);
		List<IUser> iusers = client.getUsers();
		for (IUser iuser : iusers) {
		    if (name.equals(iuser.getName())) {
		    	System.out.println("Got Iuser: " + iuser);
				User user = new User();
		    	user.setName(iuser.getName());
		    	user.setUid(iuser.getUID());
		    	System.out.println("Got user: " + user);
		    	return user;
		    }
		}
		return null;		
		
	}
	
	public User getUserByUid(String uid) {
		List<IUser> iusers = client.getUsers();
		for (IUser iuser : iusers) {
		    if (uid.equals(iuser.getUID())) {
				User user = new User();
		    	user.setName(iuser.getName());
		    	user.setUid(iuser.getUID());
		    	return user;
		    }
		}
		return null;		
		
	}
}
