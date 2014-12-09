package org.strasa.middleware.manager;

import java.util.ArrayList;
import java.util.List;

import org.strasa.middleware.factory.ConnectionFactory;
import org.strasa.middleware.model.Germplasm;
import org.strasa.middleware.model.StudyDataColumn;
import org.strasa.middleware.model.custom.StudyDataDynamicColumnQueryBuilder;
import org.strasa.web.crossstudyquery.view.model.AcrossStudyData;
import org.strasa.web.utilities.ArrayUtils;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class AdvanceSearchGermplasmManager {

	@WireVariable
	ConnectionFactory connectionFactory;

	public ArrayList<Integer> getStudyIDsFromGermplasm(String gName) {

		GermplasmManagerImpl germMan = new GermplasmManagerImpl();
		List<Germplasm> lstGerm = germMan.getGermplasmListByName(gName);
		StudyGermplasmManagerImpl studyGermMan = new StudyGermplasmManagerImpl();
		ArrayList<Integer> returnVal = new ArrayList<Integer>();
		for (Germplasm germ : lstGerm) {
			returnVal.addAll(studyGermMan.getStudyIDFromGermplasmID(germ.getId()));
		}

		return returnVal;

	}

	public ArrayList<ArrayList<String>> getColumnCompareFromStudyIds(ArrayList<Integer> studyids, String datatype) {

		StudyDataColumnManagerImpl columnMan = new StudyDataColumnManagerImpl();
		ArrayList<ArrayList<String>> returnVal = new ArrayList<ArrayList<String>>();
		for (Integer studyID : studyids) {
			List<StudyDataColumn> lstCols = columnMan.getStudyDataColumnByStudyId(studyID, datatype);
			ArrayList<String> cols = new ArrayList<String>();
			for (StudyDataColumn col : lstCols) {
				cols.add(col.getColumnheader());
			}
		}

		return returnVal;

	}

	public ArrayList<AcrossStudyData> getQueryResult(String GName, String datatype) {

		ArrayList<Integer> lstStudyIds = getStudyIDsFromGermplasm(GName);
		ArrayList<String> lstColumns = ArrayUtils.compareArraysOfString(getColumnCompareFromStudyIds(lstStudyIds, datatype));

		StudyDataDynamicColumnQueryBuilder queryBuilder = new StudyDataDynamicColumnQueryBuilder(datatype.equals("rd"));
		queryBuilder.andEqualTo("GName", GName);
		for (String col : lstColumns) {
			queryBuilder.addOtherVariable(col);
		}

		return new StudyDataDynamicColumnManager(datatype.equals("rd")).getAcrossStudyResult(queryBuilder);

	}

}
