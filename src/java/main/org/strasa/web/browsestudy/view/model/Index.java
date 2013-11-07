package org.strasa.web.browsestudy.view.model;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Tabpanel;

public class Index{
	
	@NotifyChange("*")
	@Command
	public void refreshTab() { 
	}
}