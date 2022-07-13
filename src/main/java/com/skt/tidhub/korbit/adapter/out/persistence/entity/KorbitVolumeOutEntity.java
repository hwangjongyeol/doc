package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "거래량과 거래 수수료 결과 Entity", value = "KorbitVolumeOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitVolumeOutEntity implements Serializable {

	private static final long serialVersionUID = 4457057674405751263L;

	@ApiModelProperty(value="해당 통화쌍.",  example="btc_krw")
    private String currency_pair;

	@ApiModelProperty(value="해당 통화쌍의 30일간의 거래량(KRW).",  example="17570000")
    private String volume;
	
	@ApiModelProperty(value="베이시스 포인트(BPS - 1/100 퍼센트 기준)로 표기된 maker 거래 수수료율.",  example="0.00100000")
    private String maker_fee;
	
	@ApiModelProperty(value="베이시스 포인트(BPS - 1/100 퍼센트 기준)로 표기된 taker 거래 수수료율.",  example="0.00200000")
    private String taker_fee;
	
	@ApiModelProperty(value="모든 통화쌍 거래의 거래량 총합(KRW).",  example="24140000")
    private String total_volume;
	
	@ApiModelProperty(value="최종 거래량 및 거래 수수료 산정 시각(매시간에 한번씩 갱신).",  example="1386418990000")
    private Long timestamp;

}
