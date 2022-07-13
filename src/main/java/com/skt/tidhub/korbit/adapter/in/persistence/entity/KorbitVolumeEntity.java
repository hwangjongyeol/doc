package com.skt.tidhub.korbit.adapter.in.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "거래량과 거래 수수료 Entity", value = "KorbitVolumeEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitVolumeEntity implements Serializable {

	private static final long serialVersionUID = 8653759606352065365L;
	
	@ApiModelProperty(value="요청할 통화(defalut:btc_krw)", required=false, example="btc_krw", dataType="String")
    private String currency_pair = "btc_krw";
}
