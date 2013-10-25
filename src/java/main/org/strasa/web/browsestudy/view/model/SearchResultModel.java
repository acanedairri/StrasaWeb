package org.strasa.web.browsestudy.view.model;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.model.StudyLocation;

public class SearchResultModel extends StudyLocation{
	
	List<SearchResultModel> study= new ArrayList<SearchResultModel>();
	String country;
	String location;

}
