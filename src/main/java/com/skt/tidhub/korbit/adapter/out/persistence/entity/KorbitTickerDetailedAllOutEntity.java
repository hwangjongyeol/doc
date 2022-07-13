package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "모든 시장 현황 상세 정보 결과 Entity", value = "KorbitTickerDetailedAllOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitTickerDetailedAllOutEntity implements Serializable {
	
	private static final long serialVersionUID = 6138886140300287957L;

	@ApiModelProperty(value="최종 체결 시각", example="1656318705487")
    private Long timestamp;
	
	@ApiModelProperty(value="최종 체결 가격", example="27675000")
    private String last;
	
	@ApiModelProperty(value="최근 24시간 시작 가격", example="9500000")
    private String open;
	
	@ApiModelProperty(value="매수호가. 현재 매수 주문 중 가장 높은 가격.", example="9192500")
    private String bid;
	
	@ApiModelProperty(value="매도호가. 현재 매도 주문 중 가장 낮은 가격.", example="9198000")
    private String ask;
	
	@ApiModelProperty(value="최저가. 최근 24시간 동안의 체결 가격 중 가장 낮 가격.", example="9171500")
    private String low;
	
	@ApiModelProperty(value="최고가. 최근 24시간 동안의 체결 가격 중 가장 높은 가격.", example="9599000")
    private String high;
	
	@ApiModelProperty(value="거래량.", example="1539.18571988")
    private String volume;
	
	@ApiModelProperty(value="시작 가격 대비 현재가 차이.", example="-301500")
    private String change;
	
	@ApiModelProperty(value="시작 가격 대비 현재가 차이 변화 비율.", example="-3.17")
    private String changePercent;
}
