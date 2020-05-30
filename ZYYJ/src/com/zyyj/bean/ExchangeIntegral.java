package com.zyyj.bean;

public class ExchangeIntegral {
	private int exchange_id;
	private String ruleName;
	private String stuName;
	private int score;
	private int integral;
	
	public ExchangeIntegral() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExchangeIntegral(int exchange_id, String ruleName, String stuName, int score, int integral) {
		super();
		this.exchange_id = exchange_id;
		this.ruleName = ruleName;
		this.stuName = stuName;
		this.score = score;
		this.integral = integral;
	}
	public int getExchange_id() {
		return exchange_id;
	}
	public void setExchange_id(int exchange_id) {
		this.exchange_id = exchange_id;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	@Override
	public String toString() {
		return "ExchangeIntegral [exchange_id=" + exchange_id + ", ruleName=" + ruleName + ", stuName=" + stuName
				+ ", score=" + score + ", integral=" + integral + "]";
	}
	
	
	
}
