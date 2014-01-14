package org.strasa.web.maintenance.view.model;

import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.UserManagerImpl;
import org.strasa.web.main.view.model.RegistrationModel;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;

public class EditUser extends RegistrationModel {

	UserManagerImpl userMan;
	@Init
	public void init(@ContextParam(ContextType.VIEW) Component view){
		userMan = new UserManagerImpl();
		
		setUser(userMan.getUserById(1));
	}

}
