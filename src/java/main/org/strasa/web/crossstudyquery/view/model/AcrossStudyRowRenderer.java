package org.strasa.web.crossstudyquery.view.model;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Window;

public class  AcrossStudyRowRenderer implements RowRenderer<AcrossStudyData>{

	@Override
	public void render(Row row, final AcrossStudyData data, int index) throws Exception {

//		row.appendChild(new Label(String.valueOf(data.getStudyId())));
		
		Toolbarbutton studyNameLink=  new Toolbarbutton();
		studyNameLink.setLabel(data.getStudyname());
		studyNameLink.addEventListener(Events.ON_CLICK, new EventListener<Event>() {

			@Override
			public void onEvent(Event arg0) throws Exception {
				// TODO Auto-generated method stub

				Window studyDetailWindow = (Window)Executions.getCurrent().createComponents(
						"/user/browsegermplasm/studydetails.zul", null, null);
				studyDetailWindow.doModal();
				studyDetailWindow.setTitle(data.getStudyname());

				Include studyInformationPage = new Include();
				studyInformationPage.setSrc("/user/browsestudy/studyinformation.zul");
				studyInformationPage.setParent(studyDetailWindow);
				studyInformationPage.setDynamicProperty("studyId",data.getStudyId());
			}

		});

		row.appendChild(studyNameLink);

		Toolbarbutton gNameLink=  new Toolbarbutton();
		gNameLink.setLabel(data.getGname());
		row.appendChild(gNameLink);

		for(String s: data.getOtherdata()){
			row.appendChild(new Label(s));

		}

	}
}	