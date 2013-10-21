package org.strasa.web.admin.view.model;

import java.util.List;

import org.strasa.middleware.manager.UserManagerImpl;
import org.strasa.middleware.model.User;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Messagebox;

public class UserManagement {


	List<User> users;

	public List<User> getUser() {
		return users = this.getAllRegisteredUser();
	}


	public List<User> getAllRegisteredUser(){

		UserManagerImpl userManagerImpl= new UserManagerImpl();
		List<User> users=userManagerImpl.getAllRegisteredUser();
		return users;

	}

	@NotifyChange("*")
	@Command("onChecked")
	public void addUser(@BindingParam("user") User user){
		UserManagerImpl userManagerImp =  new UserManagerImpl();
		userManagerImp.updateUser(user);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@NotifyChange("*")
	@Command("deleteUser")
	public void deleteUser(@BindingParam("user") final User user){
		
		Messagebox.show("Are you sure to delete this user?", "Confirm Dialog", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, new org.zkoss.zk.ui.event.EventListener() {
			public void onEvent(Event evt) throws InterruptedException {
				if (evt.getName().equals("onOK")) {
					UserManagerImpl userManagerImp =  new UserManagerImpl();
					userManagerImp.deleteUser(user);
				} 
			}
		});
	}

}
