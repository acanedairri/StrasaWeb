package org.strasa.web.crossstudyquery.view.model;

import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

public class  CrossRowRenderer implements RowRenderer<AcrossStudyData>{

	@Override
	public void render(Row row, AcrossStudyData data, int index) throws Exception {
		
		 Toolbarbutton studyNameLink=  new Toolbarbutton();
		 studyNameLink.setLabel(data.getStudyname());
		 row.appendChild(studyNameLink);
		
		 Toolbarbutton gNameLink=  new Toolbarbutton();
		 gNameLink.setLabel(data.getGname());
		 row.appendChild(gNameLink);
		 
		 for(String s: data.getOtherdata()){
			 row.appendChild(new Label(s));
			 
		 }
		 
	}
}	