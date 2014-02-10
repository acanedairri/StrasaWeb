package org.strasa.extensiondata.chart;

import java.util.List;

import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.strasa.middleware.model.ExtensionData;
import org.strasa.web.extensiondata.view.model.ExtensionDataSummaryModel;
import org.zkoss.zul.CategoryModel;
import org.zkoss.zul.SimpleCategoryModel;

public class ChartData {
    
    public static CategoryModel getModelByCountry() {
        CategoryModel model = new SimpleCategoryModel();
        String[] category = { "Country"};
        
        ExtensionDataManagerImpl mgr= new ExtensionDataManagerImpl();
        List<ExtensionDataSummaryModel> list=null;//mgr.getCountOfGermplasmByCountrRealease();
        
        for(ExtensionDataSummaryModel d:list){
        	  model.setValue(category[0], d.getData(),d.getTotalCount());
        }
 
        return model;
    }
    
    public static CategoryModel getModelByYear() {
        CategoryModel model = new SimpleCategoryModel();
        String[] category = { "Year"};
        
        ExtensionDataManagerImpl mgr= new ExtensionDataManagerImpl();
        List<ExtensionDataSummaryModel> list=null;//mgr.getCountOfGermplasmByYear();
        
        for(ExtensionDataSummaryModel d:list){
      	  model.setValue(category[0], d.getData(),d.getTotalCount());
      }

        return model;
    }
}