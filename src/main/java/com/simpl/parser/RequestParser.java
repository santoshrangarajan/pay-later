package com.simpl.parser;

import com.simpl.request.Request;
import com.simpl.request.PayLaterRequest;

public interface RequestParser {
	
	public PayLaterRequest parseRequest(Request request) throws Exception;

}
