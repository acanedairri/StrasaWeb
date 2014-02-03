package org.strasa.web.crossstudyquery.view.model;

import java.util.HashMap;
import java.util.Map;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

public class  AcrossStudyRowRenderer implements RowRenderer<AcrossStudyData>{

	
	private Tab crossstudySearchTab;
//	private Binder parBinder;
	
	@Init
	public void setInitialData(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view,@ExecutionArgParam("crossstudySearchTab")Tab crossstudySearchTab){
		this.crossstudySearchTab = crossstudySearchTab;
//        parBinder =  (Binder) view.getParent().getAttribute("binder");
	}
	
	@Override
	public void render(Row row, final AcrossStudyData data, int index) throws Exception {

//		row.appendChild(new Label(String.valueOf(data.getStudyId())));
		
		Toolbarbutton studyNameLink=  new Toolbarbutton();
		studyNameLink.setLabel(data.getStudyname());
		studyNameLink.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event arg0) throws Exception {
				// TODO Auto-generated method stub

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("studyid",data.getStudyId());
				params.put("studyName",data.getStudyname());
				
				BindUtils.postGlobalCommand(null, null, "openStudyDetailInAcrossStudy", params);
			}

		});

		row.appendChild(studyNameLink);

		Toolbarbutton gNameLink=  new Toolbarbutton();
		gNameLink.setLabel(data.getGname());
		row.appendChild(gNameLink);
		gNameLink.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event arg0) throws Exception {
				// TODO Auto-generated method stub

				Map<String, Object> params = new HashMap<String, Object>();
				params.put("gname",data.getGname());
				
				BindUtils.postGlobalCommand(null, null, "openGermplasmDetailInAcrossStudy", params);
			}

		});

		for(String s: data.getOtherdata()){
			row.appendChild(new Label(s));

		}

	}
}	