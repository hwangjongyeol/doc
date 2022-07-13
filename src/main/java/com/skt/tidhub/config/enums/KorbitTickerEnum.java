package com.skt.tidhub.config.enums;

public enum KorbitTickerEnum {
	kor_one("하모니"),
	kor_btc("비트코인"),
	kor_eth("이더리움"),
	kor_xrp("리플"),
	kor_sol("솔라나"),
	kor_ada("카르다노"),
	kor_doge("도지코인"),
    ;
	private final String value;
    private KorbitTickerEnum(String value) {
        this.value = value;
    }
    
	public String value() {
		return this.value;
	}

}
