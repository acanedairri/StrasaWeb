package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.other.StudySummaryMapper;
import org.strasa.web.browsestudy.view.model.StudySearchFilterModel;
import org.strasa.web.browsestudy.view.model.StudySearchResultModel;
import org.strasa.web.browsestudy.view.model.StudySummaryModel;

public class BrowseStudyManagerImpl {


	public List<StudySummaryModel> getStudySummary() {
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudySummaryMapper mapper = session.getMapper(StudySummaryMapper.class);
		List<StudySummaryModel> s= new ArrayList<StudySummaryModel>();
		try{

			List<StudySummaryModel> distinctProgram= mapper.selectDistinctProgram();
			for(StudySummaryModel p:distinctProgram){
				StudySummaryModel rec=new StudySummaryModel();
				rec.setProgramId(p.getProgramId());
				rec.setProgramName(p.getProgramName());
				List<StudySummaryModel> projectCount= mapper.selectDistinctProjectByProgramId(p.getProgramId());
				rec.setProjectCount(projectCount.size());
				List<StudySummaryModel> studyCount= mapper.countStudyByProgram(p.getProgramId());
				rec.setStudyCount(studyCount.get(0).getStudyCount());

				// count StypeType PBT
				List<StudySummaryModel> pbtStudyType= mapper.selectCountOfStudyByStudyType(p.getProgramId(),1);
				rec.setStudyTypeIdPbt(pbtStudyType.get(0).getStudyTypeId());
				rec.setCountPbt(pbtStudyType.get(0).getCountStudyTypeId());

				// count StypeType OnFarm
				List<StudySummaryModel> onFarmStudyType= mapper.selectCountOfStudyByStudyType(p.getProgramId(), 2);
				rec.setStudyTypeIdOnFarm(onFarmStudyType.get(0).getStudyTypeId());
				rec.setCountOnFarm(onFarmStudyType.get(0).getCountStudyTypeId());

				// count StypeType Experiment Station
				List<StudySummaryModel> experimentStudyType= mapper.selectCountOfStudyByStudyType(p.getProgramId(), 3);
				rec.setStudyTypeIdExperiment(experimentStudyType.get(0).getStudyTypeId());
				rec.setCountExperiment(experimentStudyType.get(0).getCountStudyTypeId());

				// count StypeType Glass House
				List<StudySummaryModel> glassHouseStudyType= mapper.selectCountOfStudyByStudyType(p.getProgramId(), 4);
				rec.setStudytypeIdGlassHouse(glassHouseStudyType.get(0).getStudyTypeId());
				rec.setCountGlassHouse(glassHouseStudyType.get(0).getCountStudyTypeId());

				// count StypeType Lab
				List<StudySummaryModel> labStudyType= mapper.selectCountOfStudyByStudyType(p.getProgramId(), 5);
				rec.setStudyTypeIdLab(labStudyType.get(0).getStudyTypeId());
				rec.setCountLab(labStudyType.get(0).getCountStudyTypeId());

				s.add(rec);

			}
			return s;

		}finally{
			session.close();
		}

	}
	
	
	public List<StudySearchResultModel> getStudySearchResult(StudySearchFilterModel filter) {
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		try{
			
			List<StudySearchResultModel> toreturn= session.selectList("BrowseStudy.getStudySearchResult",filter);
			
			return toreturn;
			
		}finally{
			session.close();
		}
		
		
	}


}
