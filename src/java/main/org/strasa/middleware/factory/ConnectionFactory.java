package org.strasa.middleware.factory;
 
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.strasa.middleware.mapper.CountryMapper;
import org.strasa.middleware.mapper.EcotypeMapper;
import org.strasa.middleware.mapper.GeorefMapper;
import org.strasa.middleware.mapper.GermplasmCharacteristicsMapper;
import org.strasa.middleware.mapper.GermplasmMapper;
import org.strasa.middleware.mapper.GermplasmReleaseInfoMapper;
import org.strasa.middleware.mapper.KeyAbioticMapper;
import org.strasa.middleware.mapper.KeyBioticMapper;
import org.strasa.middleware.mapper.KeyGrainQualityMapper;
import org.strasa.middleware.mapper.KeyMajorGenesMapper;
import org.strasa.middleware.mapper.LocationMapper;
import org.strasa.middleware.mapper.PlantingTypeMapper;
import org.strasa.middleware.mapper.ProgramMapper;
import org.strasa.middleware.mapper.ProjectMapper;
import org.strasa.middleware.mapper.StudyAgronomyMapper;
import org.strasa.middleware.mapper.StudyDerivedDataMapper;
import org.strasa.middleware.mapper.StudyDesignMapper;
import org.strasa.middleware.mapper.StudyFileMapper;
import org.strasa.middleware.mapper.StudyLocationMapper;
import org.strasa.middleware.mapper.StudyMapper;
import org.strasa.middleware.mapper.StudyRawDataMapper;
import org.strasa.middleware.mapper.StudySiteMapper;
import org.strasa.middleware.mapper.StudyTypeMapper;
import org.strasa.middleware.mapper.StudyVariableMapper;
import org.strasa.middleware.mapper.UserMapper;

 
public class ConnectionFactory {
 


    public  static SqlSessionFactory sqlSessionFactory;
 
     static {

        
        String resource = "SqlMapConfig.xml";
        Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			 if (sqlSessionFactory == null) {
	                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	                sqlSessionFactory.getConfiguration().addMapper(CountryMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(EcotypeMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(GeorefMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(GermplasmCharacteristicsMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(GermplasmMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(GermplasmReleaseInfoMapper.class);
//	                sqlSessionFactory.getConfiguration().addMapper(GermplasmMapper.class);  
	                sqlSessionFactory.getConfiguration().addMapper(LocationMapper.class);  
	                sqlSessionFactory.getConfiguration().addMapper(PlantingTypeMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(ProgramMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(ProjectMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(StudyAgronomyMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(StudyDerivedDataMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(StudyDesignMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(StudyFileMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(StudyLocationMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(StudyMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(StudyRawDataMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(StudySiteMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(StudyTypeMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(StudyVariableMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(KeyBioticMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(KeyAbioticMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(KeyGrainQualityMapper.class);
	                sqlSessionFactory.getConfiguration().addMapper(KeyMajorGenesMapper.class);

//	                sqlSessionFactory.getConfiguration().addMapper();
	            
	            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public ConnectionFactory(){
    
    
            String resource = "SqlMapConfig.xml";
            Reader reader;
			try {
				reader = Resources.getResourceAsReader(resource);
				 if (sqlSessionFactory == null) {
		                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		                sqlSessionFactory.getConfiguration().addMapper(CountryMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(EcotypeMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(GeorefMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(GermplasmCharacteristicsMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(GermplasmMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(GermplasmReleaseInfoMapper.class);
//		                sqlSessionFactory.getConfiguration().addMapper(GermplasmMapper.class);  
		                sqlSessionFactory.getConfiguration().addMapper(LocationMapper.class);  
		                sqlSessionFactory.getConfiguration().addMapper(PlantingTypeMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(ProgramMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(ProjectMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(StudyAgronomyMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(StudyDerivedDataMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(StudyDesignMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(StudyFileMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(StudyLocationMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(StudyMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(StudyRawDataMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(StudySiteMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(StudyTypeMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(StudyVariableMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(KeyBioticMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(KeyAbioticMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(KeyGrainQualityMapper.class);
		                sqlSessionFactory.getConfiguration().addMapper(KeyMajorGenesMapper.class);

//		                sqlSessionFactory.getConfiguration().addMapper();
		            
		            }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
           
    }
 
    public static SqlSessionFactory getSqlSessionFactory() {
 
        return sqlSessionFactory;
    }
    /**
     * Returns a DataSource object.
     *
     * @return a DataSource.
     */
   
}