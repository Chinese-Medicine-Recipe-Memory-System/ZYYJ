package com.zyyj.mapper.credit;

import java.util.List;

import com.zyyj.bean.ExchangeRule;

/**
 * 积分兑换规则mapper，方法对应的数据库sql语句位于exchangeRuleMapper.xml
 * @author Jay
 *
 */
public interface ExchangeRuleMapper {
	
	// 添加
	void addExchangeRule(ExchangeRule exchangeRule);
	// 查询所有
	List<ExchangeRule> getAllExchangeRules();
	// 修改
	void updateExchangeRule(ExchangeRule exchangeRule);
	// 删除
	void deleteExchangeRule(String rule_id);
	
}
