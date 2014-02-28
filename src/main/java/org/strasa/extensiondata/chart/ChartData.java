package org.strasa.extensiondata.chart;

import java.util.List;

import org.strasa.middleware.manager.DistributionAndExtensionManagerImpl;
import org.strasa.middleware.model.ExtensionData;
import org.strasa.web.distributionandextension.view.model.DistributionAndExtensionSummaryModel;
import org.zkoss.zul.CategoryModel;
import org.zkoss.zul.SimpleCategoryModel;

public class ChartData {
    
    public static CategoryModel getModelByCountry() {
        CategoryModel model = new SimpleCategoryModel();
        String[] category = { "Country"};
        
        DistributionAndExtensionManagerImpl mgr= new DistributionAndExtensionManagerImpl();
        List<DistributionAndExtensionSummaryModel> list=null;//mgr.getCountOfGermplasmByCountrRealease();
        
        for(DistributionAndExtensionSummaryModel d:list){
        	  model.setValue(category[0], d.getData(),d.getTotalCount());
        }
 
        return model;
    }
    
    public static CategoryModel getModelByYear() {
        CategoryModel model = new SimpleCategoryModel();
        String[] category = { "Year"};
        
        DistributionAndExtensionManagerImpl mgr= new DistributionAndExtensionManagerImpl();
        List<DistributionAndExtensionSummaryModel> list=null;//mgr.getCountOfGermplasmByYear();
        
        for(DistributionAndExtensionSummaryModel d:list){
      	  model.setValue(category[0], d.getData(),d.getTotalCount());
      }

        return model;
    }
}