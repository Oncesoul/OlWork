package com.once.model;

public class Answer {
	private String answer;
	
	private int answer_id;

	private int stu_id;
	

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	@Override
	public String toString() {
		return "Answer [answer=" + answer + ", answer_id=" + answer_id + ", stu_id=" + stu_id + "]";
	}


}
