package com.skt.tidhub.constants;

public class KorbitConstants {
   
	public static final class Url {
		
		// OPEN KORBIT API URL
		public static final String OAUTH2_ACCESS_TOKEN = "/v1/oauth2/access_token";	// 인증
    	public static final String TICKER = "/v1/ticker";	// 최종 체결 가격
    	public static final String TICKER_DETAILED = "/v1/ticker/detailed";	// 시장 현황 상세정보
    	public static final String TICKER_DETAILED_ALL = "/v1/ticker/detailed/all";	// 모든 시장 현황 상세 정보
    	public static final String ORDERBOOK = "/v1/orderbook";	// 매수/매도 호가
    	public static final String TRANSACTIONS = "/v1/transactions";	// 체결 내역
    	public static final String USER_BALANCES = "/v1/user/balances";	// 잔고 조회
    	public static final String USER_ACCOUNTS = "/v1/user/accounts";	// 입출금 지갑 정보 조회
    	public static final String USER_VOLUME = "/v1/user/volume";	// 거래량과 거래 수수료
    	
    	// B2B KORBIT API URL
    	public static final String B2B_OAUTH2_GRANT_CODE = "/v1/auth/oauth2/grant_code";	// 인증 코드(grant_code) 발급
    	public static final String B2B_OAUTH2_TOKEN = "/v1/auth/oauth2/token";	// 액세스 토큰 & 리프레시 토큰 발급
    	public static final String B2B_USER_ASSETS = "/user/v1.0/assets";	// 사용자 보유 자산 조회
    	public static final String B2B_USER_EXCHANGE = " /exchange/v1.0/listings";	// 자산 목록 조회
    	
    }
	
	public static final class Result {
		public static final String GRANT_TYPE = "grant_type";	// 인증 구분 값
		public static final class grant_type {
			public static final String CLIENT_CREDENTIALS = "client_credentials";	// 인증요청 값
			public static final String REFRESH_TOKEN = "refresh_token";			// refresh_token 갱신 값
		}
		
		public static final String CLIENT_ID = "client_id";	// korbit API key
		public static final String CLIENT_SECRET = "client_secret";	// korbit client_secret
		public static final String REFRESH_TOKEN = "refresh_token";	// korbit refresh_token
		
	}
}
