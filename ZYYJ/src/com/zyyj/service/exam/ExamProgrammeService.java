package com.zyyj.service.exam;

import java.util.List;

import com.zyyj.bean.ExamProgramme;

public interface ExamProgrammeService {
	
	List<ExamProgramme> getAllExamProgrammes();
	
	void addExamProgramme(ExamProgramme examProgramme);
}
