package com.zyyj.mapper.exam;

import java.util.List;

import com.zyyj.bean.ExamProgramme;

public interface ExamProgrammeMapper {
	
	// 查询所有
	List<ExamProgramme> getAllExamProgrammes();
	// 添加
	int addExamProgramme(ExamProgramme examProgramme);
	// 修改
	int updateExamProgramme(ExamProgramme examProgramme);
	// 删除
	int deleteExamProgramme(String exam_id);
	
	// 获取最大ID
	String getMaxId();
}
