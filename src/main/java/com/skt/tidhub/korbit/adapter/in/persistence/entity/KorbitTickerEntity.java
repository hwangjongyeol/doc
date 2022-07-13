package com.skt.tidhub.korbit.adapter.in.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "최종 체결 가격 Entity", value = "KorbitTickerEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitTickerEntity implements Serializable {

	private static final long serialVersionUID = -3757984543825546111L;
	
	@ApiModelProperty(value="요청할 통화(defalut:btc_krw)", required=false, example="btc_krw", dataType="String")
    private String currency_pair;
}
