package com.skt.tidhub.korbit.adapter.in.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitB2bAuthEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitB2bAuthGrantCodeEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitB2bAuthVerifyTokenEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.entity.KorbitB2bAuthGrantCodeOutEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.entity.KorbitB2bAuthOutEntity;
import com.skt.tidhub.korbit.biz.service.KorbitB2bService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@Api(tags = "KORBIT(B2B) - 인증 api 연동")
@RestController
@RequiredArgsConstructor
public class KorbitAuthB2bController {

	private final KorbitB2bService KorbitB2bService;

	@PostMapping("/korbit/api/v10/auth/grant-code")
    @ApiOperation(value = "인증 코드(grant_code) 발급", notes = "인증 코드(grant_code) 발급 한다.")
    @ApiResponses({
        @ApiResponse(
            code = 200
            , message = "성공"
            , response = KorbitB2bAuthGrantCodeOutEntity.class
        )
    })
    public ResponseEntity selectGrantCode(@Valid KorbitB2bAuthGrantCodeEntity entity) throws Exception{
        return KorbitB2bService.selectGrantCode(entity);
    }
	
	@PostMapping("/korbit/api/v10/auth/token")
    @ApiOperation(value = "액세스 토큰 & 리프레시 토큰 발급", notes = "액세스 토큰 & 리프레시 토큰 발급 한다.")
    @ApiResponses({
        @ApiResponse(
            code = 200
            , message = "성공"
            , response = KorbitB2bAuthOutEntity.class
        )
    })
    public ResponseEntity selectAuthToken(@Valid KorbitB2bAuthEntity entity) throws Exception{
        return KorbitB2bService.selectAuthToken(entity);
    }
	
	@PostMapping("/korbit/api/v10/auth/verify-accesstoken")
    @ApiOperation(value = "액세스 토큰 검증", notes = "액세스 토큰 검증 한다.")
    @ApiResponses({
        @ApiResponse(
            code = 200
            , message = "성공"
            , response = KorbitB2bAuthGrantCodeOutEntity.class
        )
    })
    public ResponseEntity selectVerifyAccesstokenRequest(@Valid KorbitB2bAuthVerifyTokenEntity entity) throws Exception{
        return KorbitB2bService.selectVerifyAccesstokenRequest(entity);
    }
    
}
