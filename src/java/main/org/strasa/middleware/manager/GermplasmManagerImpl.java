package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmCharacteristicsMapper;
import org.strasa.middleware.mapper.GermplasmMapper;
import org.strasa.middleware.mapper.other.GermplasmBreederMapper;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.GermplasmCharacteristics;
import org.strasa.middleware.model.GermplasmExample;
import org.strasa.web.uploadstudy.view.model.StudyGermplasmInfo.GermplasmDeepInfoModel;

public class GermplasmManagerImpl {

	public Germplasm getGermplasmByName(String value) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);

		try {
			GermplasmExample example = new GermplasmExample();
			example.createCriteria().andGermplasmnameEqualTo(value);
			if (mapper.selectByExample(example).isEmpty())
				return null;
			return mapper.selectByExample(example).get(0);

		} finally {
			session.close();
		}
	}

	public Germplasm getGermplasmById(int id) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);
		try {
			return mapper.selectByPrimaryKey(id);
		} finally {
			session.close();
		}

	}

	public List<Germplasm> getGermplasmListByName(String value) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);

		try {
			GermplasmExample example = new GermplasmExample();
			if (value.contains("%")) {
				example.createCriteria().andGermplasmnameLike(value);
			} else {
				example.createCriteria().andGermplasmnameEqualTo(value);
			}
			if (mapper.selectByExample(example).isEmpty())
				return null;
			return mapper.selectByExample(example);

		} finally {
			session.close();
		}
	}


	public List<Germplasm> getGermplasmListByType(int id) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);

		try {
			GermplasmExample example = new GermplasmExample();
			example.createCriteria().andGermplasmtypeidEqualTo(id);
			if (mapper.selectByExample(example).isEmpty())
				return null;
			return mapper.selectByExample(example);
		} finally {
			session.close();
		}
	}


	public List<Germplasm> convertStudyToGermplasm(
			Collection<GermplasmDeepInfoModel> collection) {

		ArrayList<Germplasm> returnVal = new ArrayList<Germplasm>();
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);

		try {
			for (GermplasmDeepInfoModel data : collection) {
				Germplasm newData = new Germplasm();

				
				newData.setFemaleparent(data.getFemaleparent());
				newData.setGermplasmname(data.getGermplasmname());
				newData.setGermplasmtypeid(data.getGermplasmtypeid());
				newData.setGid(data.getGid());
				newData.setId(data.getPreservedGermplasmID());
				newData.setIrcross(data.getIrcross());
				newData.setIrnumber(data.getIrnumber());
				newData.setMaleparent(data.getMaleparent());
				newData.setOthername(data.getOthername());
				newData.setParentage(data.getParentage());
				newData.setRemarks(data.getRemarks());
				newData.setSelectionhistory(data.getSelectionhistory());
				newData.setSource(data.getSource());
				GermplasmExample example = new GermplasmExample();
				example.createCriteria().andGermplasmnameEqualTo(
						data.getGermplasmname());
				List<Germplasm> subd = mapper.selectByExample(example);
				if (subd.isEmpty())
					newData.setId(null);
				else
					newData.setId(subd.get(0).getId());
				returnVal.add(newData);
			}
		} finally {
			session.close();
		}
		return returnVal;

	}
	

	public boolean isGermplasmExisting(String value) {
		if (this.getGermplasmByName(value) == null)
			return false;
		return true;
	}

	public int addGermplasm(Germplasm record) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession();
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);
		try {
			mapper.insert(record);
			session.commit();
		} finally {
			session.close();
		}
		return record.getId();
	}

	public void addGermplasm(List<Germplasm> lstRecord) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession(ExecutorType.BATCH);
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);
		try {
			for (Germplasm record : lstRecord) {

				if (record.getId() == null)
					mapper.insert(record);
				else {
					mapper.updateByPrimaryKey(record);

				}
			}
			session.commit();
		} finally {
			session.close();
		}
		return;
	}
	
	
	public void updateBreeders(List<GermplasmDeepInfoModel> lstRecord) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession(ExecutorType.BATCH);
		GermplasmBreederMapper mapper = session.getMapper(GermplasmBreederMapper.class);
		try {
			for (GermplasmDeepInfoModel record : lstRecord) {

				Germplasm newRec = record.toGermplasm();
		
				mapper.Update(newRec);
				
			}
			session.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return;
	}

	public void addGermplasmBatch(List<GermplasmDeepInfoModel> lstRecord) {
		SqlSession session = new ConnectionFactory().getSqlSessionFactory()
				.openSession(ExecutorType.BATCH);
		GermplasmMapper mapper = session.getMapper(GermplasmMapper.class);
		GermplasmCharacteristicsMapper charmapper = session
				.getMapper(GermplasmCharacteristicsMapper.class);
		try {
			for (GermplasmDeepInfoModel rec : lstRecord) {

				Germplasm record = rec.toGermplasm();
				if (record.getId() == null)
					mapper.insert(record);
				else {
					mapper.updateByPrimaryKey(record);

				}

				for (GermplasmCharacteristics records : rec.getCharacteristicValues()) {

					charmapper.insert(records);
				}
				System.out.println("SID: " + record.getId());
			}
			session.commit();
		} finally {
			session.close();
		}
		return;
	}

}
