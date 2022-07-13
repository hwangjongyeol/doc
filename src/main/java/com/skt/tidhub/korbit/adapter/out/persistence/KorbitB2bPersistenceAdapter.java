package com.skt.tidhub.korbit.adapter.out.persistence;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import com.skt.tidhub.constants.KorbitConstants;
import com.skt.tidhub.domain.common.ResponseMessage;
import com.skt.tidhub.restfull.RestfulKorbitUtil;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class KorbitB2bPersistenceAdapter  {
	
	private final RestfulKorbitUtil restfulKorbitUtil;
	 
	@Value("${korbit.b2b.url}")
	private String  korbitApiB2bUrl;
	
	@Value("${korbit.b2b.client-id}")
	private String  clientId;
	
	// 인증 코드(grant_code) 발급
    public ResponseMessage selectClientCredentials(Map<String, Object> map) throws Exception {
    	map.put("client_id", clientId);
    	return restfulKorbitUtil.getRestApi(HttpMethod.POST, korbitApiB2bUrl + KorbitConstants.Url.B2B_OAUTH2_GRANT_CODE, map, null, Map.class);
    }

    // 액세스 토큰 & 리프레시 토큰 발급
	public ResponseMessage selectAuthToken(Map<String, Object> map) throws Exception {
    	return restfulKorbitUtil.getRestApi(HttpMethod.POST, korbitApiB2bUrl + KorbitConstants.Url.B2B_OAUTH2_TOKEN, map, null, Map.class);
	}

	// 액세스 토큰 검증
	public ResponseMessage selectVerifyAccesstokenRequest(Map<String, Object> map) throws Exception {
    	return restfulKorbitUtil.getRestApi(HttpMethod.POST, korbitApiB2bUrl + KorbitConstants.Url.B2B_OAUTH2_TOKEN, map, null, Map.class);
	}

	// 사용자 보유 자산 조회
	public ResponseMessage selectUserAssets(Map<String, Object> map, String authorization) throws Exception {
		return restfulKorbitUtil.getRestApi(HttpMethod.POST, korbitApiB2bUrl + KorbitConstants.Url.B2B_USER_ASSETS, map, authorization, Map.class);
	}

	// 자산 목록 조회
	public ResponseMessage selectUserExchange(Map<String, Object> map, String authorization) throws Exception {
		return restfulKorbitUtil.getRestApi(HttpMethod.POST, korbitApiB2bUrl + KorbitConstants.Url.B2B_USER_EXCHANGE, map, authorization, Map.class);
	}
    
}
