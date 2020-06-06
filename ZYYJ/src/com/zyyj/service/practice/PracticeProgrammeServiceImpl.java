package com.zyyj.service.practice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyyj.bean.PracticeProgramme;
import com.zyyj.mapper.practice.PracticeProgrammeMapper;
import com.zyyj.service.ServiceUtil;

@Service
public class PracticeProgrammeServiceImpl implements PracticeProgrammeService{
	
	@Autowired
	private PracticeProgrammeMapper mapper;
	
	@Override
	public List<PracticeProgramme> getAllPracticeProgrammes() {
		return mapper.getAllPracticeProgrammes();
	}

	@Override
	public int addPracticeProgramme(PracticeProgramme programme) {
		String max_id = mapper.getMaxId();
		String createdate = LocalDate.now().toString();
		String programme_id = ServiceUtil.getNextId(max_id, "programme");
		
		programme.setProgramme_id(programme_id);
		programme.setCreatedate(createdate);
		
		int s1 = mapper.addPracticeProgramme(programme);
		int s2 = mapper.addCourseProgramme(programme);
		int s3 = mapper.addPracticeRecord(programme);
		return s1>0&&s2>0&&s3>0 ? 1 : 0;
	}

	@Override
	public int updatePracticeProgramme(PracticeProgramme programme) {
		int s2 = mapper.updateCourseProgramme(programme);
		int s1 = mapper.updatePracticeProgramme(programme);

		return s1 > 0 && s2 > 0 ? 1 : 0;
	}

	@Override
	public int deletePracticeProgramme(String programme_id) {
		int s1 = mapper.deletePracticeRecord(programme_id);
		int s2 = mapper.deleteCourseProgramme(programme_id);
		int s3 = mapper.deletePracticeProgramme(programme_id);
		
		return s1>0&&s2>0&&s3>0?1 : 0;
	}

	@Override
	public List<String> getAllCourses() {
		return mapper.getAllCourses();
	}

	@Override
	public String getPracticeProgramme(String programme_id) {
		return mapper.getPracticeProgramme(programme_id).toString();
	}

	@Override
	public String getSearchResult(String input, String option) {
		List<PracticeProgramme> result = null;
		
		if(option.equals("1")) {
			result = mapper.searchByName("%" + input + "%");
		}
		else if(option.equals("2")) {
			result = mapper.searchByCourse("%" + input + "%");
		}
		else {
			result = null;
		}
		
		StringBuilder table = new StringBuilder();
		for(PracticeProgramme p : result) {
			table.append("<tr><td>" + p.getProgramme_id() + "</td><td>" + p.getName() + "</td><td>" + p.getCreator() + "</td><td>" + p.getCreatedate() + "</td><td>" + 
					p.getScore() + "</td><td>" + p.getCourse() + "</td><td>" + p.getNote() + "</td>");
			table.append("<td><a href=\"#\" data-toggle=\"modal\" data-target=\"#modify-modal\" onclick=\"javascript:updateModalPracticeProgramme('"+p.getProgramme_id()+"')\"><span class=\"glyphicon glyphicon-pencil\"> 修改</span></a></td>");
			table.append("<td><a href=\"deletePracticeProgramme?programme_id="+p.getProgramme_id()+"\"><span class=\"glyphicon glyphicon-trash\"> 删除</span></a></td></tr>");
		}
		return table.toString();
	}
}
