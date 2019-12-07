package com.whitelist.mysql.exception;

import com.whitelist.mysql.response.CodeMessage;

public class BizException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private CodeMessage codeMessage;

	private String message;
	
	public BizException(CodeMessage codeMessage) {
		this.codeMessage = codeMessage;
	}

	public BizException(CodeMessage codeMessage, String message) {
		super();
		this.codeMessage = codeMessage;
		this.message = message;
	}

	public CodeMessage getCodeMessage() {
		return codeMessage;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String getLocalizedMessage() {
		return super.getLocalizedMessage();
	}
}