package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "사용자 보유 자산 조회(자산의 기본 정보) Entity", value = "KorbitB2bAssetsInfoOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitB2bAssetsInfoOutEntity implements Serializable {
	
	private static final long serialVersionUID = -2484620302834862675L;

	@ApiModelProperty(value="자산 전체 이름 (e.g. Bitcoin)",  example="Bitcoin")
    private String name;

	@ApiModelProperty(value="자산의 심볼 (e.g. BTC)",  example="BTC")
    private String coinSymbol;
	
	@ApiModelProperty(value="crypto, fiat 구분 값",  example="false")
    private String isFiatCurrency;
	
	@ApiModelProperty(value="자산의 심볼 이미지 URL",  example="https://www.korbit.co.kr/images/currencies/btc.png")
    private String logoUri;

}
