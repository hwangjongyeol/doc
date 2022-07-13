package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "사용자 보유 자산 조회 Entity", value = "KorbitB2bAssetsIdOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitB2bAssetsIdOutEntity implements Serializable {
	
	private static final long serialVersionUID = -391500030413308920L;

	@ApiModelProperty(value="보유 자산의 ID (e.g. BTC:BTC)",  example="IuqEWTK09eCLThRCZZSALA0oXC8EI7s")
    private String assetId;
	
	@ApiModelProperty(value="보유 자산 수량",  example="8.02129981")
    private Double totalBalance;
	
	@ApiModelProperty(value="거래 가능 자산 수량",  example="8.02129981")
    private Double transferableBalance;
	
	@ApiModelProperty(value="리플리시 토큰",  example="vn5xoOf4Pzckgn4jQSL9Sb3KxWJvYtm")
    private String refresh_token;
	
	@ApiModelProperty(value="자산의 기본 정보",  example="object")
	private KorbitB2bAssetsInfoOutEntity info;
	
	@ApiModelProperty(value="자산의 입출금, 거래 가능 상태 정보",  example="object")
	private KorbitB2bAssetsStatusOutEntity status;
	
	@ApiModelProperty(value="자산의 티커 정보",  example="object")
	private KorbitB2bAssetsTickerOutEntity ticker;
	

}
