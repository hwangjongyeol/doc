package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "사용자 보유 자산 조회(자산의 티커 정보) Entity", value = "KorbitB2bAssetsTickerOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitB2bAssetsTickerOutEntity implements Serializable {
	
	private static final long serialVersionUID = 996806942864110487L;

	@ApiModelProperty(value="최종 체결 가격",  example="21000000")
    private Double closePrice;

	@ApiModelProperty(value="시작 가격 대비 현재가 차이 변화 비율",  example="0")
    private Double changeRate;
}
