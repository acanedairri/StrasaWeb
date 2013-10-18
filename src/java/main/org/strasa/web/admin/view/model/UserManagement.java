package org.strasa.web.admin.view.model;

import java.util.List;

import org.strasa.middleware.manager.UserManagerImpl;
import org.strasa.middleware.model.User;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class UserManagement {


	List<User> user;

	public List<User> getUser() {
		return user = this.getAllRegisteredUser();
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<User> getAllRegisteredUser(){
		
		UserManagerImpl userManagerImpl= new UserManagerImpl();
		List<User> users=userManagerImpl.getAllRegisteredUser();
		return users;
		
	}
	
	@NotifyChange("*")
	@Command("onChecked")
	public void addProject(@BindingParam("user") User user){
		UserManagerImpl userManagerImp =  new UserManagerImpl();
		userManagerImp.updateUser(user);
	}


}
