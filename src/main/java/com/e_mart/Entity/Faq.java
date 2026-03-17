package com.e_mart.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Faq {
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	public Faq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Faq(String question, String answer, String status) {
		super();
		this.question = question;
		this.answer = answer;
		this.status = status;
	}
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
	@Override
	public String toString() {
		return "Faq [question=" + question + ", answer=" + answer + ", status=" + status + "]";
	}

}
