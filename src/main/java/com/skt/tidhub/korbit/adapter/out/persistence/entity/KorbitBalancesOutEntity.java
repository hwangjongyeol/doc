package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "잔고 조회 결과 Entity", value = "KorbitBalancesOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitBalancesOutEntity implements Serializable {

	private static final long serialVersionUID = 4942227690030343713L;

	@ApiModelProperty(value="현재 거래 가능한 화폐의 수량.",  example="1.50200000")
    private String available;

	@ApiModelProperty(value="현재 거래중인 화폐의 수량.",  example="0.42000000")
    private String trade_in_use;
	
	@ApiModelProperty(value="현재 출금이 진행중인 화폐의 수량.",  example="0.50280000")
    private String withdrawal_in_use;
	
	@ApiModelProperty(value="코인의 경우 평균 매수 단가",  example="529000")
    private String avg_price;
	
	@ApiModelProperty(value="평균 매수 단가가 계산된 시각",  example="1528944250000")
    private Long avg_price_updated_at;

}
