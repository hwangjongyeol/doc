package com.skt.tidhub.korbit.adapter.in.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.skt.tidhub.korbit.adapter.out.persistence.entity.KorbitB2bAssetsOutEntity;
import com.skt.tidhub.korbit.biz.service.KorbitB2bService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@Api(tags = "KORBIT(B2B) - 개인 api 연동")
@RestController
@RequiredArgsConstructor
public class KorbitUserB2bController {

	private final KorbitB2bService korbitB2bService;

	@GetMapping("/korbit/api/v10/user/assets")
    @ApiOperation(value = "사용자 보유 자산 조회", notes = "사용자 보유 자산 조회 조회한다.")
    @ApiResponses({
        @ApiResponse(
            code = 200
            , message = "성공"
            , response = KorbitB2bAssetsOutEntity.class
        )
    })
    public ResponseEntity selectUserAssets(@RequestHeader(value = "Authorization", required = true) String Authorization) throws Exception{
        return korbitB2bService.selectUserAssets(Authorization);
    }
}

