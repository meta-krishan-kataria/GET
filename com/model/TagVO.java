package com.model;

import org.springframework.stereotype.Component;

@Component
public class TagVO {
	String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "TagVO [text=" + text + "]";
	}

}
