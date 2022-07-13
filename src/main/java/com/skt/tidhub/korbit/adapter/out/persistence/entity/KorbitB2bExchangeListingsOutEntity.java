package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "자산 목록 데이터 오브젝트 Entity", value = "KorbitB2bExchangeListingsOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitB2bExchangeListingsOutEntity implements Serializable {

	private static final long serialVersionUID = 5656648760630844681L;

	@ApiModelProperty(value="자산의 ID (e.g. BTC:BTC)",  example="BTC:BTC")
    private String assetId;

	@ApiModelProperty(value="자산 전체 이름 (e.g. Bitcoin)",  example="Bitcoin")
    private String name;
	
	@ApiModelProperty(value="자산의 심볼 (e.g. BTC)",  example="BTC")
    private String coinSymbol;
	
	@ApiModelProperty(value="자산의 컨트랙트 주소 (ERC20 계열만 해당)",  example="null")
    private String contractAddress;
	
	@ApiModelProperty(value="자산의 심볼 이미지 URL",  example="https://www.korbit.co.kr/images/currencies/btc.png")
    private String logoUri;
}
