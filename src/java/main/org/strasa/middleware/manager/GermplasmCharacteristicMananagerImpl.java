package org.strasa.middleware.manager;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmCharacteristicsMapper;
import org.strasa.middleware.mapper.StudyGermplasmMapper;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.GermplasmCharacteristics;
import org.strasa.middleware.model.GermplasmCharacteristicsExample;
import org.strasa.middleware.model.GermplasmExample;
import org.strasa.web.uploadstudy.view.model.StudyGermplasmInfo.GermplasmDeepInfoModel;

public class GermplasmCharacteristicMananagerImpl {


	public void addCharacteristict(List<GermplasmCharacteristics> lstCharRecord){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession(ExecutorType.BATCH);
		GermplasmCharacteristicsMapper mapper = session.getMapper(GermplasmCharacteristicsMapper.class);
		try{
			for(GermplasmCharacteristics record : lstCharRecord){
				mapper.insert(record);
			}

			session.commit();
		}
		finally{
			session.close();
		}
	}
	
	public void addCharacteristicBatch(Collection<GermplasmDeepInfoModel> collection){
		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession(ExecutorType.BATCH);
		GermplasmCharacteristicsMapper mapper = session.getMapper(GermplasmCharacteristicsMapper.class);
		
		try{
			
			for(GermplasmDeepInfoModel recData : collection){
				GermplasmCharacteristicsExample ex = new GermplasmCharacteristicsExample();
				ex.createCriteria().andGermplasmnameEqualTo(recData.getGermplasmname());
				mapper.deleteByExample(ex);
			for(GermplasmCharacteristics record : recData.getCharacteristicValues()){
				mapper.insert(record);
			}
			}

			session.commit();
		}
		finally{
			session.close();
		}
	}

	public List<GermplasmCharacteristics> getGermplasmCharacteristicByKeyandGname(String attribute,String gname){

		SqlSession session = new  ConnectionFactory().getSqlSessionFactory().openSession();
		try{
			List<GermplasmCharacteristics> toreturn = null;
				GermplasmCharacteristics  param= new GermplasmCharacteristics();
				param.setGermplasmname(gname);
				param.setAttribute(attribute);
		
				toreturn= session.selectList("BrowseGermplasm.getGermplasmKeyCharacteristicsByGermplasmName",param);
			
			return toreturn;

		}finally{
			session.close();
		}

	}
}
