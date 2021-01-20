package com.simpl.request.cli;

import java.util.Arrays;
import java.util.List;

import com.simpl.parser.Command;

public class CLICommand  implements Command {

	
	//public  List<String> requestTypeList = Arrays.asList("");
	
	private String contents;
	private List<String> tokensList;
	
	
	
	public CLICommand(String line) {
		this.contents=line;
		this.tokensList = Arrays.asList(line.split("\\s"));
	}



	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public List<String> getTokensList() {
		return tokensList;
	}

	public void setTokensList(List<String> tokensList) {
		this.tokensList = tokensList;
	}
	
	
	
	
	
}