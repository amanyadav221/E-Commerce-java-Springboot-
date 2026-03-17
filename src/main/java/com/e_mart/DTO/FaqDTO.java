package com.e_mart.DTO;

public class FaqDTO {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private String question;
	private String answer;
	private String status;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public FaqDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FaqDTO(String question, String answer, String status) {
		super();
		this.question = question;
		this.answer = answer;
		this.status = status;
	}
	@Override
	public String toString() {
		return "FaqDTO [question=" + question + ", answer=" + answer + ", status=" + status + "]";
	}
}
