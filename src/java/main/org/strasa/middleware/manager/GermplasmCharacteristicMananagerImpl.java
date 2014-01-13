package org.strasa.middleware.manager;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmCharacteristicsMapper;
import org.strasa.middleware.model.GermplasmCharacteristics;
import org.strasa.middleware.model.GermplasmCharacteristicsExample;
import org.strasa.web.uploadstudy.view.model.StudyGermplasmInfo.GermplasmDeepInfoModel;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class GermplasmCharacteristicMananagerImpl {
	
	@WireVariable
	ConnectionFactory connectionFactory;

	public void addCharacteristict(List<GermplasmCharacteristics> lstCharRecord){
		SqlSession session =connectionFactory.sqlSessionFactory.openSession(ExecutorType.BATCH);
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
		SqlSession session =connectionFactory.sqlSessionFactory.openSession(ExecutorType.BATCH);
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

		SqlSession session =connectionFactory.sqlSessionFactory.openSession();
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
