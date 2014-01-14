package org.strasa.middleware.mapper.other;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.strasa.middleware.model.Study;
import org.strasa.web.browsestudy.view.model.StudySummaryModel;


public interface StudySummaryMapper {
	

	@Select("SELECT DISTINCT t1.programid as programId,t2.name as programName FROM study as t1 left join program as t2 on t1.programid=t2.id group by t1.programid")
	List<StudySummaryModel> selectDistinctProgram();
	
	@Select("SELECT DISTINCT projectid as projectId FROM study WHERE programid=#{programId}")
	List<StudySummaryModel> selectDistinctProjectByProgramId(int programId);
	
	@Select("SELECT count(programid) as studyCount FROM study WHERE programid=#{programId}")
	List<StudySummaryModel> countStudyByProgram(int programId);
	
	@Select("SELECT DISTINCT studytypeid as studyTypeId,count(*)  as countStudyTypeId FROM study WHERE programid=#{programId} and studytypeid=#{studyTypeId}")
	List<StudySummaryModel> selectCountOfStudyByStudyType(@Param("programId") int programId,@Param("studyTypeId") int studyTypeId);
	
	


	
}
