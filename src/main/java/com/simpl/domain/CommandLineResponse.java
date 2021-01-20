package com.simpl.domain;

import com.simpl.response.Response;

public class CommandLineResponse implements Response {

	String contents;

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
}
