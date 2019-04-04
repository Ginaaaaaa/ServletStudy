package com.vigteam.study.vo;

public class LogVo {
	// 필드
	private Long id;
	private String name;
	private String log;
	
	// 기본 생성자
	public LogVo() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	
	// toString
	@Override
	public String toString() {
		return "LogVo [id=" + id + ", name=" + name + ", log=" + log + "]";
	}

}
