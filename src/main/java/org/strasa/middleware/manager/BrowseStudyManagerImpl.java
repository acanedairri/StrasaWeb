package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.other.StudySummaryMapper;
import org.strasa.middleware.model.StudyDataColumn;
import org.strasa.web.browsestudy.view.model.StudyDataColumnModel;
import org.strasa.web.browsestudy.view.model.StudySearchFilterModel;
import org.strasa.web.browsestudy.view.model.StudySearchResultModel;
import org.strasa.web.browsestudy.view.model.StudySummaryModel;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class BrowseStudyManagerImpl {

	@WireVariable
	ConnectionFactory connectionFactory;
	
	public List<StudySummaryModel> getStudySummary() {
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
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
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		try{

			List<StudySearchResultModel> toreturn= session.selectList("BrowseStudy.getStudySearchResult",filter);

			return toreturn;

		}finally{
			session.close();
		}


	}

	public List<HashMap<String,String>> getStudyData(int studyId,String dataType, int dataset){
		List<HashMap<String,String>> toreturn = new ArrayList<HashMap<String,String>>();
		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
		try{
			StudyDataColumnManagerImpl mgr= new StudyDataColumnManagerImpl();

			List<StudyDataColumn> studyDataColumn =mgr.getStudyDataColumnByStudyId(studyId,dataType,dataset);
			ArrayList<StudyDataColumnModel> dataColumns= new ArrayList<StudyDataColumnModel>();

			int count=1;
			int columnCount=studyDataColumn.size();
			for(StudyDataColumn s: studyDataColumn){
				StudyDataColumnModel m= new StudyDataColumnModel();
				m.setColumnheader(s.getColumnheader());
				m.setStudyid(s.getStudyid());
				m.setOrder(count);
				m.setCount(columnCount);
				m.setDataset(s.getDataset());
				dataColumns.add(m);
				count++;
			}
			
			System.out.println(studyDataColumn.toString());

			if(!studyDataColumn.isEmpty()){
				if(dataType.equals("rd")){
					toreturn= session.selectList("BrowseStudy.getStudyRawData",dataColumns);
				}else{
					toreturn= session.selectList("BrowseStudy.getStudyDerivedData",dataColumns);
				}
			}
			return toreturn;

		}finally{
			session.close();
		}


	}




}
