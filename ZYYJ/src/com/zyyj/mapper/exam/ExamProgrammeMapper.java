package com.zyyj.mapper.exam;

import java.util.List;

import com.zyyj.bean.ExamProgramme;

public interface ExamProgrammeMapper {
	
	List<ExamProgramme> getAllExamProgrammes();
	
	void addExamProgramme(ExamProgramme examProgramme);
}
