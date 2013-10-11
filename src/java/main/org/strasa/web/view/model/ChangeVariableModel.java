package org.strasa.web.view.model;
import org.strasa.web.data.model.VariableListData;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;

public class ChangeVariableModel {

	private Binder parBinder;
	
	 
    public VariableListData varData;
     
    public VariableListData getVarData() {
        return varData;
    }
 
	
	
	    @Command
	    @NotifyChange("variableData")
	    public void changeVar(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view ,@BindingParam("oldVar") String oldVar) {
	        System.out.print(oldVar);
	    }
}
