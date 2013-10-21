package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyAgronomyMapper;
import org.strasa.middleware.mapper.StudySiteMapper;
import org.strasa.middleware.model.StudyAgronomy;
import org.strasa.middleware.model.StudyRawDataByDataColumn;
import org.strasa.middleware.model.StudySite;

public class StudyAgronomyManagerImpl {

	public void addStudyAgronomy(StudyAgronomy record){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyAgronomyMapper studyAgronomyMapper = session.getMapper(StudyAgronomyMapper.class);

		try{
			studyAgronomyMapper.insert(record);
			session.commit();

		}finally{
			session.close();
		}

	}

	public void addStudyAgronomy(ArrayList<StudyAgronomy> records){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyAgronomyMapper studyAgronomyMapper = session.getMapper(StudyAgronomyMapper.class);

		try{
			for(StudyAgronomy record:records){
				studyAgronomyMapper.insert(record);
			}
			session.commit();

		}finally{
			session.close();
		}

	}

	public void updateStudyAgronomy(List<StudyAgronomy> agroInfo){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyAgronomyMapper studyAgronomyMapper = session.getMapper(StudyAgronomyMapper.class);

		try{
			for(StudyAgronomy record:agroInfo){
				studyAgronomyMapper.updateByPrimaryKey(record);
			}
			session.commit();

		}finally{
			session.close();
		}

	}


	public List<StudyAgronomy> getAllStudyAgronomy() {
		// TODO Auto-generated method stub
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		StudyAgronomyMapper studyAgronomyMapper = session.getMapper(StudyAgronomyMapper.class);
		try{
			List<StudyAgronomy> studyAgronomy = studyAgronomyMapper.selectByExample(null);
			return studyAgronomy;
		}finally{
			session.close();
		}
	}

	private void addEmptyRecordOnStudyAgronomy(int studySiteId) {
		// TODO Auto-generated method stub
		StudyAgronomy record = new StudyAgronomy();
		record.setStudysiteid(studySiteId);

		addStudyAgronomy(record);
		System.out.println("added empty record to studySiteId " + Integer.toString(studySiteId));
	}




	public List<StudyAgronomy> initializeStudyAgronomy(List<StudySite> sites) {
		// TODO Auto-generated method stub
		try {
			List<StudyAgronomy> studyAgroInfoList = getAllStudyAgronomy();
			if(studyAgroInfoList.isEmpty()){
				for(StudySite site:sites){//for each site
					addEmptyRecordOnStudyAgronomy(site.getId());
				}
				studyAgroInfoList = getAllStudyAgronomy();
			}
			return studyAgroInfoList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
