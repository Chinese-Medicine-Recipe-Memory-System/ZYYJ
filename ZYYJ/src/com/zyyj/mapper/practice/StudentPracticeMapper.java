package com.zyyj.mapper.practice;

import java.util.List;

import com.zyyj.bean.StudentPractice;

public interface StudentPracticeMapper {
	
	List<StudentPractice> getAllStudentPractice();                  // 获取所有练习记录
	
	List<StudentPractice> searchByStudent(String student_name);     // 按照学生姓名搜索
	
	List<StudentPractice> searchByClass(String class_name);         // 按照班级搜索
	
	List<StudentPractice> searchByStudentId(String student_id);     // 按照学好搜索
	
	List<StudentPractice> searchByGrade(String grade);             //  按照年级搜索
	
	List<StudentPractice> searchByMajor(String major);             //  按照专业搜索
}
