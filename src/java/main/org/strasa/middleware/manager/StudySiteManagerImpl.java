package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudySiteMapper;
import org.strasa.middleware.model.StudyRawDataByDataColumn;
import org.strasa.middleware.model.StudySite;
import org.strasa.middleware.model.StudySiteExample;

public class StudySiteManagerImpl {

	
	private boolean isRaw = true;
	public StudySiteManagerImpl (boolean isRaw){
		this.isRaw = isRaw;
	}
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


	public void updateStudySite(List<StudySite> sites){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudySiteMapper studySiteMapper = session.getMapper(StudySiteMapper.class);

		try{
			for(StudySite record:sites){
				if(record.getId() == null) 
					studySiteMapper.insert(record);
				else{
					studySiteMapper.updateByPrimaryKey(record);
				}
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
			StudySiteExample example = new StudySiteExample();
			example.createCriteria().andStudyidEqualTo(studyId);
			List<StudySite> studySites = studySiteMapper.selectByExample(example);
			return studySites;
		}finally{
			session.close();
		}

	}

	private void addEmptyRecordOnStudySite(int studyId) {
		// TODO Auto-generated method stub
		StudySite record = new StudySite();
		//		record.setId(studyId);
		record.setStudyid(studyId);
		record.setEcotypeid(1);
		addStudySite(record);
		System.out.println("Added Empty Record on site");
	}


	public List<StudySite> initializeStudySites(int studyId) {
		// TODO Auto-generated method stub
		List<StudySite> studySites = getAllStudySites(studyId);
		if(studySites.isEmpty()){
			try {
				ArrayList<StudyRawDataByDataColumn> studyList = getStudySiteByStudy(studyId);
				for(StudyRawDataByDataColumn s:studyList){
					StudySite record = new StudySite();
					record.setStudyid(s.getStudyid());
					record.setSitename(s.getDatavalue());
					record.setEcotypeid(1);
					addStudySite(record);
					System.out.println("added" + s.getDatavalue() + " to study id: "+ s.getStudyid());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(getAllStudySites(studyId).isEmpty()) addEmptyRecordOnStudySite(studyId);
		}
		return getAllStudySites(studyId);
		
	}


	public ArrayList<StudyRawDataByDataColumn> getStudySiteByStudy(int studyId) throws Exception {
		StudyRawDataManagerImpl studyRawDataManagerImpl= new StudyRawDataManagerImpl(isRaw);
		ArrayList<StudyRawDataByDataColumn> list= (ArrayList<StudyRawDataByDataColumn>) studyRawDataManagerImpl.getStudyRawDataColumn(studyId,"site");
		try{
			for(StudyRawDataByDataColumn s:list){
				System.out.println(s.getStudyid()+ " "+s.getDatacolumn()+ " "+ s.getDatavalue());
			}
		}catch(NullPointerException npe){//if still empty since there's no site data on the rawdata table
			// TODO Auto-generated catch block
		}
		return list;
	}

}
