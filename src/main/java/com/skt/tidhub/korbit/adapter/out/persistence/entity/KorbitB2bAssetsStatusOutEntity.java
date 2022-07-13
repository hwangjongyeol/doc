package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "사용자 보유 자산 조회(자산의 입출금, 거래 가능 상태 정보) Entity", value = "KorbitB2bAssetsStatusOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitB2bAssetsStatusOutEntity implements Serializable {

	private static final long serialVersionUID = 8663974654890700016L;

	@ApiModelProperty(value="자산의 입금 가능 상태",  example="true")
    private String depositable;

	@ApiModelProperty(value="자산의 출금 가능 상태",  example="true")
    private String withdrawable;
	
	@ApiModelProperty(value="자산의 거래 가능 상태",  example="true")
    private String tradable;

}
