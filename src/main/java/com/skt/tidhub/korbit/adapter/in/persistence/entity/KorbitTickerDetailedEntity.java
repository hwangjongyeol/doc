package com.skt.tidhub.korbit.adapter.in.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "시장 현황 상세정보 Entity", value = "KorbitTickerDetailedEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitTickerDetailedEntity implements Serializable {

	private static final long serialVersionUID = 6501486498868825593L;
	
	@ApiModelProperty(value="요청할 통화(defalut:btc_krw)", required=false, example="btc_krw", dataType="String")
    private String currency_pair = "btc_krw";

}
