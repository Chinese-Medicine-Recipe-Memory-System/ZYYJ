package com.zyyj.controller.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyyj.service.practice.StudentPracticeService;

@Controller
public class StudentPracticeController {
	
	@Autowired
	private StudentPracticeService service;     // service实体
	
	@RequestMapping(value="searchStudentPractice", method=RequestMethod.POST)
	public void searchStudentPractice(String input, String option, HttpServletResponse resp) throws IOException {
		String result = service.getSearchResult(input, option);    // 从servie获取表格形式的搜索结果
		
		
		resp.setHeader("Content-Type", "text/plain;charset=utf-8"); // 发送搜索结果到前端
		PrintWriter out = resp.getWriter();
		out.write(result);
	}
}
