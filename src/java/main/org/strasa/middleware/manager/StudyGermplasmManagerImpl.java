package org.strasa.middleware.manager;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmCharacteristicsMapper;
import org.strasa.middleware.mapper.StudyGermplasmCharacteristicsMapper;
import org.strasa.middleware.mapper.StudyGermplasmMapper;
import org.strasa.middleware.model.GermplasmCharacteristics;
import org.strasa.middleware.model.StudyGermplasm;
import org.strasa.middleware.model.StudyGermplasmCharacteristics;
import org.strasa.middleware.model.StudyGermplasmExample;
import org.strasa.web.uploadstudy.view.model.StudyGermplasmInfo.GermplasmDeepInfoModel;

public class StudyGermplasmManagerImpl {

	public StudyGermplasm getStudyGermplasmByName(String value) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyGermplasmMapper mapper = session
				.getMapper(StudyGermplasmMapper.class);

		try {
			StudyGermplasmExample example = new StudyGermplasmExample();
			example.createCriteria().andGermplasmnameEqualTo(value);
			return mapper.selectByExample(example).get(0);

		} finally {
			session.close();
		}
	}

	public List<StudyGermplasm> getStudyGermplasmByStudyId(int studyID) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyGermplasmMapper mapper = session
				.getMapper(StudyGermplasmMapper.class);

		try {
			StudyGermplasmExample example = new StudyGermplasmExample();
			example.createCriteria().andStudyidEqualTo(studyID);
			return mapper.selectByExample(example);

		} finally {
			session.close();
		}
	}

	public boolean isStudyGermplasmExisting(String value) {
		if (this.getStudyGermplasmByName(value) == null)
			return false;
		return true;
	}

	public int addStudyGermplasm(StudyGermplasm record) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyGermplasmMapper mapper = session
				.getMapper(StudyGermplasmMapper.class);
		try {
			mapper.insert(record);
			session.commit();
		} finally {
			session.close();
		}
		return record.getId();
	}

	public void addStudyGermplasm(List<StudyGermplasm> lstRecord) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession(ExecutorType.BATCH);
		StudyGermplasmMapper mapper = session
				.getMapper(StudyGermplasmMapper.class);

		try {
			for (StudyGermplasm record : lstRecord) {
				if (record.getId() == null) {
					mapper.insert(record);
				} else {
					mapper.updateByPrimaryKey(record);
				}
			
			}
			session.commit();
		} finally {
			session.close();
		}
	}

	public void addStudyGermplasm(List<StudyGermplasm> lstRecord,
			List<GermplasmCharacteristics> lstCharRecord) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession(ExecutorType.BATCH);
		StudyGermplasmMapper mapper = session
				.getMapper(StudyGermplasmMapper.class);
		try {
			System.out.println("Inserting StudyGermplasms");
			for (StudyGermplasm record : lstRecord) {
				if (record.getId() == null) {
					mapper.insert(record);
				} else {
					mapper.updateByPrimaryKey(record);
				}
				System.out.println("SID: " + record.getId());
			}
			GermplasmCharacteristicsMapper charmapper = session
					.getMapper(GermplasmCharacteristicsMapper.class);

			for (GermplasmCharacteristics record : lstCharRecord)
				charmapper.insert(record);

			session.commit();
		} finally {
			session.close();
		}
	}
	public void addStudyGermplasm(List<StudyGermplasm> lstRecord,
			List<StudyGermplasmCharacteristics> lstCharRecord, int studyID) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession(ExecutorType.BATCH);
		StudyGermplasmMapper mapper = session
				.getMapper(StudyGermplasmMapper.class);
		HashMap<String,Integer> studyidmap = new HashMap<String,Integer>();
		try {
			System.out.println("Inserting StudyGermplasms");
			for (StudyGermplasm record : lstRecord) {
				if (record.getId() == null) {
					record.setStudyid(studyID);
					mapper.insert(record);
				} else {
					mapper.updateByPrimaryKey(record);
				}
				studyidmap.put(record.getGermplasmname(), record.getId());
				System.out.println("SID: " + record.getId());
			}
			StudyGermplasmCharacteristicsMapper charmapper = session
					.getMapper(StudyGermplasmCharacteristicsMapper.class);

			for (StudyGermplasmCharacteristics record : lstCharRecord){
				
				record.setStudygermplasmid(studyidmap.get(record.getGermplasmname()));
				charmapper.insert(record);
			}
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void addStudyGermplasmBatch(List<GermplasmDeepInfoModel> lstRecord){
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyGermplasmMapper mapper = session
				.getMapper(StudyGermplasmMapper.class);
		StudyGermplasmCharacteristicsMapper charmapper = session
				.getMapper(StudyGermplasmCharacteristicsMapper.class);
		try {
			
			System.out.println("Inserting StudyGermplasms");
			for (GermplasmDeepInfoModel record : lstRecord) {
				StudyGermplasm newRec = record;
				
					
					mapper.insert(newRec);
				
				for (StudyGermplasmCharacteristics records : record.getCharacteristicValues()){
					
					records.setStudygermplasmid(newRec.getId());
					charmapper.insert(records);
				}
				System.out.println("SID: " + record.getId());
			}
	

			
			session.commit();
		} finally {
			session.close();
		}
	}

	public void updateStudyGermplasm(StudyGermplasm record) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyGermplasmMapper mapper = session
				.getMapper(StudyGermplasmMapper.class);
		try {
			mapper.updateByPrimaryKey(record);
			session.commit();
		} finally {
			session.close();
		}
		// return record.getId();
	}

}
