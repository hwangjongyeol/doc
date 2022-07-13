package com.skt.tidhub.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 기존에 validation의 에러와 동일하게 400 에러가 발생하도록 추가
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

	private Error[] errors;
	public ValidationException(String defaultMessage, String field){
		this.errors = new Error[]{new Error(defaultMessage, field)};
	}
	
	public ValidationException(Error[]errors){
		this.errors = errors;
	}
	
	public Error[] getErrors(){
		return errors;
	}
	public static class Error{
		private String defaultMessage;
		private String field;
		
		public Error(String defaultMessage, String field){
			this.defaultMessage = defaultMessage;
			this.field = field;
		}
		
		public String getDefaultMessage(){
			return defaultMessage;
		}
		public String getField(){
			return field;
		}
	}
}

