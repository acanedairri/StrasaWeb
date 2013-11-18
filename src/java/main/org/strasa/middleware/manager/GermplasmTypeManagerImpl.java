package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmTypeMapper;
import org.strasa.middleware.mapper.KeyAbioticMapper;
import org.strasa.middleware.mapper.KeyBioticMapper;
import org.strasa.middleware.mapper.KeyGrainQualityMapper;
import org.strasa.middleware.mapper.KeyMajorGenesMapper;
import org.strasa.middleware.mapper.StudyGermplasmCharacteristicsMapper;
import org.strasa.middleware.model.GermplasmType;
import org.strasa.middleware.model.KeyAbiotic;
import org.strasa.middleware.model.KeyBiotic;
import org.strasa.middleware.model.KeyGrainQuality;
import org.strasa.middleware.model.KeyMajorGenes;
import org.strasa.middleware.model.StudyGermplasmCharacteristics;
import org.strasa.middleware.model.StudyGermplasmCharacteristicsExample;

public class GermplasmTypeManagerImpl {

	public List<GermplasmType> getAllGermplasmType() {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		GermplasmTypeMapper mapper = session.getMapper(GermplasmTypeMapper.class);

		try {
			return mapper.selectByExample(null);

		} finally {
			session.close();
		}
	}
	
	public List<StudyGermplasmCharacteristics> getStudyGermplasmCharacteristics(int studyid,
			String column) {

		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		StudyGermplasmCharacteristicsMapper StudyGermplasmCharacteristicsMapper = session
				.getMapper(StudyGermplasmCharacteristicsMapper.class);

		StudyGermplasmCharacteristicsExample example = new StudyGermplasmCharacteristicsExample();

		example.createCriteria().andIdEqualTo(studyid)
				.andAttributeEqualTo(column);
		example.setDistinct(true);
		return StudyGermplasmCharacteristicsMapper.selectByExample(example);

	}
	
	public List<KeyAbiotic> getKeyAbioticOption(){
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		KeyAbioticMapper mapper = session.getMapper(KeyAbioticMapper.class);

		try {
			return mapper.selectByExample(null);

		} finally {
			session.close();
		}
	}
	
	public List<KeyBiotic> getKeyBioticOption(){
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		KeyBioticMapper mapper = session.getMapper(KeyBioticMapper.class);

		try {
			return mapper.selectByExample(null);

		} finally {
			session.close();
		}
	}
	
	public List<KeyMajorGenes> getKeyMajorGenesOption(){
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		KeyMajorGenesMapper mapper = session.getMapper(KeyMajorGenesMapper.class);

		try {
			return mapper.selectByExample(null);

		} finally {
			session.close();
		}
	}
	
	public List<KeyGrainQuality> getKeyGrainQualityOption(){
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		KeyGrainQualityMapper mapper = session.getMapper(KeyGrainQualityMapper.class);

		try {
			return mapper.selectByExample(null);

		} finally {
			session.close();
		}
	}
	
}
