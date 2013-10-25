package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmMapper;
import org.strasa.middleware.mapper.StudyGermplasmCharacteristicMapper;
import org.strasa.middleware.model.StudyGermplasmCharacteristic;
import org.strasa.middleware.model.StudyGermplasmCharacteristicExample;

public class StudyGermplasmCharactersticManagerImpl {

	public boolean isCharacteristicExist(String attribute, String value, int id, String germplasmName) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();

		try {
			StudyGermplasmCharacteristicMapper mapper = session
					.getMapper(StudyGermplasmCharacteristicMapper.class);
			StudyGermplasmCharacteristicExample example = new StudyGermplasmCharacteristicExample();
			example.createCriteria().andStudyidEqualTo(id).andAttributeEqualTo(attribute).andValueEqualTo(value).andGermplasmnameEqualTo(germplasmName);
			return !mapper.selectByExample(example).isEmpty();
			
		} finally {
			session.close();
		}
	}

	public List<StudyGermplasmCharacteristic> getAllCharacteristic() {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();

		try {
			StudyGermplasmCharacteristicMapper mapper = session
					.getMapper(StudyGermplasmCharacteristicMapper.class);

			return mapper.selectByExample(null);

		} finally {
			session.close();
		}
	}

	public List<StudyGermplasmCharacteristic> getAbioticStress(
			String germplasmName, int studyID) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();

		try {
			StudyGermplasmCharacteristicMapper mapper = session
					.getMapper(StudyGermplasmCharacteristicMapper.class);
			StudyGermplasmCharacteristicExample example = new StudyGermplasmCharacteristicExample();
			example.createCriteria().andAttributeEqualTo("Abiotic Stress")
					.andStudyidEqualTo(studyID)
					.andGermplasmnameEqualTo(germplasmName);
			return mapper.selectByExample(example);

		} finally {
			session.close();
		}
	}

	public List<StudyGermplasmCharacteristic> getBioticStress(
			String germplasmName, int studyID) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();

		try {
			StudyGermplasmCharacteristicMapper mapper = session
					.getMapper(StudyGermplasmCharacteristicMapper.class);
			StudyGermplasmCharacteristicExample example = new StudyGermplasmCharacteristicExample();
			example.createCriteria().andAttributeEqualTo("Abiotic Stress")
					.andStudyidEqualTo(studyID)
					.andGermplasmnameEqualTo(germplasmName);
			return mapper.selectByExample(example);

		} finally {
			session.close();
		}
	}

	public List<StudyGermplasmCharacteristic> getGrainQualityStress(
			String germplasmName, int studyID) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();

		try {
			StudyGermplasmCharacteristicMapper mapper = session
					.getMapper(StudyGermplasmCharacteristicMapper.class);
			StudyGermplasmCharacteristicExample example = new StudyGermplasmCharacteristicExample();
			example.createCriteria().andAttributeEqualTo("Grain Quality")
					.andStudyidEqualTo(studyID)
					.andGermplasmnameEqualTo(germplasmName);
			return mapper.selectByExample(example);

		} finally {
			session.close();
		}
	}

	public List<StudyGermplasmCharacteristic> getMajorGenesStress() {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();

		try {
			StudyGermplasmCharacteristicMapper mapper = session
					.getMapper(StudyGermplasmCharacteristicMapper.class);
			StudyGermplasmCharacteristicExample example = new StudyGermplasmCharacteristicExample();
			example.createCriteria().andAttributeEqualTo("Major Genes");
			return mapper.selectByExample(example);

		} finally {
			session.close();
		}
	}
	
	public List<StudyGermplasmCharacteristic> getCharacteristicsByStudyID( int id) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();

		try {
			StudyGermplasmCharacteristicMapper mapper = session
					.getMapper(StudyGermplasmCharacteristicMapper.class);
			StudyGermplasmCharacteristicExample example = new StudyGermplasmCharacteristicExample();
			example.createCriteria().andStudyidEqualTo(id);
			return mapper.selectByExample(example);

		} finally {
			session.close();
		}
	}

	public void deleteCharacteristicsByStudyID(int studyID) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();

		try {
			StudyGermplasmCharacteristicMapper mapper = session
					.getMapper(StudyGermplasmCharacteristicMapper.class);
			StudyGermplasmCharacteristicExample example = new StudyGermplasmCharacteristicExample();
			example.createCriteria().andStudyidEqualTo(studyID);
			mapper.deleteByExample(example);
			session.commit();
		} finally {
			session.close();
		}
	}

	public void addCharacteristics(StudyGermplasmCharacteristic record) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();

		try {
			StudyGermplasmCharacteristicMapper mapper = session
					.getMapper(StudyGermplasmCharacteristicMapper.class);

			mapper.insert(record);
			session.commit();
		} finally {
			session.close();
		}
	}

}
