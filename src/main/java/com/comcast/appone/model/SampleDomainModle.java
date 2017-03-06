package com.comcast.appone.model;

public class SampleDomainModle {
	private String project;

	private String name;

	private String messages;

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String string) {
		this.messages = string;
	}

	@Override
	public String toString() {
		return "ClassPojo [project = " + project + ", name = " + name + ", messages = " + messages + "]";
	}
}