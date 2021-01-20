package com.simpl.controller;

import com.simpl.request.Request;
import com.simpl.request.PayLaterRequest;
import com.simpl.response.Response;
import com.simpl.response.SimplResponse;

public interface PayLaterController {	
	
	public SimplResponse processRequest(PayLaterRequest request);
}
