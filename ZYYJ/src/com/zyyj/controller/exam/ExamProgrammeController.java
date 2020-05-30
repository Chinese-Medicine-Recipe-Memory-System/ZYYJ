package com.zyyj.controller.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zyyj.service.exam.ExamProgrammeService;

@Controller
public class ExamProgrammeController {
	
	@Autowired
	private ExamProgrammeService service;
	
}
