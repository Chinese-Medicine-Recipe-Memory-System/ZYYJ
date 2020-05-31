package com.zyyj.mapper.credit;

import java.util.List;

import com.zyyj.bean.ExchangeIntegral;

public interface ExchangeIntegralMapper {
	
	List<ExchangeIntegral> getAllExchangeIntegrals();
	
	List<ExchangeIntegral> searchByClass(String className);
	
	List<ExchangeIntegral> searchByStudent(String stuName);
	
	List<ExchangeIntegral> searchByStudentId(String stuId);
	
	List<ExchangeIntegral> searchByMajor(String major);
	
	List<ExchangeIntegral> searchByGrade(String grade);
	
}
