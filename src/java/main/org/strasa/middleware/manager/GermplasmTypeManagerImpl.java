package org.strasa.middleware.manager;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.GermplasmMapper;
import org.strasa.middleware.mapper.GermplasmTypeMapper;
import org.strasa.middleware.model.GermplasmType;

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
}
