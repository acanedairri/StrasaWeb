package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudySiteMapper;
import org.strasa.middleware.model.StudyRawDataByDataColumn;
import org.strasa.middleware.model.StudySite;

public class StudySiteManagerImpl {

	public void addStudySite(StudySite record){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudySiteMapper studySiteMapper = session.getMapper(StudySiteMapper.class);

		try{
			studySiteMapper.insert(record);
			session.commit();

		}finally{
			session.close();
		}

	}


	public void addStudySite(ArrayList<StudySite> records){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudySiteMapper studySiteMapper = session.getMapper(StudySiteMapper.class);

		try{
			for(StudySite record:records){
				studySiteMapper.insert(record);
			}
			session.commit();

		}finally{
			session.close();
		}

	}


	public void updateStudySite(ArrayList<StudySite> records){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudySiteMapper studySiteMapper = session.getMapper(StudySiteMapper.class);

		try{
			for(StudySite record:records){
				studySiteMapper.updateByPrimaryKey(record);
			}
			session.commit();

		}finally{
			session.close();
		}

	}


	public List<StudySite> getAllStudySites(int studyId) {
		// TODO Auto-generated method stub
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudySiteMapper studySiteMapper = session.getMapper(StudySiteMapper.class);

		try{
			List<StudySite> studySites = studySiteMapper.selectByExample(null);
			if(studySites.isEmpty()){
				studySites = initializeStudySites(studyId);
			}
			return studySites;

		}finally{
			session.close();
		}
	}
	
	private List<StudySite> initializeStudySites(int studyId) {
		// TODO Auto-generated method stub
			try {
				ArrayList<StudyRawDataByDataColumn> studyList = getStudySiteByStudy(studyId);
				for(StudyRawDataByDataColumn s:studyList){
					StudySite record = new StudySite();
					record.setStudyid(s.getStudyid());
					record.setSitename(s.getDatavalue());
					
					addStudySite(record);
					System.out.println("added" + s.getDatavalue() + " to study id: "+ s.getStudyid());
				}
				return getAllStudySites(studyId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}


	public ArrayList<StudyRawDataByDataColumn> getStudySiteByStudy(int studyId) throws Exception {
		StudyRawDataManagerImpl studyRawDataManagerImpl= new StudyRawDataManagerImpl();
		ArrayList<StudyRawDataByDataColumn> list= (ArrayList<StudyRawDataByDataColumn>) studyRawDataManagerImpl.getStudyRawDataSite(studyId,"site");
		for(StudyRawDataByDataColumn s:list){
			System.out.println(s.getStudyid()+ " "+s.getDatacolumn()+ " "+ s.getDatavalue());
		}
		return list;
	}




}
