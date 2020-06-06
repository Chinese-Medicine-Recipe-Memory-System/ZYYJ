package com.zyyj.controller.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zyyj.bean.ExamProgramme;
import com.zyyj.service.exam.ExamProgrammeService;

@Controller
public class ExamProgrammeController {
	
	@Autowired
	private ExamProgrammeService service;
	
	@RequestMapping(value="addExamProgramme", method=RequestMethod.POST)
	public String addExamProgramme(ExamProgramme examProgramme, HttpServletResponse resp) throws IOException {
		examProgramme.setCreator("阿娟");
		int stat = service.addExamProgramme(examProgramme);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(stat > 0) {
			out.println("<script>alert('添加成功');window.location='admin.jsp?externalPage=exam/manageExamProgramme.jsp';</script>");
		}
		else {
			out.println("<script>alert('添加失败');window.location='admin.jsp?externalPage=exam/manageExamProgramme.jsp';</script>");
		}
		return null;
	}
	
	@RequestMapping(value="updateExamProgramme", method=RequestMethod.POST)
	public String updateExamProgramme(ExamProgramme examProgramme, HttpServletResponse resp) throws IOException {
		int stat = service.updateExamProgramme(examProgramme);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(stat > 0) {
			out.println("<script>alert('修改成功');window.location='admin.jsp?externalPage=exam/manageExamProgramme.jsp';</script>");
		}
		else {
			out.println("<script>alert('修改失败');window.location='admin.jsp?externalPage=exam/manageExamProgramme.jsp';</script>");
		}
		return null;
	}
	
	@RequestMapping(value="deleteExamProgramme", method=RequestMethod.GET)
	public String deleteExamProgramme(String exam_id, HttpServletResponse resp) throws IOException {
		int stat = service.deleteExamProgramme(exam_id);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		if(stat > 0) {
			out.println("<script>alert('删除成功');window.location='admin.jsp?externalPage=exam/manageExamProgramme.jsp';</script>");
		}
		else {
			out.println("<script>alert('删除失败');window.location='admin.jsp?externalPage=exam/manageExamProgramme.jsp';</script>");
		}
		return null;
	}
	
	@RequestMapping(value="getExamProgramme", method=RequestMethod.POST)
	@ResponseBody
	public void getExamProgramme(String exam_id, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/json;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.write(service.getExamProgramme(exam_id));
		out.close();
	}
	@RequestMapping(value="searchExamProgramme", method=RequestMethod.POST)
	@ResponseBody
	public void searchExamProgramme(String input, String option, HttpServletResponse resp) throws IOException{
		String result = service.getSearchResult(input, option);
		resp.setContentType("text/plain;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.write(result);
		out.close();
	}
}
