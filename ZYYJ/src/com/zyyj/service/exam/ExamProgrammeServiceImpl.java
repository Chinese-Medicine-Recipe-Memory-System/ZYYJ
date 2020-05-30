package com.zyyj.service.exam;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyyj.bean.ExamProgramme;
import com.zyyj.mapper.exam.ExamProgrammeMapper;

@Service
public class ExamProgrammeServiceImpl implements ExamProgrammeService{
	
	@Autowired
	private ExamProgrammeMapper mapper;

	@Override
	public List<ExamProgramme> getAllExamProgrammes() {
		return mapper.getAllExamProgrammes();
	}

	@Override
	public void addExamProgramme(ExamProgramme examProgramme) {
		String createdate = LocalDate.now().toString();
		examProgramme.setCreatedate(createdate);
		
		
		mapper.addExamProgramme(examProgramme);
	}
	
	
}
