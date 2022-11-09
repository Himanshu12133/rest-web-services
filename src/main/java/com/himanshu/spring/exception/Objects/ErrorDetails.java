package com.himanshu.spring.exception.Objects;

import java.time.LocalDateTime;

public class ErrorDetails {
	String message;
	LocalDateTime time;
	public ErrorDetails(String message, LocalDateTime time, String detail) {
		super();
		this.message = message;
		this.time = time;
		this.detail = detail;
	}

	String detail;

	public String getMessage() {
		return message;
	}

	

	public LocalDateTime getTime() {
		return time;
	}



	public void setTime(LocalDateTime time) {
		this.time = time;
	}



	public String getDetail() {
		return detail;
	}



	public void setDetail(String detail) {
		this.detail = detail;
	}



	public void setMessage(String message) {
		this.message = message;
	}
}
