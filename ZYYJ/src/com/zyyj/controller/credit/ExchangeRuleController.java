package com.zyyj.controller.credit;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zyyj.bean.ExchangeRule;
import com.zyyj.service.credit.ExchangeRuleService;

/**
 * 积分兑换规则模块的controller，只负责接收请求和响应，
 * 其他数据库等操作转到Service完成
 * @author Jay
 *
 */
@Controller
public class ExchangeRuleController {
	
	@Autowired
	private ExchangeRuleService exchangeRuleService;
	/*@Autowired
	private HttpServletRequest request;*/
	
	/**
	 * 接收添加新规则的请求
	 * @param exchangeRule
	 * @param map
	 * @return
	 */
	@RequestMapping(value="addExchangeRule", method=RequestMethod.POST)
	public String addExchangeRule(ExchangeRule exchangeRule, Map<String, Object> map) {
		exchangeRuleService.addExchangeRule(exchangeRule);
		
		map.put("externalPage", "credit/exchangerule.jsp");
		
		return "redirect:admin";
		// 后期登录模块完成后，通过session获取当前用户类型再跳转到teacher或admin主页
		// 当前调试只跳转到admin
		/*User user = (User)request.getSession().getAttribute("user");
		if(user.getPost() == 2) {
			return "redirect:admin.jsp";
		}
		else {
			return "redirect:teacher.jsp";
		}*/
	}
	
	/**
	 * 处理修改请求，接收完整的属性，封装成对象
	 * @param exchangeRule
	 * @param map
	 * @return
	 */
	@RequestMapping(value="updateExchangeRule", method=RequestMethod.POST)
	public String updateExchangeRule(ExchangeRule exchangeRule, Map<String, Object> map) {
		exchangeRuleService.updateExchangeRule(exchangeRule);
		
		map.put("externalPage", "credit/exchangerule.jsp");
		return "redirect:admin";
		// 后期登录模块完成后，通过session获取当前用户类型再跳转到teacher或admin主页
		// 当前调试只跳转到admin
		/*User user = (User)request.getSession().getAttribute("user");
		if(user.getPost() == 2) {
			return "redirect:admin.jsp";
		}
		else {
			return "redirect:teacher.jsp";
		}*/
	}
	
	/**
	 * 处理删除请求，接收rule——id
	 * @param rule_id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="deleteExchangeRule", method=RequestMethod.GET)
	public String deleteExchangeRule(String rule_id, Map<String, Object> map) {
		exchangeRuleService.deleteExchangeRule(rule_id);
		
		map.put("externalPage", "credit/exchangerule.jsp");
		return "redirect:admin";
		// 后期登录模块完成后，通过session获取当前用户类型再跳转到teacher或admin主页
		// 当前调试只跳转到admin
		/*User user = (User)request.getSession().getAttribute("user");
		if(user.getPost() == 2) {
			return "redirect:admin.jsp";
		}
		else {
			return "redirect:teacher.jsp";
		}*/
	}
}
