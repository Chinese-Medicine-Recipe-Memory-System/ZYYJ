package com.zyyj.mapper.exam;

import java.util.List;

import com.zyyj.bean.StudentExam;

public interface StudentExamMapper {
	
	List<StudentExam> getAllStudentExams();            // 获取全部学生
	
	List<StudentExam> searchByStudent(String stuName); // 按照学生姓名搜索
	
	List<StudentExam> searchByClass(String className); // 按照班级搜索 
	
	List<StudentExam> searchByExam(String exam_name);  // 按照考试方案搜索
}
