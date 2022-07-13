package com.skt.tidhub.korbit.biz.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skt.tidhub.config.enums.ResultMessageCodeEnum;
import com.skt.tidhub.domain.common.ResponseMessage;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitAuthEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitBalancesEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitOrderbookEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitRefreshAuthEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitTickerDetailedEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitTickerEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitTransactionsEntity;
import com.skt.tidhub.korbit.adapter.in.persistence.entity.KorbitVolumeEntity;
import com.skt.tidhub.korbit.adapter.out.persistence.KorbitPersistenceAdapter;
import com.skt.tidhub.restfull.RestfulKorbitUtil;
import com.skt.tidhub.utils.StringUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class KorbitService  {
	
	private final KorbitPersistenceAdapter korbitPersistenceAdapter;
	
	private final RestfulKorbitUtil restfulKorbitUtil;
	
	// 인증
	public ResponseEntity selectClientCredentials(KorbitAuthEntity entity) throws Exception {
        ResponseMessage resultList = korbitPersistenceAdapter.selectClientCredentials(StringUtil.getMap(entity));
        
        return new ResponseEntity(resultList, HttpStatus.OK);
    }
	
	// Access Token 갱신
	public ResponseEntity selectRefreshToken(KorbitRefreshAuthEntity entity) throws Exception {
        ResponseMessage resultList = korbitPersistenceAdapter.selectRefreshToken(StringUtil.getMap(entity));

        return new ResponseEntity(resultList, HttpStatus.OK);
    }

	// 최종 체결 가격
    public ResponseEntity selectTicker(KorbitTickerEntity entity) throws Exception {
        ResponseMessage resultList = korbitPersistenceAdapter.selectTicker(StringUtil.getMap(entity));

        return new ResponseEntity(resultList, HttpStatus.OK);
    }

    // 시장 현황 상세정보
	public ResponseEntity selectTickerDetailed(KorbitTickerDetailedEntity entity) throws Exception {
		ResponseMessage resultList = korbitPersistenceAdapter.selectTickerDetailed(StringUtil.getMap(entity));

        return new ResponseEntity(resultList, HttpStatus.OK);
	}

	// 모든 시장 현황 상세 정보
	public ResponseEntity selectTickerDetailedAll() throws Exception {
		ResponseMessage resultList = korbitPersistenceAdapter.selectTickerDetailedAll(StringUtil.getMap(null));

        return new ResponseEntity(resultList, HttpStatus.OK);
	}

	// 매수/매도 호가
	public ResponseEntity selectOrderbook(KorbitOrderbookEntity entity) throws Exception {
		ResponseMessage resultList = korbitPersistenceAdapter.selectOrderbook(StringUtil.getMap(entity));

        return new ResponseEntity(resultList, HttpStatus.OK);
	}

	// 체결 내역
	public ResponseEntity selectTransactions(KorbitTransactionsEntity entity) throws Exception {
		ResponseMessage resultList = korbitPersistenceAdapter.selectTransactions(StringUtil.getMap(entity));

		JSONParser parser = new JSONParser();
        return new ResponseEntity(
        		ResponseMessage.builder()
                .data(parser.parse((String) resultList.getData()))
                .resultCode(Integer.toString( HttpStatus.OK.value()))
                .resultDetailCode(ResultMessageCodeEnum.SUCCESS.code())
                .resultMessage(ResultMessageCodeEnum.SUCCESS.toString())
                .build(), HttpStatus.OK);
	}

	// 잔고 조회
	public ResponseEntity selectUserBalances(String Authorization, KorbitBalancesEntity entity) throws Exception {
		ResponseMessage resultList = korbitPersistenceAdapter.selectUserBalances(StringUtil.getMap(null), Authorization);
		Map<String, Object> map = (Map) resultList.getData();
		Map<String,Object> resMap = new HashMap<String,Object>();
		
        for (String key: map.keySet()) {
        	Map<String, Object> i = new HashMap<String, Object>();
        	i.putAll((Map<? extends String, ? extends Object>) map.get(key));
            
            boolean addYn = true;
            // 구매한 ticker만 추출한다.
            double available = Double.parseDouble((String) i.get("available"));
            //available = 1.00000001;
            if("Y".equals(entity.getMy_ticker())) {
	            if(available <= 0) {
	            	addYn = false;
	        	}
            }
            
            // 지정한 ticker 만 추가한다.
            if(addYn) {
            	if(StringUtils.isNotEmpty(entity.getTicker())) {
	            	if(!key.equals(entity.getTicker())) {
	            		addYn = false;
	            	} else {
	            		System.out.println("추가할 ticker : " + key );
	            	}
            	}
            }
            
            if(addYn) {
            	i.put("ticker", key);
                //i.put("kor_name", KorbitTickerEnum.kor_btc);
                i.put("image_url", "https://portal-cdn.korbit.co.kr/currencies/icons/ico-coin-"+key+".png");
                
                if("krw".equals(key)) {
 	                	i.put("last_price", 1);
 	                	i.put("my_krw_price", available);
 	                	resMap.put(key, i);
                } else {
	                ResponseMessage lastInfo = korbitPersistenceAdapter.selectTicker(StringUtil.getMap(KorbitTickerEntity.builder().currency_pair(key+"_krw").build()));
	                System.out.println(key +" : " + lastInfo.toString());
	                
	                Map<String, Object> lastMap = (Map) lastInfo.getData();
	                // 상장폐지 종목은 400에러 발생되어 미노출 처리
	                if(ObjectUtils.isNotEmpty(lastMap)) {
	                	i.put("last_price", (String) lastMap.get("last"));
	                	i.put("my_krw_price", available * Double.parseDouble((String) lastMap.get("last")));
	                	resMap.put(key, i);
	                }
                }
            }
        }
		
		JSONParser parser = new JSONParser();
		return new ResponseEntity(
        		ResponseMessage.builder()
                .data(parser.parse(restfulKorbitUtil.ObjectTojsonFormat(resMap)))
                .resultCode(Integer.toString(HttpStatus.OK.value()))
                .resultDetailCode(ResultMessageCodeEnum.SUCCESS.code())
                .resultMessage(ResultMessageCodeEnum.SUCCESS.toString())
                .build(), HttpStatus.OK);
	}

	// 입출금 지갑 정보 조회
	public ResponseEntity selectUserAccounts(String Authorization) throws Exception {
		ResponseMessage resultList = korbitPersistenceAdapter.selectUserAccounts(StringUtil.getMap(null), Authorization);

        return new ResponseEntity(resultList, HttpStatus.OK);
	}

	// 거래량과 거래 수수료
	public ResponseEntity selectUserVolume(KorbitVolumeEntity entity, String Authorization) throws Exception {
		ResponseMessage resultList = korbitPersistenceAdapter.selectUserVolume(StringUtil.getMap(entity), Authorization);

        return new ResponseEntity(resultList, HttpStatus.OK);
	}
}
