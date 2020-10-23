package com.zyyj.service.practice;

import java.util.List;

import com.zyyj.bean.PracticeProgramme;

public interface PracticeProgrammeService {

	List<PracticeProgramme> getAllPracticeProgrammes();

	int addPracticeProgramme(PracticeProgramme programme);

	int updatePracticeProgramme(PracticeProgramme programme);

	int deletePracticeProgramme(String programme_id);

	List<String> getAllCourses();

	String getPracticeProgramme(String programme_id);

	String getSearchResult(String input, String option);
}
