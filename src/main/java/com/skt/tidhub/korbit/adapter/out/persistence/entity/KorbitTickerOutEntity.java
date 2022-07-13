package com.skt.tidhub.korbit.adapter.out.persistence.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(description = "최종 체결 가격 결과 Entity", value = "KorbitTickerOutEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KorbitTickerOutEntity implements Serializable {

	
	private static final long serialVersionUID = 966736369134945549L;
	
	@ApiModelProperty(value="최종 체결 시각", example="1656318705487")
    private Long timestamp;
	
	@ApiModelProperty(value="최종 체결 가격", example="27675000")
    private String last;

}
