package org.strasa.middleware.mapper;

import java.util.List;

import org.strasa.middleware.model.StudyRawData;

public interface StudyRawDataBatch {
 public void insertBatchRaw(List<StudyRawData> datalist);
 public void insertBatchDerived(List<StudyRawData> datalist);
}
