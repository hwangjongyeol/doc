package com.skt.tidhub.korbit.adapter.in.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "체결 내역 Entity", value = "KorbitTransactionsEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitTransactionsEntity implements Serializable {

	private static final long serialVersionUID = -7569836903949046876L;

	@ApiModelProperty(value="요청할 통화(defalut:btc_krw)", required=false, example="btc_krw", dataType="String")
    private String currency_pair = "btc_krw";
	
	@ApiModelProperty(value="시간타입(defalut: hour, minute, day)", required=false, example="hour", dataType="String")
    private String time = "hour";

}
