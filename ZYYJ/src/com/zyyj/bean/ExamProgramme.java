package com.zyyj.bean;

public class ExamProgramme {
	private String exam_id;
	private String name;
	private int total_question;
	private int total_score;
	private int pass_score;
	private String question_num;
	private int limit_time;
	private String createdate;
	public ExamProgramme() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ExamProgramme(String exam_id, String name, int total_question, int total_score, int pass_score,
			String question_num, int limit_time, String createdate) {
		super();
		this.exam_id = exam_id;
		this.name = name;
		this.total_question = total_question;
		this.total_score = total_score;
		this.pass_score = pass_score;
		this.question_num = question_num;
		this.limit_time = limit_time;
		this.createdate = createdate;
	}

	public String getExam_id() {
		return exam_id;
	}
	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal_question() {
		return total_question;
	}
	public void setTotal_question(int total_question) {
		this.total_question = total_question;
	}
	public int getTotal_score() {
		return total_score;
	}
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	public int getPass_score() {
		return pass_score;
	}
	public void setPass_score(int pass_score) {
		this.pass_score = pass_score;
	}
	public String getQuestion_num() {
		return question_num;
	}
	public void setQuestion_num(String question_num) {
		this.question_num = question_num;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	
	@Override
	public String toString() {
		return "ExamProgramme [exam_id=" + exam_id + ", name=" + name + ", total_question=" + total_question
				+ ", total_score=" + total_score + ", pass_score=" + pass_score + ", question_num=" + question_num
				+ ", limit_time=" + limit_time + ", createdate=" + createdate + "]";
	}

	public int getLimit_time() {
		return limit_time;
	}
	public void setLimit_time(int limit_time) {
		this.limit_time = limit_time;
	}
	
	
}
