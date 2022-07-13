package com.skt.tidhub.korbit.adapter.out.persistence;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import com.skt.tidhub.constants.KorbitConstants;
import com.skt.tidhub.domain.common.ResponseMessage;
import com.skt.tidhub.restfull.RestfulKorbitUtil;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class KorbitPersistenceAdapter  {
	
	private final RestfulKorbitUtil restfulKorbitUtil;
	 
	@Value("${korbit.url}")
	private String  korbitApiUrl;
	
	// 인증
    public ResponseMessage selectClientCredentials(Map<String, Object> map) throws Exception {
    	return restfulKorbitUtil.getRestApi(HttpMethod.POST, korbitApiUrl + KorbitConstants.Url.OAUTH2_ACCESS_TOKEN, map, null, Map.class);
    }
    
    // Access Token 갱신
    public ResponseMessage selectRefreshToken(Map<String, Object> map) throws Exception {
    	return restfulKorbitUtil.getRestApi(HttpMethod.POST, korbitApiUrl + KorbitConstants.Url.OAUTH2_ACCESS_TOKEN, map, null, Map.class);
    }

	// 최종 체결 가격
    public ResponseMessage selectTicker(Map<String, Object> map) throws Exception {
    	return restfulKorbitUtil.getRestApi(HttpMethod.GET, korbitApiUrl + KorbitConstants.Url.TICKER, map, null, Map.class);
    }
    
    // 시장 현황 상세정보
    public ResponseMessage selectTickerDetailed(Map<String, Object> map) throws Exception {
    	return restfulKorbitUtil.getRestApi(HttpMethod.GET, korbitApiUrl + KorbitConstants.Url.TICKER_DETAILED, map, null, Map.class);
    }
    
    // 모든 시장 현황 상세 정보
    public ResponseMessage selectTickerDetailedAll(Map<String, Object> map) throws Exception {
    	return restfulKorbitUtil.getRestApi(HttpMethod.GET, korbitApiUrl + KorbitConstants.Url.TICKER_DETAILED_ALL, map, null, Map.class);
    }
    
    // 매수/매도 호가
    public ResponseMessage selectOrderbook(Map<String, Object> map) throws Exception {
    	return restfulKorbitUtil.getRestApi(HttpMethod.GET, korbitApiUrl + KorbitConstants.Url.ORDERBOOK, map, null, Map.class);
    }
    
    // 체결 내역
    public ResponseMessage selectTransactions(Map<String, Object> map) throws Exception {
    	return restfulKorbitUtil.getRestApi(HttpMethod.GET, korbitApiUrl + KorbitConstants.Url.TRANSACTIONS, map, null, String.class);
    }
    
    // 잔고 조회
    public ResponseMessage selectUserBalances(Map<String, Object> map, String authorization) throws Exception {
    	HttpHeaders headers = new HttpHeaders();
    	//headers.add("Authorization", map.);
    	return restfulKorbitUtil.getRestApi(HttpMethod.GET, korbitApiUrl + KorbitConstants.Url.USER_BALANCES, map, authorization, Map.class);
    }
    
    // 입출금 지갑 정보 조회
    public ResponseMessage selectUserAccounts(Map<String, Object> map, String authorization) throws Exception {
    	return restfulKorbitUtil.getRestApi(HttpMethod.GET, korbitApiUrl + KorbitConstants.Url.USER_ACCOUNTS, map, authorization, Map.class);
    }
    
    // 거래량과 거래 수수료
    public ResponseMessage selectUserVolume(Map<String, Object> map, String authorization) throws Exception {
    	return restfulKorbitUtil.getRestApi(HttpMethod.GET, korbitApiUrl + KorbitConstants.Url.USER_VOLUME, map, authorization, Map.class);
    }
}
