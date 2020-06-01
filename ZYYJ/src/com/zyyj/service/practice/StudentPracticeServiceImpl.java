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
	public List<StudentPractice> getAllStudentPractice() {         // 获取所有练习记录
		return mapper.getAllStudentPractice();
	}
	@Override
	public String getSearchResult(String input, String option) {
		List<StudentPractice> list = null;
		if(option.equals("1")) {                      // 根据选项按照不同的规则搜索
			list = mapper.searchByStudent(input);  // 按学生姓名
		}
		else if(option.equals("2")) {
			list = mapper.searchByStudentId(input);// 按学号
		}
		else if(option.equals("3")) {
			list = mapper.searchByClass(input);  // 按班级
		}
		else if(option.equals("4")) {
			list = mapper.searchByGrade(input);  // 按年级
		}
		else if(option.equals("5")) {
			list = mapper.searchByGrade(input);  // 按专业
		}
		else {
			list = null;
		}
		StringBuilder table = new StringBuilder();               // 将搜索结果组装成html表格
		for(StudentPractice s : list) {
			table.append("<tr><td>" + s.getPractice_id() + "</td><td>" + s.getStudent_name() + "</td><td>"
					+ s.getCheckpoint_name() + "</td><td>" + (s.getStatus()==1?"是":"否")  + "</td><td>" + s.getCreatetime()
					+ "</td><td>" + s.getScore() + "</td><td>" + s.getProgramme_name() + "</td><td>" + s.getCourse_name() + "</td></tr>");
		}
		return table.toString();
	}

}
