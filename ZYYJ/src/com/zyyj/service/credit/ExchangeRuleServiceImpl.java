package com.zyyj.service.credit;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyyj.bean.ExchangeRule;
import com.zyyj.mapper.credit.ExchangeRuleMapper;

@Service
public class ExchangeRuleServiceImpl implements ExchangeRuleService{
	
	@Autowired
	private ExchangeRuleMapper exchangeRuleMapper;
	
	/**
	 * 添加的业务逻辑：生成日期和id，封装后用传给持久层
	 */
	@Override
	public void addExchangeRule(ExchangeRule exchangeRule) {
		// 生成创建日期
		String createdate = LocalDate.now().toString();
		exchangeRule.setCreatedate(createdate);
		
		// 为新的记录生成 ID：方法未定
		String rule_id = "rule_001";
		exchangeRule.setRule_id(rule_id);
		// 添加到数据库
		exchangeRuleMapper.addExchangeRule(exchangeRule);
	}
	
	/**
	 * 获取所有的规则，直接调用持久层方法
	 */
	@Override
	public List<ExchangeRule> getAllExchangeRules() {
		List<ExchangeRule> result = exchangeRuleMapper.getAllExchangeRules();
		return result;
	}

	/**
	 * 修改，
	 */
	@Override
	public void updateExchangeRule(ExchangeRule exchangeRule) {
		exchangeRuleMapper.updateExchangeRule(exchangeRule);
	}
	
	/**
	 * 删除
	 */
	@Override
	public void deleteExchangeRule(String rule_id) {
		exchangeRuleMapper.deleteExchangeRule(rule_id);
	}
}
