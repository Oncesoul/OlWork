package com.once.model;

public class Work {
	int works_id;
	String works_title;
	String works_content;
	String work_tid;
	
	public String getWork_tid() {
		return work_tid;
	}
	public void setWork_tid(String work_tid) {
		this.work_tid = work_tid;
	}
	//choice±í
	int id;
	String title;
	String a;
	String b;
	String c;
	String d;
	String answer;
	int work_id;
	
	//discuss±í
	int discuss_id;
	String discuss_title;
	String discuss_content;
	
	//answeranddiscuss_answer
	int stu_id;
	int answer_id;
	String c_answer;
	
	//grade
	int grade;
	int grade_stu_id;
	int idscuss_id;
	String assess;
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getGrade_stu_id() {
		return grade_stu_id;
	}
	public void setGrade_stu_id(int grade_stu_id) {
		this.grade_stu_id = grade_stu_id;
	}
	public int getIdscuss_id() {
		return idscuss_id;
	}
	public void setIdscuss_id(int idscuss_id) {
		this.idscuss_id = idscuss_id;
	}
	public String getAssess() {
		return assess;
	}
	public void setAssess(String assess) {
		this.assess = assess;
	}
	public String getC_answer() {
		return c_answer;
	}
	public void setC_answer(String c_answer) {
		this.c_answer = c_answer;
	}
	public int getStu_id() {
		return stu_id;
	}
	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}
	public int getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}
	public int getWorks_id() {
		return works_id;
	}
	public void setWorks_id(int works_id) {
		this.works_id = works_id;
	}
	public String getWorks_title() {
		return works_title;
	}
	public void setWorks_title(String works_title) {
		this.works_title = works_title;
	}
	public String getWorks_content() {
		return works_content;
	}
	public void setWorks_content(String works_content) {
		this.works_content = works_content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getWork_id() {
		return work_id;
	}
	public void setWork_id(int work_id) {
		this.work_id = work_id;
	}
	public int getDiscuss_id() {
		return discuss_id;
	}
	public void setDiscuss_id(int discuss_id) {
		this.discuss_id = discuss_id;
	}
	public String getDiscuss_title() {
		return discuss_title;
	}
	public void setDiscuss_title(String discuss_title) {
		this.discuss_title = discuss_title;
	}
	public String getDiscuss_content() {
		return discuss_content;
	}
	public void setDiscuss_content(String discuss_content) {
		this.discuss_content = discuss_content;
	}
	@Override
	public String toString() {
		return "Work [works_id=" + works_id + ", works_title=" + works_title + ", works_content=" + works_content
				+ ", work_tid=" + work_tid + ", id=" + id + ", title=" + title + ", a=" + a + ", b=" + b + ", c=" + c
				+ ", d=" + d + ", answer=" + answer + ", work_id=" + work_id + ", discuss_id=" + discuss_id
				+ ", discuss_title=" + discuss_title + ", discuss_content=" + discuss_content + ", stu_id=" + stu_id
				+ ", answer_id=" + answer_id + ", c_answer=" + c_answer + ", grade=" + grade + ", grade_stu_id="
				+ grade_stu_id + ", idscuss_id=" + idscuss_id + ", assess=" + assess + "]";
	}

}
