package com.skt.tidhub.korbit.adapter.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitBalancesEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitVolumeEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.entity.KorbitAccountsOutEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.entity.KorbitBalancesOutEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.entity.KorbitVolumeOutEntity;
import com.skt.tidhub.korbit.biz.service.KorbitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@Api(tags = "KORBIT(OPEN) - 개인 api 연동")
@RestController
@RequiredArgsConstructor
public class KorbitUserController {

	private final KorbitService korbitService;

	@GetMapping("/korbit/api/v10/user/balances")
    @ApiOperation(value = "잔고 조회", notes = "잔고 조회 조회한다.")
    @ApiResponses({
        @ApiResponse(
            code = 200
            , message = "성공"
            , response = KorbitBalancesOutEntity.class
        )
    })
    public ResponseEntity selectBalances(@RequestHeader(value = "Authorization", required = true) String Authorization, KorbitBalancesEntity entity) throws Exception{
        return korbitService.selectUserBalances(Authorization, entity);
    }
    
	@GetMapping("/korbit/api/v10/user/accounts")
    @ApiOperation(value = "입출금 지갑 정보 조회", notes = "입출금 지갑 정보 조회 조회한다.")
    @ApiResponses({
        @ApiResponse(
            code = 200
            , message = "성공"
            , response = KorbitAccountsOutEntity.class
        )
    })
    public ResponseEntity selectAccounts(@RequestHeader(value = "Authorization", required = true) String Authorization) throws Exception{
        return korbitService.selectUserAccounts(Authorization);
    }
    
	@GetMapping("/korbit/api/v10/user/volume")
    @ApiOperation(value = "거래량과 거래 수수료", notes = "거래량과 거래 수수료 조회한다.")
    @ApiResponses({
        @ApiResponse(
            code = 200
            , message = "성공"
            , response = KorbitVolumeOutEntity.class
        )
    })
    public ResponseEntity selectVolume(KorbitVolumeEntity entity, 
    		@RequestHeader(value = "Authorization", required = true) String Authorization) throws Exception{
        return korbitService.selectUserVolume(entity, Authorization);
    }
}

