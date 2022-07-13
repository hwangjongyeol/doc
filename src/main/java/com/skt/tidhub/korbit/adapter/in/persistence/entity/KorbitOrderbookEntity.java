package com.skt.tidhub.korbit.adapter.in.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "매수/매도 호가 Entity", value = "KorbitOrderbookEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitOrderbookEntity implements Serializable {

	private static final long serialVersionUID = -5696163019866428756L;
	
	@ApiModelProperty(value="요청할 통화(defalut:btc_krw)", required=false, example="btc_krw", dataType="String")
    private String currency_pair = "btc_krw";
}
