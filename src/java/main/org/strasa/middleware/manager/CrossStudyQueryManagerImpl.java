package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.model.StudyVariable;
import org.strasa.web.crossstudyquery.view.model.CrossStudyQueryFilterModel;

public class CrossStudyQueryManagerImpl {

	public List<HashMap<String, String>> getCrossStudyQueryResult(
			ArrayList<CrossStudyQueryFilterModel> filters) {
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		try{

			List<HashMap<String,String>> toreturn= session.selectList("CrossStudyStudyQuery.getCrossStudyQueryResult",filters);
			
			return toreturn;
			
		}finally{
			session.close();
		}
		
		
	}
	
	public List<StudyVariable> getStudyVariable(){
			StudyVariableManagerImpl mgr= new StudyVariableManagerImpl();
			return mgr.getVariables();
	}

	public List<StudyVariable> getStudyVariableLike(String variable){
		StudyVariableManagerImpl mgr= new StudyVariableManagerImpl();
		return mgr.getVariablesLike(variable);
}

}
