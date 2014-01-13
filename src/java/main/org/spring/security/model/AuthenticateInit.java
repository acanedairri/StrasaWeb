package org.spring.security.model;

import javax.servlet.http.HttpServletResponse;

import org.spring.security.model.SecurityUtil;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Map;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;

public class AuthenticateInit extends org.zkoss.zk.ui.util.GenericInitiator{

	@Init
	public void doInit(Page page, Map args) throws Exception {
		
		if(SecurityUtil.isAnyGranted("ROLE_ADMIN")){
			Execution exec = Executions.getCurrent();
			HttpServletResponse response = (HttpServletResponse)exec.getNativeResponse();
			response.sendRedirect(response.encodeRedirectURL("admin/index.zul")); //assume there is /login
			exec.setVoided(true); //no
		}else if(SecurityUtil.isAnyGranted("ROLE_USER")){
			Execution exec = Executions.getCurrent();
			HttpServletResponse response = (HttpServletResponse)exec.getNativeResponse();
			response.sendRedirect(response.encodeRedirectURL("user/index.zul")); //assume there is /login
			exec.setVoided(true); //no
		}
		
	}

}
