package com.simpl.response;

public class SimplTxnResponse implements SimplResponse {

	private String contents;
	

	public void setContents(String contents) {
		this.contents = contents;
	}

	
	@Override
	public String getContents() {
		// TODO Auto-generated method stub
		return contents;
	}

}
