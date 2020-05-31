package com.zyyj.service.practice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyyj.bean.StudentPractice;
import com.zyyj.mapper.practice.StudentPracticeMapper;

@Service
public class StudentPracticeServiceImpl implements StudentPracticeService{
	
	@Autowired
	private StudentPracticeMapper mapper;
	@Override
	public List<StudentPractice> getAllStudentPractice() {
		return mapper.getAllStudentPractice();
	}
	@Override
	public String getSearchResult(String input, String option) {
		List<StudentPractice> list = null;
		if(option.equals("1")) {
			list = mapper.searchByStudent(input);
		}
		else if(option.equals("2")) {
			list = mapper.searchByStudentId(input);
		}
		else if(option.equals("3")) {
			list = mapper.searchByClass(input);
		}
		else if(option.equals("4")) {
			list = mapper.searchByGrade(input);
		}
		else if(option.equals("5")) {
			list = mapper.searchByGrade(input);
		}
		else {
			list = null;
		}
		StringBuilder table = new StringBuilder();
		for(StudentPractice s : list) {
			table.append("<tr><td>" + s.getPractice_id() + "</td><td>" + s.getStudent_name() + "</td><td>"
					+ s.getCheckpoint_name() + "</td><td>" + (s.getStatus()==1?"是":"否")  + "</td><td>" + s.getCreatetime()
					+ "</td><td>" + s.getScore() + "</td><td>" + s.getProgramme_name() + "</td><td>" + s.getCourse_name() + "</td></tr>");
		}
		return table.toString();
	}

}
