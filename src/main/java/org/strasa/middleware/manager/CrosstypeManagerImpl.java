package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.CrosstypeMapper;
import org.strasa.middleware.model.Crosstype;
import org.strasa.middleware.model.CrosstypeExample;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class CrosstypeManagerImpl {

	@WireVariable
	ConnectionFactory connectionFactory;

	public CrosstypeManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	public void addCrosstype(Crosstype record) {
		// TODO Auto-generated method stub
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		CrosstypeMapper mapper = session.getMapper(CrosstypeMapper.class);

		try {
			mapper.insert(record);
			session.commit();

		} finally {
			session.close();
		}

	}

	public List<Crosstype> getAllCrosstypes() {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		CrosstypeMapper CrosstypeMapper = session.getMapper(CrosstypeMapper.class);

		try {
			List<Crosstype> Crosstypes = CrosstypeMapper.selectByExample(null);

			return Crosstypes;

		} finally {
			session.close();
		}

	}

//	public Crosstype getCrosstypeById(int id) {
//		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
//		CrosstypeMapper CrosstypeMapper = session.getMapper(CrosstypeMapper.class);
//		try {
//			Crosstype Crosstypes = CrosstypeMapper.selectByPrimaryKey(id);
//
//			return Crosstypes;
//
//		} finally {
//			session.close();
//		}
//	}

	public Crosstype getCrosstypeByName(String name) {
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		CrosstypeMapper CrosstypeMapper = session.getMapper(CrosstypeMapper.class);
		try {
			CrosstypeExample example = new CrosstypeExample();
			example.createCriteria().andCrosstypeEqualTo(name);
			List<Crosstype> Crosstypes = CrosstypeMapper.selectByExample(example);

			if (Crosstypes.isEmpty())
				return null;
			else
				return Crosstypes.get(0);

		} finally {
			session.close();
		}
	}

	@SuppressWarnings("null")
	public List<String> getAllCrosstypesAsString() {
		List<String> Crosstypes = new ArrayList<String>();
		;
		List<Crosstype> CrosstypeList = getAllCrosstypes();
		for (Crosstype e : CrosstypeList) {
			System.out.println(e.getCrosstype());
			Crosstypes.add(e.getCrosstype());
		}
		// TODO Auto-generated method stub
		return Crosstypes;
	}

	public void updateCrosstype(Crosstype value) {
		// TODO Auto-generated method stub

		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		CrosstypeMapper mapper = session.getMapper(CrosstypeMapper.class);
		try {
			mapper.updateByPrimaryKey(value);
			session.commit();

		} finally {
			session.close();
		}

	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		SqlSession session = connectionFactory.sqlSessionFactory.openSession();
		CrosstypeMapper mapper = session.getMapper(CrosstypeMapper.class);
		try {
			mapper.deleteByPrimaryKey(id);
			session.commit();
		} finally {
			session.close();
		}
	}

}
