package org.strasa.web.updatestudy.view;

import java.util.ArrayList;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;

public class DetailedMissingGermplasmList {

	private Component mainView;
	private Binder parBinder;
	private ArrayList<String> invalidGermplasmList;

	public Component getMainView() {
		return mainView;
	}

	public void setMainView(Component mainView) {
		this.mainView = mainView;
	}

	public Binder getParBinder() {
		return parBinder;
	}

	public void setParBinder(Binder parBinder) {
		this.parBinder = parBinder;
	}

	public ArrayList<String> getInvalidGermplasmList() {
		return invalidGermplasmList;
	}

	public void setInvalidGermplasmList(ArrayList<String> invalidGermplasmList) {
		this.invalidGermplasmList = invalidGermplasmList;
	}

	@Init
	public void Init(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx, @ContextParam(ContextType.VIEW) Component view, @ExecutionArgParam("list") ArrayList<String> invalidGermList) {

		mainView = view;
		// parBinder = (Binder) view.getParent().getAttribute("binder");

		invalidGermplasmList = invalidGermList;

	}
}
