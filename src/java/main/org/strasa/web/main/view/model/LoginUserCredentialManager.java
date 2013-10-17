package org.strasa.web.main.view.model;

import java.util.List;

import org.strasa.middleware.manager.UserManagerImpl;
import org.strasa.middleware.model.User;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;

/**
 * @author zkessentials store
 * 
 *         This class provides a class which manages user authentication
 * 
 */
public class LoginUserCredentialManager {

	private static final String KEY_USER_MODEL = LoginUserCredentialManager.class
			.getName()
			+ "_MODEL";
	private User user;

	private LoginUserCredentialManager() {
	}

	public static LoginUserCredentialManager getIntance() {
		Session session = Executions.getCurrent().getSession();
		synchronized (session) {
			LoginUserCredentialManager userModel = (LoginUserCredentialManager) session
					.getAttribute(KEY_USER_MODEL);
			if (userModel == null) {
				session.setAttribute(KEY_USER_MODEL,
						userModel = new LoginUserCredentialManager());
			}
			return userModel;
		}
	}

	public synchronized void login(String username, String password) {
		UserManagerImpl userManagerImpl= new UserManagerImpl();
		List<User> tempUser = userManagerImpl.getUser(username, password);
	
			if (tempUser != null && tempUser.get(0).getPassword().equals(password)) {
				user = tempUser.get(0);
			} else {
				user = null;
			}
		
	}

	public synchronized void logOff() {
		this.user = null;
	}

	public synchronized User getUser() {
		return user;
	}

	public synchronized boolean isAuthenticated() {
		return user != null;
	}

}
