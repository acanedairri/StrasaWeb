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
import org.zkoss.zul.Messagebox;

public class EditUser extends RegistrationModel {

	UserManagerImpl userMan;
	@Init
	public void init(@ContextParam(ContextType.VIEW) Component view){
		userMan = new UserManagerImpl();
		
		setUser(userMan.getUserById(1));
	}

	private String dateFormat;
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public String getForegroundColour() {
		return foregroundColour;
	}
	public void setForegroundColour(String foregroundColour) {
		this.foregroundColour = foregroundColour;
	}
	public String getBackgroundColour() {
		return backgroundColour;
	}
	public void setBackgroundColour(String backgroundColour) {
		this.backgroundColour = backgroundColour;
	}
	private String foregroundColour = "#000000", backgroundColour = "#FDC966";


	@Command
	@NotifyChange("captcha")
	public void regenerate() {
		this.regenerateCaptcha();
	}

	@Command
	public void update() {
		userMan.updateUser(getUser());
		Messagebox.show("Program successfully added to database!", "OK", Messagebox.OK, Messagebox.INFORMATION);
	}
}
