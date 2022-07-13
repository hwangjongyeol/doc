package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "체결 내역 결과 Entity", value = "KorbitTransactionsOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitTransactionsOutEntity implements Serializable {
	
	private static final long serialVersionUID = 8749480451635450185L;

	@ApiModelProperty(value="최종 체결 시각", example="1656318705487")
    private Long timestamp;
	
	@ApiModelProperty(value="체결 일련 번호.", example="22546")
    private String tid;
	
	@ApiModelProperty(value="체결 가격.", example="569000")
    private String price;
	
	@ApiModelProperty(value="체결 수량.", example="0.01000000")
    private String amount;

	@ApiModelProperty(value="taker 주문의 매수/매도 타입.", example="buy")
    private String type;
	
}
