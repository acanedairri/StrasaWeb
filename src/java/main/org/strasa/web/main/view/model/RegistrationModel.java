package org.strasa.web.main.view.model;

import org.strasa.middleware.model.User;

public class RegistrationModel  {

	private RegistrationCapthaGenerator rsg = new RegistrationCapthaGenerator(4);
	User user = new User();
	private String retypedPassword;
	private String captcha = rsg.getRandomString();
	private String captchaInput;

	public RegistrationCapthaGenerator getRsg() {
		return rsg;
	}
	public void setRsg(RegistrationCapthaGenerator rsg) {
		this.rsg = rsg;
	}
	public String getRetypedPassword() {
		return retypedPassword;
	}
	public void setRetypedPassword(String retypedPassword) {
		this.retypedPassword = retypedPassword;
	}

	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getCaptchaInput() {
		return captchaInput;
	}
	public void setCaptchaInput(String captchaInput) {
		this.captchaInput = captchaInput;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
    public void regenerateCaptcha() {
        this.captcha = rsg.getRandomString();
    }
	
	
	
}
