package org.strasa.extensiondata.chart;

import org.zkoss.zul.CategoryModel;
import org.zkoss.zul.SimpleCategoryModel;

public class ChartData {
    
    public static CategoryModel getModelByCountry() {
        CategoryModel model = new SimpleCategoryModel();
        String[] category = { "Country"};
 
        model.setValue(category[0], "Philippines", new Integer(40));
        model.setValue(category[0], "India", new Integer(55));
        model.setValue(category[0], "Africa", new Integer(65));
        model.setValue(category[0], "Bangladesh", new Integer(57));

        
//        model.setValue(category[1], "2010", new Integer(20));
//        model.setValue(category[1], "2011", new Integer(30));
//        model.setValue(category[1], "2012", new Integer(40));
//        model.setValue(category[1], "2013", new Integer(45));
        return model;
    }
    
    public static CategoryModel getModelByYear() {
        CategoryModel model = new SimpleCategoryModel();
        String[] category = { "Year"};

        model.setValue(category[0], "2010", new Integer(20));
        model.setValue(category[0], "2011", new Integer(30));
        model.setValue(category[0], "2012", new Integer(40));
        model.setValue(category[0], "2013", new Integer(45));
        return model;
    }
}