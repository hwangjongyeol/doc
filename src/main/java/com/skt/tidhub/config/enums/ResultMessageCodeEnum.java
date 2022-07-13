package com.skt.tidhub.config.enums;

public enum ResultMessageCodeEnum {
    SUCCESS("0000", "success", "성공입니다."),
    
    COMMON_ERROR_0001("0001", "common.error.0001", "필수 파라미터 오류입니다."),
    COMMON_ERROR_0002("0002", "common.error.0002", "404 Not Found."),
    COMMON_ERROR_0003("0003", "common.error.0003", "Method Not Allowed"),
    COMMON_ERROR_0004("0004", "common.error.0004", "Not Acceptable"),
    COMMON_ERROR_0005("0005", "common.error.0005", "Request Timeout"),
    COMMON_ERROR_0006("0006", "common.error.0006", "Unsupported Media Type"),
    COMMON_ERROR_0007("0007", "common.error.0007", ""),
    COMMON_ERROR_0008("0008", "common.error.0008", ""),
    COMMON_ERROR_0009("0009", "common.error.0009", "서버오류입니다."),
    
    KORBIT_ERROR_1001("1001", "korbit.error.1001", "korbit 인증 오류입니다."),
    KORBIT_ERROR_1002("1002", "korbit.error.1002", "korbit 연동 오류입니다."),
    KORBIT_ERROR_1003("1003", "korbit.error.1003", ""),
    KORBIT_ERROR_1004("1004", "korbit.error.1004", ""),
    KORBIT_ERROR_1005("1005", "korbit.error.1005", "")
    ;
    
	private final String value;
	private final String code;
	private final String desc;
	
    private ResultMessageCodeEnum(String code, String value, String desc) {
    	this.code = code;
        this.value = value;
        this.desc = desc;
    }
	
	public String code() {
		return this.code;
	}
	
	public String value() {
		return this.value;
	}
	
	public String desc() {
		return this.desc;
	}
}

