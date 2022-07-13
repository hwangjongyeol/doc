package com.skt.tidhub.common.handler;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.UnsupportedMediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.NestedServletException;

import com.skt.tidhub.common.exception.ApiException;
import com.skt.tidhub.common.exception.KorbitApiException;
import com.skt.tidhub.config.enums.ResultMessageCodeEnum;
import com.skt.tidhub.domain.common.ResponseMessage;
import com.skt.tidhub.utils.MessageAccessUtil;

@RestControllerAdvice
@EnableWebMvc
public class CommonExceptionHandler {

	@Autowired
    private MessageAccessUtil messageUtil;
	
	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handle(MethodArgumentNotValidException ex) {
        
		ApiException apiException = ApiException.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(ex.getFieldErrors().get(0).getDefaultMessage())
                .build();

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
	
	// 400 Bad Request
	@ExceptionHandler(value = {BindException.class})
    public Object handleBindException(HttpServletRequest request, BindException ex) throws Exception {
		String field = "";
		for (FieldError element : ex.getFieldErrors()) {
			if(StringUtils.isEmpty(field)) {
				field = element.getField();
			} else {
				field += ", "+element.getField();
			}
		}
		String reultMessage = field + messageUtil.getMessage(ResultMessageCodeEnum.COMMON_ERROR_0001.value(), null);
		return getResponseEntity(HttpStatus.BAD_REQUEST, ResultMessageCodeEnum.COMMON_ERROR_0001.code(), reultMessage);
    }
	
	// 404 Not Found
    @ExceptionHandler(NoHandlerFoundException.class)
    public Object handleHttpNoHandlerFoundException(HttpServletRequest request, NoHandlerFoundException ex) throws Exception {
        String reultMessage = messageUtil.getMessage(ResultMessageCodeEnum.COMMON_ERROR_0002.value(), null);
		return getResponseEntity(HttpStatus.NOT_FOUND, ResultMessageCodeEnum.COMMON_ERROR_0002.code(), reultMessage);
    }
    
	// 405 Method Not Allowed
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handleHttpRequestMethodNotSupportedException(HttpServletRequest req, HttpRequestMethodNotSupportedException ex) throws Exception {
		String reultMessage = messageUtil.getMessage(ResultMessageCodeEnum.COMMON_ERROR_0003.value(), null);
		return getResponseEntity(HttpStatus.METHOD_NOT_ALLOWED, ResultMessageCodeEnum.COMMON_ERROR_0003.code(), reultMessage);
    }
	
	// 406 Not Acceptable
	@ExceptionHandler(value = {HttpMediaTypeNotAcceptableException.class})
    public Object handleHttpMediaTypeNotAcceptableException(HttpServletRequest request, HttpMediaTypeNotAcceptableException ex) throws Exception {
        String reultMessage = messageUtil.getMessage(ResultMessageCodeEnum.COMMON_ERROR_0004.value(), null);
		return getResponseEntity(HttpStatus.NOT_ACCEPTABLE, ResultMessageCodeEnum.COMMON_ERROR_0004.code(), reultMessage);
    }
	
	// 408 Request Timeout
	@ExceptionHandler(value = {RestClientException.class})
    public Object handleRestClientException(HttpServletRequest request, RestClientException ex) throws Exception {
        String reultMessage = messageUtil.getMessage(ResultMessageCodeEnum.COMMON_ERROR_0005.value(), null);
		return getResponseEntity(HttpStatus.REQUEST_TIMEOUT, ResultMessageCodeEnum.COMMON_ERROR_0005.code(), reultMessage);
    }
	
	// 415 Unsupported Media Type
	@ExceptionHandler(value = {UnsupportedMediaType.class})
    public Object handleUnsupportedMediaType(HttpServletRequest request, UnsupportedMediaType ex) throws Exception {
		String reultMessage = messageUtil.getMessage(ResultMessageCodeEnum.COMMON_ERROR_0006.value(), null);
		return getResponseEntity(HttpStatus.UNSUPPORTED_MEDIA_TYPE, ResultMessageCodeEnum.COMMON_ERROR_0006.code(), reultMessage);
    }

	// 500 Internal Server Error
    @ExceptionHandler(Exception.class)
    public Object handleException(HttpServletRequest request, Exception ex) throws Exception {
    	String reultMessage = messageUtil.getMessage(ResultMessageCodeEnum.COMMON_ERROR_0009.value(), null);
		return getResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ResultMessageCodeEnum.COMMON_ERROR_0009.code(), reultMessage);
    }

    // 500 Internal Server Error
    @ExceptionHandler(KorbitApiException.class)
    public Object handleKorbitApiException(KorbitApiException ex, HttpServletRequest req) throws Exception {
    	String reultMessage = messageUtil.getMessage(ResultMessageCodeEnum.KORBIT_ERROR_1001.value(), null);
		return getResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ResultMessageCodeEnum.COMMON_ERROR_0009.code(), reultMessage);
    }
    
    // 500 Internal Server Error
    @ExceptionHandler(MissingRequestHeaderException.class)
    public Object handleMissingRequestHeaderException(MissingRequestHeaderException ex, HttpServletRequest req) throws Exception {
    	String reultMessage = messageUtil.getMessage(ResultMessageCodeEnum.KORBIT_ERROR_1001.value(), null);
		return getResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ResultMessageCodeEnum.COMMON_ERROR_0009.code(), reultMessage);
    }
    
    // JPA 오류
    @ExceptionHandler(NestedServletException.class)
    public Object handleNestedServletException(NestedServletException ex, HttpServletRequest req) throws Exception {
    	System.out.println(ex);
    	System.out.println(ex.getCause().getMessage());
    	String reultMessage = messageUtil.getMessage(ResultMessageCodeEnum.KORBIT_ERROR_1001.value(), null);
		return getResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ResultMessageCodeEnum.COMMON_ERROR_0009.code(), reultMessage);
    }
    
    

    public Object getResponseEntity(HttpStatus resultCode, String resultDetailCode, String resultMessage) throws Exception {
        ResponseMessage response = ResponseMessage.builder()
                .data(null)
                .resultCode(Integer.toString(resultCode.value()))
                .resultDetailCode(resultDetailCode)
                .resultMessage(resultMessage)
                .build();
        return new ResponseEntity<ResponseMessage>(response, resultCode);
    }
}
