package com.zyyj.bean;

public class StudentPractice {
	private String practice_id;
	private String student_name;
	private String checkpoint_name;
	private int status;
	private String createtime;
	private int score;
	private String programme_name;
	private String course_name;
	public StudentPractice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentPractice(String practice_id, String student_name, String checkpoint_name, int status,
			String createtime, int score, String programme_name, String course_name) {
		super();
		this.practice_id = practice_id;
		this.student_name = student_name;
		this.checkpoint_name = checkpoint_name;
		this.status = status;
		this.createtime = createtime;
		this.score = score;
		this.programme_name = programme_name;
		this.course_name = course_name;
	}
	public String getPractice_id() {
		return practice_id;
	}
	public void setPractice_id(String practice_id) {
		this.practice_id = practice_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getCheckpoint_name() {
		return checkpoint_name;
	}
	public void setCheckpoint_name(String checkpoint_name) {
		this.checkpoint_name = checkpoint_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getProgramme_name() {
		return programme_name;
	}
	public void setProgramme_name(String programme_name) {
		this.programme_name = programme_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	@Override
	public String toString() {
		return "StudentPractice [practice_id=" + practice_id + ", student_name=" + student_name + ", checkpoint_name="
				+ checkpoint_name + ", status=" + status + ", createtime=" + createtime + ", score=" + score
				+ ", programme_name=" + programme_name + ", course_name=" + course_name + "]";
	}

	
}
