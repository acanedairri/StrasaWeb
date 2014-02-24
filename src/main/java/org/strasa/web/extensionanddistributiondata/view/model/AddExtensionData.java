package org.strasa.web.extensionanddistributiondata.view.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.strasa.middleware.manager.CountryManagerImpl;
import org.strasa.middleware.manager.EcotypeManagerImpl;
import org.strasa.middleware.manager.ExtensionDataManagerImpl;
import org.strasa.middleware.manager.ProgramManagerImpl;
import org.strasa.middleware.manager.ProjectManagerImpl;
import org.strasa.middleware.model.Country;
import org.strasa.middleware.model.Ecotype;
import org.strasa.middleware.model.ExtensionData;
import org.strasa.middleware.model.Program;
import org.strasa.middleware.model.Project;
import org.strasa.web.common.api.FormValidator;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Binder;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Messagebox;

public class AddExtensionData {
	public static String ZUL_PATH = "/user/extension/addextensiondata.zul";
	
	ProgramManagerImpl programMan;
	ProjectManagerImpl projectMan;
	
	private ExtensionData model = new ExtensionData();
	private ArrayList<String> cmbCountry = new ArrayList<String>(); 
	private List<Program> programList= null;
	private List<Project> projectList= null;
	
	private Program program= new Program();
	private Project project= new Project();

	public ExtensionData getModel() {
		return model;
	}
	public void setModel(ExtensionData model) {
		this.model = model;
	}
	private Component mainView;
	private Binder parBinder;

	@Init
	public void Init(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx,@ContextParam(ContextType.VIEW) Component view ,@ExecutionArgParam("oldVar")  String oldVar) {
	        mainView = view;
	        parBinder =  (Binder) view.getParent().getAttribute("binder");
	        
	        programMan = new ProgramManagerImpl();
	    	projectMan = new ProjectManagerImpl();
	    	setProgramList(new ArrayList<Program>());
			for(Program p: programMan.getAllProgram()){
				if(!projectMan.getProjectByProgramId(p.getId()).isEmpty())programList.add(p);
			}
	    	setProjectList(projectMan.getAllProject());
	    	setProject(projectList.get(0));
	    	setProjectList(projectMan.getProjectByProgramId(project.getProgramid()));
	    	setProgram(programMan.getProgramById(project.getProgramid()));
	    	
	    	List<Country> lCountries = new CountryManagerImpl().getAllCountry();
			for (Country data : lCountries) {
				cmbCountry.add(data.getIsoabbr());
			}
	}
	
	@Command("add")
	public void add(@ContextParam(ContextType.COMPONENT) Component component, @ContextParam(ContextType.VIEW) Component view){
		Combobox programComboBox = (Combobox) component.getFellow("programComboBox");
		Combobox projectComboBox = (Combobox) component.getFellow("projectComboBox");
		
		ExtensionDataManagerImpl man = new ExtensionDataManagerImpl();
		
		model.setProgramid((Integer)programComboBox.getSelectedItem().getValue());
		model.setProjectid((Integer)projectComboBox.getSelectedItem().getValue());
		
		if(man.getAllExtensionDataAsString().contains(model.getDatasource())){
			Messagebox.show("Extension data already exist! Choose a different name.", "OK", Messagebox.OK, Messagebox.EXCLAMATION);
			return;
		}
		try {
			if(model.getGermplasmname().isEmpty()){

				Messagebox.show("Please enter a name", "OK", Messagebox.OK, Messagebox.EXCLAMATION);
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO IMPORTANT!!! Must change this to real UserID
		man.addExtensionData(model);
		
		//TODO Validate!!
		Messagebox.show("Successfully added to database!", "OK", Messagebox.OK, Messagebox.INFORMATION);
//		System.out.println("SavePath: "+CsvPath);
		
		
		Binder bind = parBinder;
		if (bind == null)
			return;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("selected",model);

		// this.parBinder.postCommand("change", params);
		bind.postCommand("refreshList", params);
		mainView.detach();
	}
	@Command
	public void cancel(){
		mainView.detach();
	}
	
	@NotifyChange("projectList")
	@Command
	public void updateLists(@ContextParam(ContextType.COMPONENT) Component component,
			@ContextParam(ContextType.VIEW) Component view, @BindingParam("program") Comboitem program){
		Combobox projectComboBox = (Combobox) component.getFellow("projectComboBox");
		
		try{
		setProjectList(projectMan.getProjectByProgramId((Integer)program.getValue()));
		projectComboBox.setValue(projectList.get(0).getName());
		BindUtils.postNotifyChange(null, null,
				AddExtensionData.this, "projectList");
		}catch(RuntimeException re){
			setProjectList(projectMan.getAllProject());
		}
	}
	public ArrayList<String> getCmbCountry() {
		return cmbCountry;
	}

	public void setCmbCountry(ArrayList<String> cmbCountry) {
		this.cmbCountry = cmbCountry;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<Program> getProgramList() {
		return programList;
	}
	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}
	public List<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	
}
