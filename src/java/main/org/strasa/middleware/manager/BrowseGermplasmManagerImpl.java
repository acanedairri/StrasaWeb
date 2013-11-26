package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmMapper;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.GermplasmExample;
import org.strasa.web.browsestudy.view.model.StudySearchResultModel;

public class BrowseGermplasmManagerImpl {


	public List<StudySearchResultModel> getStudyWithGemrplasmTested(String gname) {
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		try{

			List<StudySearchResultModel> toreturn= session.selectList("BrowseStudy.getStudyWithGemrplasmTested",gname);

			return toreturn;

		}finally{
			session.close();
		}

	}
	
	
	public List<Germplasm> getGermplasmKeyCharacteristicsAbiotic(ArrayList<String> keyCharList) {
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		try{

			List<Germplasm> toreturn= session.selectList("BrowseGermplasm.getGermplasmByKeyCharacteristicsAbiotic",keyCharList);

			return toreturn;

		}finally{
			session.close();
		}

	}


	public List<Germplasm> getGermplasmListByType(int id){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);

		try{
			GermplasmExample example = new GermplasmExample();
			example.createCriteria().andGermplasmtypeidEqualTo(id);
			if(mapper.selectByExample(example).isEmpty()) return null;
			return mapper.selectByExample(example);
		}
		finally{
			session.close();
		}
	}
}
