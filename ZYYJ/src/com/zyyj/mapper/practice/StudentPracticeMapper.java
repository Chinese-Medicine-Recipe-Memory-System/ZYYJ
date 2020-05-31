package com.zyyj.mapper.practice;

import java.util.List;

import com.zyyj.bean.StudentPractice;

public interface StudentPracticeMapper {
	
	List<StudentPractice> getAllStudentPractice();
	
	List<StudentPractice> searchByStudent(String student_name);
	
	List<StudentPractice> searchByClass(String class_name);
	
	List<StudentPractice> searchByStudentId(String student_id);
	
	List<StudentPractice> searchByGrade(String grade);
	
	List<StudentPractice> searchByMajor(String major);
}
