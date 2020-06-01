package com.zyyj.mapper.credit;

import java.util.List;

import com.zyyj.bean.ExchangeIntegral;

public interface ExchangeIntegralMapper {
	
	List<ExchangeIntegral> getAllExchangeIntegrals();         // 获取所有积分兑换记录
	
	List<ExchangeIntegral> searchByClass(String className);   // 按照班级搜索
	
	List<ExchangeIntegral> searchByStudent(String stuName);   // 按照学生姓名搜索
	
	List<ExchangeIntegral> searchByStudentId(String stuId);   // 按照学号搜索
	
	List<ExchangeIntegral> searchByMajor(String major);       // 按照专业搜索
	
	List<ExchangeIntegral> searchByGrade(String grade);       // 按照年级搜索
	
}
