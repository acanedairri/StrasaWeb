package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmMapper;
import org.strasa.middleware.mapper.GermplasmTypeMapper;
import org.strasa.middleware.mapper.StudyGermplasmCharacteristicsMapper;
import org.strasa.middleware.model.GermplasmType;
import org.strasa.middleware.model.StudyGermplasmCharacteristics;
import org.strasa.middleware.model.StudyGermplasmCharacteristicsExample;

public class GermplasmTypeManagerImpl {

	public List<GermplasmType> getAllGermplasm() {
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
}
