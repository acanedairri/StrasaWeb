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
				rec.setStudyTypeIdPbt(1);
				List<StudySummaryModel> pbtStudyType= mapper.selectCountOfStudyByStudyType(p.getProgramId(),rec.getStudyTypeIdPbt());
				rec.setCountPbt(pbtStudyType.get(0).getCountStudyTypeId());

				// count StypeType OnFarm
				rec.setStudyTypeIdOnFarm(2);
				List<StudySummaryModel> onFarmStudyType= mapper.selectCountOfStudyByStudyType(p.getProgramId(), rec.getStudyTypeIdOnFarm());
				rec.setCountOnFarm(onFarmStudyType.get(0).getCountStudyTypeId());

				// count StypeType Experiment Station
				rec.setStudyTypeIdExperiment(3);
				List<StudySummaryModel> experimentStudyType= mapper.selectCountOfStudyByStudyType(p.getProgramId(), rec.getStudyTypeIdExperiment());
				rec.setCountExperiment(experimentStudyType.get(0).getCountStudyTypeId());

				// count StypeType Glass House
				rec.setStudytypeIdGlassHouse(4);
				List<StudySummaryModel> glassHouseStudyType= mapper.selectCountOfStudyByStudyType(p.getProgramId(), rec.getStudytypeIdGlassHouse());
				rec.setCountGlassHouse(glassHouseStudyType.get(0).getCountStudyTypeId());

				// count StypeType Lab
				rec.setStudyTypeIdLab(5);
				List<StudySummaryModel> labStudyType= mapper.selectCountOfStudyByStudyType(p.getProgramId(), rec.getStudyTypeIdLab());
				rec.setCountLab(labStudyType.get(0).getCountStudyTypeId());
				
				System.out.println("rec:"+rec.toString());
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
