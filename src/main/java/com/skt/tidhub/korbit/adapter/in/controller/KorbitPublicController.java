package com.skt.tidhub.korbit.adapter.in.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitOrderbookEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitTickerDetailedEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitTickerEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitTransactionsEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.entity.KorbitOrderbookOutEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.entity.KorbitTickerDetailedAllOutEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.entity.KorbitTickerDetailedOutEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.entity.KorbitTickerOutEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.entity.KorbitTransactionsOutEntity;
import com.skt.tidhub.korbit.biz.service.KorbitService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@Api(tags = "KORBIT(OPEN) - 공개 api 연동")
@RestController
@RequiredArgsConstructor
public class KorbitPublicController {

	private final KorbitService korbitService;

    @GetMapping("/korbit/api/v10/ticker")
    @ApiOperation(value = "최종 체결 가격", notes = "최종 체결 가격을 조회한다.")
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공", response = KorbitTickerOutEntity.class)
        , @ApiResponse(code = 400, message = "Bad Request")
        , @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public ResponseEntity selectTicker(@Valid KorbitTickerEntity entity) throws Exception{
        return korbitService.selectTicker(entity);
    }
    
    @GetMapping("/korbit/api/v10/ticker/detailed")
    @ApiOperation(value = "시장 현황 상세정보", notes = "시장 현황 상세정보 조회한다.")
    @ApiResponses({
        @ApiResponse(
            code = 200
            , message = "성공"
            , response = KorbitTickerDetailedOutEntity.class
        )
    })
    public ResponseEntity selectTickerDetailed(KorbitTickerDetailedEntity entity) throws Exception{
        return korbitService.selectTickerDetailed(entity);
    }
    
    @GetMapping("/korbit/api/v10/ticker/detailed/all")
    @ApiOperation(value = "모든 시장 현황 상세 정보", notes = "모든 시장 현황 상세 정보 조회한다.")
    @ApiResponses({
        @ApiResponse(
            code = 200
            , message = "성공"
            , response = KorbitTickerDetailedAllOutEntity.class
        )
    })
    public ResponseEntity selectTickerDetailedAll() throws Exception{
        return korbitService.selectTickerDetailedAll();
    }
    
    @GetMapping("/korbit/api/v10/orderbook")
    @ApiOperation(value = "매수/매도 호가", notes = "매수/매도 호가 조회한다.")
    @ApiResponses({
        @ApiResponse(
            code = 200
            , message = "성공"
            , response = KorbitOrderbookOutEntity.class
        )
    })
    public ResponseEntity selectOrderbook(KorbitOrderbookEntity entity) throws Exception{
        return korbitService.selectOrderbook(entity);
    }
    
    @GetMapping("/korbit/api/v10/transactions")
    @ApiOperation(value = "체결 내역", notes = "체결 내역 조회한다.")
    @ApiResponses({
        @ApiResponse(
            code = 200
            , message = "성공"
            , response = KorbitTransactionsOutEntity.class
        )
    })
    public ResponseEntity selectTransactions(KorbitTransactionsEntity entity) throws Exception{
        return korbitService.selectTransactions(entity);
    }
}

