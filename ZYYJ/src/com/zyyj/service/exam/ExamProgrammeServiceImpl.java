package com.zyyj.service.exam;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyyj.bean.ExamProgramme;
import com.zyyj.mapper.exam.ExamProgrammeMapper;
import com.zyyj.service.ServiceUtil;

@Service
public class ExamProgrammeServiceImpl implements ExamProgrammeService{
	
	@Autowired
	private ExamProgrammeMapper mapper;

	@Override
	public List<ExamProgramme> getAllExamProgrammes() {
		return mapper.getAllExamProgrammes();
	}

	@Override
	public int addExamProgramme(ExamProgramme examProgramme) {
		String createdate = LocalDate.now().toString();
		examProgramme.setCreatedate(createdate);
		
		String next_id = null;
		
		// 为新的记录生成ID
		String max_id = mapper.getMaxId();
		if(max_id==null) {
			next_id = "exam001";
		}
		else{
			next_id = ServiceUtil.getNextId(max_id, "exam");
		}
		examProgramme.setExam_id(next_id);
		
		int s1 = mapper.addExamProgramme(examProgramme);
		int s2 = mapper.addCourseExam(examProgramme);
		int s3 = mapper.addExamRecord(examProgramme);
		return s1 > 0 && s2 > 0 && s3 > 0 ? 1 : 0;
	}

	@Override
	public int updateExamProgramme(ExamProgramme examProgramme) {
		int s1 = mapper.updateCourseExam(examProgramme);
		int s2 =  mapper.updateExamProgramme(examProgramme);
		return s1 > 0 && s2 > 0 ? 1 : 0;
	}

	@Override
	public int deleteExamProgramme(String exam_id) {
		int s1 = mapper.deleteCourseExam(exam_id);
		int s2 = mapper.deleteExamRecord(exam_id);
		int s3 =  mapper.deleteExamProgramme(exam_id);
		
		return s1 > 0 && s2 > 0 && s3 > 0 ? 1 : 0;
	}

	@Override
	public String getExamProgramme(String exam_id) {
		
		return mapper.getExamProgramme(exam_id).toString();
	}

	@Override
	public List<String> getAllCourses() {
		return mapper.getAllCourses();
	}

	@Override
	public String getSearchResult(String input, String option) {
		List<ExamProgramme> result = null;
		
		if(option.equals("1")) {
			result = mapper.searchByName("%" + input + "%");
		}
		else if(option.equals("2")) {
			result = mapper.searchByCourse("%" + input + "%");
		}
		
		StringBuilder table = new StringBuilder();
		for(ExamProgramme e : result) {
			table.append("<tr><td>" + e.getExam_id() + "</td><td>" + e.getName() + "</td><td>" + e.getCreator() + "</td><td>" + e.getTotal_question() + "</td><td>" + 
					e.getTotal_score() + "</td><td>" + e.getPass_score() + "</td><td>" + e.getQuestion_num() + "</td><td>" + e.getLimit_time() + "</td><td>" + 
					e.getCreatedate() + "</td><td>" +  e.getCourse() + "</td>");
			table.append("<td><a href=\"#\" data-toggle=\"modal\" data-target=\"#modify-modal\" onclick=\"javascript:updateModalExamProgramme('" + e.getExam_id() + "')\"><span class=\"glyphicon glyphicon-pencil\"> 修改</span></a></td>");
			table.append("<td><a href=\"/ZYYJ/deleteExamProgramme?exam_id=" + e.getExam_id() + "\"><span class=\"glyphicon glyphicon-trash\"> 删除</span></a></td></tr>");
		}
		
		return table.toString();
	}
	
	
}
