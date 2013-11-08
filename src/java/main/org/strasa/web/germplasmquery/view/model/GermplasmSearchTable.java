package org.strasa.web.germplasmquery.view.model;

import java.util.List;

import org.strasa.middleware.manager.GermplasmQueryManagerImpl;
import org.strasa.middleware.model.Germplasm;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;

public class GermplasmSearchTable {
	    private GermplasmQueryManagerImpl germplasmQueryMan = new GermplasmQueryManagerImpl();
	    
	    private GermplasmSearchResultModel searchFilter = new GermplasmSearchResultModel();
	    
	    private List<Germplasm> germplasmnames = germplasmQueryMan.initializeGermplasmQuerys(1);
	    private Integer selectedSearchGermplasm = 0;
	    private boolean angel = true;
	    
	    public List<Germplasm> getGermplasmnames() {
			return germplasmnames;
		}
		public void setGermplasmnames(List<Germplasm> germplasmnames) {
			this.germplasmnames = germplasmnames;
		}
		public GermplasmSearchResultModel getSearchFilter() {
			return searchFilter;
		}
		public void setSearchFilter(GermplasmSearchResultModel searchFilter) {
			this.searchFilter = searchFilter;
		}
		public Integer getSelectedSearchGermplasm() {
			return selectedSearchGermplasm;
		}
		public void setSelectedSearchGermplasm(Integer selectedSearchGermplasm) {
			this.selectedSearchGermplasm = selectedSearchGermplasm;
		}
		public boolean isAngel() {
			return angel;
		}
		public void setAngel(boolean angel) {
			this.angel = angel;
		}

		@Command("viewKeyChar")
		@NotifyChange("*")
		public void viewKeyChar(@BindingParam("selectedGermplasmSearch") String selected){
			System.out.println("selected "+ selected);
			if(selected.equals("Name")) angel=true;
			else angel=false;
		}
	
	}
