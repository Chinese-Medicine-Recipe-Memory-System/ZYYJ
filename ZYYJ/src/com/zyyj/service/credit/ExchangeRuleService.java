package com.zyyj.service.credit;

import java.util.List;

import com.zyyj.bean.ExchangeRule;

public interface ExchangeRuleService {
	
	void addExchangeRule(ExchangeRule exchangeRule);
	
	List<ExchangeRule> getAllExchangeRules();
	
	void updateExchangeRule(ExchangeRule exchangeRule);
	
	void deleteExchangeRule(String rule_id);
}
