package com.simpl.parser;

import java.util.List;

/*
 * Reuests can be of type CLRequest, WebRequest, RPC-Request
 */
public interface Command {
	public String getContents() ;
	public List<String> getTokensList();
}
