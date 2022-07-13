package com.skt.tidhub.utils;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class MessageAccessUtil {
	@Autowired
	private MessageSourceAccessor messageSource;

	public String getMessage(String code, Object[] objs) {
		try {
			return messageSource.getMessage(code, objs, Locale.KOREA);
		} catch(org.springframework.context.NoSuchMessageException nsme) {
			nsme.printStackTrace();
			return "";
		}
	}
}
