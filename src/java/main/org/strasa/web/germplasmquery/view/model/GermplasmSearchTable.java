package org.strasa.web.germplasmquery.view.model;

import java.util.List;

import org.strasa.middleware.manager.GermplasmQueryManagerImpl;
import org.strasa.middleware.model.Germplasm;

public class GermplasmSearchTable {
	    private GermplasmQueryManagerImpl germplasmQueryMan = new GermplasmQueryManagerImpl();
	    private GermplasmSearchResultModel searchFilter = new GermplasmSearchResultModel();
	    private List<Germplasm> germplasmnames = germplasmQueryMan.initializeGermplasmQuerys(1);
	    
	    
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
	}
