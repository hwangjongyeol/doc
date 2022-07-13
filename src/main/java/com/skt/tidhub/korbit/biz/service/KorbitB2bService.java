package com.skt.tidhub.korbit.biz.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skt.tidhub.domain.common.ResponseMessage;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitB2bAuthEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitB2bAuthGrantCodeEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitB2bAuthVerifyTokenEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.KorbitB2bPersistenceAdapter;
import com.skt.tidhub.restfull.RestfulKorbitUtil;
import com.skt.tidhub.utils.StringUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KorbitB2bService  {
	
	private final KorbitB2bPersistenceAdapter korbitB2bPersistenceAdapter;
	
	private final RestfulKorbitUtil restfulKorbitUtil;
	
	// 인증 코드(grant_code) 발급
	public ResponseEntity selectGrantCode(KorbitB2bAuthGrantCodeEntity entity) throws Exception {
		ResponseMessage resultList = korbitB2bPersistenceAdapter.selectClientCredentials(StringUtil.getMap(entity));
        
        return new ResponseEntity(resultList, HttpStatus.OK);
	}

	// 액세스 토큰 & 리프레시 토큰 발급
	public ResponseEntity selectAuthToken(KorbitB2bAuthEntity entity) throws Exception {
		ResponseMessage resultList = korbitB2bPersistenceAdapter.selectAuthToken(StringUtil.getMap(entity));
        
        return new ResponseEntity(resultList, HttpStatus.OK);
	}

	// 액세스 토큰 검증
	public ResponseEntity selectVerifyAccesstokenRequest(KorbitB2bAuthVerifyTokenEntity entity) throws Exception {
		ResponseMessage resultList = korbitB2bPersistenceAdapter.selectVerifyAccesstokenRequest(StringUtil.getMap(entity));
        
        return new ResponseEntity(resultList, HttpStatus.OK);
	}

	// 사용자 보유 자산 조회
	public ResponseEntity selectUserAssets(String authorization) throws Exception {
		ResponseMessage resultList = korbitB2bPersistenceAdapter.selectUserAssets(StringUtil.getMap(null), authorization);
        
        return new ResponseEntity(resultList, HttpStatus.OK);
	}

	// 자산 목록 조회
	public ResponseEntity selectUserExchange(String authorization) throws Exception {
		ResponseMessage resultList = korbitB2bPersistenceAdapter.selectUserExchange(StringUtil.getMap(null), authorization);
        
        return new ResponseEntity(resultList, HttpStatus.OK);
	}
}
