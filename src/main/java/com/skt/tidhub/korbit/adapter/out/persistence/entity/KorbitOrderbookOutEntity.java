package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "매수/매도 호가 결과 Entity", value = "KorbitOrderbookOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitOrderbookOutEntity implements Serializable {

	private static final long serialVersionUID = 6805835222772162792L;

	@ApiModelProperty(value="최종 체결 시각", example="1656318705487")
    private Long timestamp;
	
	@ApiModelProperty(value="[가격, 미체결잔량]으로 구성된 개별 호가를 나열한다. 3번째 값은 더이상 지원하지 않고 항상 1로 세팅된다.", example="[\"1000000\", \"0.01000000\", \"1\"]")
    private List asks;
	
	@ApiModelProperty(value="[가격, 미체결잔량]으로 구성된 개별 호가를 나열한다. 3번째 값은 더이상 지원하지 않고 항상 1로 세팅된다.", example="[\"568500\", \"2.00000000\", \"1\"]")
    private List bids;
}
