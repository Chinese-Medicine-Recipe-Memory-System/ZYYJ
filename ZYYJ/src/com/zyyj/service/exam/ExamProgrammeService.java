package com.zyyj.service.exam;

import java.util.List;

import com.zyyj.bean.ExamProgramme;

public interface ExamProgrammeService {
	
	List<ExamProgramme> getAllExamProgrammes();
	
	int addExamProgramme(ExamProgramme examProgramme);
	
	int updateExamProgramme(ExamProgramme examProgramme);
	
	int deleteExamProgramme(String exam_id);
}
