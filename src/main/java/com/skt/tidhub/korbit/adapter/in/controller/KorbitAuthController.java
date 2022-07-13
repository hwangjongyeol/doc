package com.skt.tidhub.korbit.adapter.in.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitAuthEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitRefreshAuthEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.entity.KorbitAuthOutEntity;
import com.skt.tidhub.korbit.biz.service.KorbitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@Api(tags = "KORBIT(OPEN) - 인증 api 연동")
@RestController
@RequiredArgsConstructor
public class KorbitAuthController {

	private final KorbitService korbitService;

	@PostMapping("/korbit/api/v10/clientCredentials")
    @ApiOperation(value = "인증", notes = "Access Token, Refresh Token 획득 한다.")
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공", response = KorbitAuthOutEntity.class)
        , @ApiResponse(code = 400, message = "Bad Request")
        , @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity selectClientCredentials(@Valid KorbitAuthEntity entity) throws Exception{
        return korbitService.selectClientCredentials(entity);
    }
    
	@PostMapping("/korbit/api/v10/refreshToken")
    @ApiOperation(value = "Access Token 갱신", notes = "Access Token 갱신 한다.")
    @ApiResponses({
        @ApiResponse(
            code = 200
            , message = "성공"
            , response = KorbitAuthOutEntity.class
        )
    })
    public ResponseEntity selectRefreshToken(@Valid KorbitRefreshAuthEntity entity) throws Exception{
        return korbitService.selectRefreshToken(entity);
    }
}
