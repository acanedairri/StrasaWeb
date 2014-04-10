package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.mapper.StudyVariableMapper;
import org.strasa.middleware.model.StudyVariable;
import org.strasa.middleware.model.StudyVariableExample;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class StudyVariableManagerImpl {

	@WireVariable
	ConnectionFactory connectionFactory;

	private SqlSession session;

	private StudyVariableMapper getMapper() {
		return getSqlSession().getMapper(StudyVariableMapper.class);
	}

	private SqlSession getSqlSession() {
		return session;

	}

	public StudyVariableManagerImpl() {
		session = connectionFactory.sqlSessionFactory.openSession();

	}

	public boolean hasVariable(String variable) {

		try {
			StudyVariableExample query = new StudyVariableExample();
			query.createCriteria().andVariablecodeEqualTo(variable);
			if (getMapper().selectByExample(query).isEmpty())
				return false;

		} finally {
			session.close();
		}

		return true;
	}

	public List<StudyVariable> getVariables() {

		try {
			return getMapper().selectByExample(null);
		} finally {
			session.close();
		}

	}

	public List<StudyVariable> getVariables(List<StudyVariable> filter) {

		try {
			ArrayList<Integer> lstFilterIds = new ArrayList<Integer>();
			for (StudyVariable var : filter) {
				lstFilterIds.add(var.getId());
			}
			StudyVariableExample example = new StudyVariableExample();
			example.createCriteria().andIdNotIn(lstFilterIds);
			return getMapper().selectByExample(example);
		} finally {
			session.close();
		}

	}

	public List<StudyVariable> getVariables(String sort) {

		try {
			StudyVariableExample example = new StudyVariableExample();
			example.createCriteria().andVariablecodeLike(sort + "%");
			return getMapper().selectByExample(example);
		} finally {
			session.close();
		}

	}

	public List<StudyVariable> getVariablesLike(String sort) {

		try {
			StudyVariableExample example = new StudyVariableExample();
			example.createCriteria().andVariablecodeLike(sort + "%");
			return getMapper().selectByExample(example);
		} finally {
			session.close();
		}

	}

	public StudyVariable getVariableByName(String var) {
		try {
			StudyVariableExample query = new StudyVariableExample();
			query.createCriteria().andApplytofilterEqualTo(var);
			return getMapper().selectByExample(query).get(0);
		} finally {
			session.close();
		}
	}

	public StudyVariable getVariableInfoByName(String var) {
		try {
			StudyVariableExample query = new StudyVariableExample();
			query.createCriteria().andVariablecodeEqualTo(var);
			return getMapper().selectByExample(query).get(0);
		} finally {
			session.close();
		}
	}

	private String buildRelevanceClause(String var) {
		return "CASE WHEN variablecode like '" + var + " %' THEN 0  WHEN variablecode like '" + var + "%' THEN 1 WHEN variablecode like '% " + var + "%' THEN 2 ELSE 3  END, variablecode";
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		try {
			getMapper().deleteByPrimaryKey(id);

			session.commit();

		} finally {
			session.close();
		}

	}

	public HashMap<String, StudyVariable> getConditionVariable(ArrayList<String> varNames) {

		try {
			StudyVariableExample example = new StudyVariableExample();
			example.createCriteria().andCategoryEqualTo("CONDITION").andVariablecodeIn(varNames);

			List<StudyVariable> lstVar = getMapper().selectByExample(example);
			HashMap<String, StudyVariable> returnVal = new HashMap<String, StudyVariable>();
			for (StudyVariable var : lstVar) {
				returnVal.put(var.getVariablecode(), var);
			}

			return returnVal;
		} finally {
			session.close();
		}
	}

	public List<StudyVariable> getFactorVariable(List<String> list) {

		try {
			StudyVariableExample example = new StudyVariableExample();
			example.createCriteria().andCategoryEqualTo("FACTOR").andVariablecodeIn(list);

			return getMapper().selectByExample(example);
		} finally {

			session.close();
		}
	}

	public List<StudyVariable> getVariateVariable(List<String> asList) {
		// TODO Auto-generated method stub

		try {
			StudyVariableExample example = new StudyVariableExample();
			example.createCriteria().andCategoryEqualTo("VARIATE").andVariablecodeIn(asList);

			return getMapper().selectByExample(example);
		} finally {

			session.close();
		}
	}
}
