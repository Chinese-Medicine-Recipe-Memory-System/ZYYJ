package com.zyyj.service.practice;

import java.util.List;

import com.zyyj.bean.StudentPractice;

public interface StudentPracticeService {
	
	List<StudentPractice> getAllStudentPractice();
	
	String getSearchResult(String input, String option);
}
