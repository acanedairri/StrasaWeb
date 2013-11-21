/* 
	Description:
		ZK Essentials
	History:
		Created by dennis

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.strasa.web.page.navigation.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.strasa.web.page.util.navigation.SidebarPage;
import org.strasa.web.page.util.navigation.SidebarPageConfig;

public class SidebarPageConfigAjaxBasedImpl implements SidebarPageConfig{
	
	HashMap<String,SidebarPage> pageMap = new LinkedHashMap<String,SidebarPage>();
	public SidebarPageConfigAjaxBasedImpl(){		
		
		pageMap.put("upload_study",new SidebarPage("upload_data","Upload New Study","/images/upload.png","/user/uploadstudy/index.zul"));
		pageMap.put("fn2",new SidebarPage("fn2","Upload Data to Exsisting Study","/images/fn.png","/user/home.zul"));
		pageMap.put("browse_study",new SidebarPage("browse_study","Browse Study","/images/fn.png","/user/browsestudy/index.zul"));
		pageMap.put("browse_germplasm",new SidebarPage("browse_germplasm","Browse Germplasm","/images/fn.png","/user/germplasmquery/germplasmquery.zul"));
		pageMap.put("crossquery",new SidebarPage("cross_study_query","Cross Study Query","/images/fn.png","/user/home.zul"));
		pageMap.put("analysis",new SidebarPage("analysis","Analysis","/images/fn.png","/user/home.zul"));
	}
	
	public List<SidebarPage> getPages(){
		return new ArrayList<SidebarPage>(pageMap.values());
	}
	
	public SidebarPage getPage(String name){
		return pageMap.get(name);
	}
	
}