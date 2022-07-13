package com.skt.tidhub.common.exception;

import lombok.Data;

@Data
public class KorbitApiException extends Exception {

    private static final long serialVersionUID = -3174347661396034745L;

    private String msg;
    private String resultCode;

    public KorbitApiException(String msg, String resultCode) {
        super(msg);
        this.msg = msg;
        this.resultCode = resultCode;
    }

	public KorbitApiException(KorbitApiException e) {
		// TODO Auto-generated constructor stub
	}
}
