package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyLocationMapper;
import org.strasa.middleware.model.StudyLocation;
import org.strasa.middleware.model.StudyRawDataByDataColumn;

public class StudyLocationManagerImpl {

	public void addStudyLocation(StudyLocation record){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyLocationMapper studyLocationMapper = session.getMapper(StudyLocationMapper.class);

		try{
			studyLocationMapper.insert(record);
			session.commit();

		}finally{
			session.close();
		}

	}


	public void addStudyLocation(ArrayList<StudyLocation> records){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyLocationMapper studyLocationMapper = session.getMapper(StudyLocationMapper.class);

		try{
			for(StudyLocation record:records){
				studyLocationMapper.insert(record);
			}
			session.commit();

		}finally{
			session.close();
		}

	}


	public void updateStudyLocation(List<StudyLocation> Locations){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyLocationMapper studyLocationMapper = session.getMapper(StudyLocationMapper.class);

		try{
			for(StudyLocation record:Locations){
				studyLocationMapper.updateByPrimaryKey(record);
			}
			session.commit();

		}finally{
			session.close();
		}

	}


	public List<StudyLocation> getAllStudyLocations(int studyId) {
		// TODO Auto-generated method stub
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyLocationMapper studyLocationMapper = session.getMapper(StudyLocationMapper.class);
		try{
			List<StudyLocation> studyLocations = studyLocationMapper.selectByExample(null);
			return studyLocations;
		}finally{
			session.close();
		}

	}

	private void addEmptyRecordOnStudyLocation(int studyId) {
		// TODO Auto-generated method stub
		StudyLocation record = new StudyLocation();
		//		record.setId(studyId);
		record.setStudyid(studyId);
		addStudyLocation(record);
		System.out.println("Added Empty Record on Location");
	}


	public List<StudyLocation> initializeStudyLocations(int studyId) {
		// TODO Auto-generated method stub
		List<StudyLocation> studyLocations = getAllStudyLocations(studyId);
		if(studyLocations.isEmpty()){
			try {
				ArrayList<StudyRawDataByDataColumn> studyList = getStudyLocationByStudy(studyId);
				for(StudyRawDataByDataColumn s:studyList){
					StudyLocation record = new StudyLocation();
					record.setStudyid(s.getStudyid());
					record.setLocationid(new LocationManagerImpl().getLocationByLocationName(s.getDatavalue()).getId());
					
					addStudyLocation(record);
					System.out.println("added" + s.getDatavalue() + " to study id: "+ s.getStudyid());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(getAllStudyLocations(studyId).isEmpty()) addEmptyRecordOnStudyLocation(studyId);
		}
		return getAllStudyLocations(studyId);
		
	}


	public ArrayList<StudyRawDataByDataColumn> getStudyLocationByStudy(int studyId) throws Exception {
		StudyRawDataManagerImpl studyRawDataManagerImpl= new StudyRawDataManagerImpl();
		ArrayList<StudyRawDataByDataColumn> list= (ArrayList<StudyRawDataByDataColumn>) studyRawDataManagerImpl.getStudyRawDataColumn(studyId,"location");
		try{
			for(StudyRawDataByDataColumn s:list){
				System.out.println(s.getStudyid()+ " "+s.getDatacolumn()+ " "+ s.getDatavalue());
			}
		}catch(NullPointerException npe){//if still empty since there's no Location data on the rawdata table
			// TODO Auto-generated catch block
		}
		return list;
	}

}
