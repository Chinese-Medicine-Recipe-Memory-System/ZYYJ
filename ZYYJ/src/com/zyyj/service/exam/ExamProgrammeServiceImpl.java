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
		
		// 为新的记录生成ID
		String max_id = mapper.getMaxId();
		String next_id = ServiceUtil.getNextId(max_id, "exam");
		
		examProgramme.setExam_id(next_id);
		
		return mapper.addExamProgramme(examProgramme);
	}

	@Override
	public int updateExamProgramme(ExamProgramme examProgramme) {
		return mapper.updateExamProgramme(examProgramme);
	}

	@Override
	public int deleteExamProgramme(String exam_id) {
		return mapper.deleteExamProgramme(exam_id);
	}
	
	
}
